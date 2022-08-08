package com.ssg.ssg_be.signup.infrastucture;

import com.ssg.ssg_be.signup.domain.User;
import com.ssg.utils.jwt.UserDetailsImpl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLoginId(String loginId);
    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);

    Optional<UserDetailsImpl> findByLoginId(String loginId);
}
