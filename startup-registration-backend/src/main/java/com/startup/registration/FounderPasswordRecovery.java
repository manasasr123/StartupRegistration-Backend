
package com.startup.registration;

import com.startup.registration.entity.Founder;
import com.startup.registration.repository.FounderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@Profile("recover-passwords")
public class FounderPasswordRecovery {

    @Bean
    CommandLineRunner recoverFounderPasswords(
            FounderRepository founderRepository,
            PasswordEncoder passwordEncoder) {

        return args -> {
            System.out.println("Starting test-account password recovery...");

            String temporaryPassword = System.getenv("RECOVERY_TEMP_PASSWORD");

            if (temporaryPassword == null
                    || temporaryPassword.length() < 8
                    || temporaryPassword.length() > 72) {
                throw new IllegalStateException(
                    "Set RECOVERY_TEMP_PASSWORD to a password of 8–72 characters."
                );
            }

            int recovered = 0;

            for (Founder founder : founderRepository.findAll()) {
                String currentPassword = founder.getPassword();

                if (currentPassword == null || currentPassword.isBlank()) {
                    founder.setPassword(
                        passwordEncoder.encode(temporaryPassword)
                    );
                    founderRepository.save(founder);
                    recovered++;

                    System.out.println(
                        "Recovered account: " + founder.getEmail()
                    );
                }
            }

            System.out.println(
                "Recovery complete. Accounts updated: " + recovered
            );
        };
    }
}
