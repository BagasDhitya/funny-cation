package com.example.funnycation.repositories;

import com.example.funnycation.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
