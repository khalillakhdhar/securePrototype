package com.elitech.repository;

import java.lang.StackWalker.Option;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.elitech.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
Optional<User> findByEmail(String email);
}
