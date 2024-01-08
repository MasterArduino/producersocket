package com.producer.producersocket.repos;


import com.producer.producersocket.domain.UserAudit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuditRepository extends JpaRepository<UserAudit, Long> {
    Optional<UserAudit> findByUserId(String userId);
}