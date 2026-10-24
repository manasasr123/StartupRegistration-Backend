
package com.startup.registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.startup.registration.entity.TeamMember;

@Repository
public interface TeamMemberRepository
        extends JpaRepository<TeamMember, Long> {

    List<TeamMember> findByFounderId(Long founderId);

    void deleteByFounderId(Long founderId);
}
