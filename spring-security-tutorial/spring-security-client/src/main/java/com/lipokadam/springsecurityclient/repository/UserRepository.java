package com.lipokadam.springsecurityclient.repository;

import com.lipokadam.springsecurityclient.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
