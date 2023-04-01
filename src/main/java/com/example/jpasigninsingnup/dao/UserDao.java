package com.example.jpasigninsingnup.dao;


import com.example.jpasigninsingnup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User,Integer> {
    Optional<User> findUserByUsername(String username);
}
