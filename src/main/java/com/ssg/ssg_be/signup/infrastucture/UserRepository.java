package com.ssg.ssg_be.signup.infrastucture;

import com.ssg.ssg_be.signup.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
