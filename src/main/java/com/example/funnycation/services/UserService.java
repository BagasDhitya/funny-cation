package com.example.funnycation.service;

import com.example.funnycation.dto.UserDTO;
import com.example.funnycation.models.User;
import com.example.funnycation.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword());
        return userRepository.save(user);
    }

    public User updateUser(Long id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setName(userDTO.getName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            return userRepository.save(user);
        }
        return null;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
