package com.example.auth.AuthenticationApplication.repository;

import com.example.auth.AuthenticationApplication.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Integer> {
    User findByEmailAndPassword(String email , String password);
}
