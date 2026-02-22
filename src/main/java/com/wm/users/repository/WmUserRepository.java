package com.wm.users.repository;

import com.wm.users.entity.WmUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WmUserRepository extends JpaRepository<WmUser, Long> {
    Optional<WmUser> findByEmail(String email);
}
