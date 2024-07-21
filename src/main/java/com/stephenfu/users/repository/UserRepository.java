package com.stephenfu.users.repository;

import com.stephenfu.users.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
