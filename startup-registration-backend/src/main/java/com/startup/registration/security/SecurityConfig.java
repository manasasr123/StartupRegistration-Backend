
package com.startup.registration.security;

import org.springframework.context.annotation.Bean;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
            throws Exception {

        http
            .cors(Customizer.withDefaults())
            .csrf(csrf -> csrf.disable())
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
            	    .requestMatchers(
            	        "/api/founders/register",
            	        "/api/founders/check-email",
            	        "/api/files/upload",
            	        "/api/health",
            	        "/api/founders/login",
            	        "/api/founders/health",
            	        "/api/startups/save",
            	        "/api/startups/founder",
            	        "/api/founder-profiles/save",
            	        "/api/team-members/save",
            	        "/api/registration-documents/**"
            	    ).permitAll()
            	    .anyRequest().authenticated()
            	);

        return http.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
