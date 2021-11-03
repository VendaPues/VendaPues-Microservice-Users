package org.vendapues.users.service;

import dto.UserDto;
import error.exception.NotFoundException;
import models.UserDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vendapues.users.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDocument create(UserDto userDto) {
        return userRepository.save(new UserDocument(userDto));
    }

    public UserDocument findById(String id) {
        UserDocument user = userRepository.findById(id).orElse(null);
        if (user != null) {
            return user;
        } else {
            throw new NotFoundException("User not found.");
        }
    }

    public UserDocument findByEmail(String email) throws NotFoundException {
        UserDocument user = userRepository.findByEmail(email);
        if (user != null) {
            return user;
        } else {
            throw new NotFoundException("User not found.");
        }
    }

    public boolean deleteById(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
