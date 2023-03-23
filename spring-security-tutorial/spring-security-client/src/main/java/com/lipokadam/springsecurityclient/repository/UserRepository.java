package com.lipokadam.springsecurityclient.repository;

import com.lipokadam.springsecurityclient.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Long> {

    @Transactional
    @Modifying
    @Query("update User u set u.enabled = true where u.id = ?1")
    void enableUserById(Long id);

    User findUserByEmail(String email);
}
