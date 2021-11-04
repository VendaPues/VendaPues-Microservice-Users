package org.vendapues.usersapi.service;

import dto.UserDto;
import error.exception.NotFoundException;
import error.exception.UserAlreadyRegisteredException;
import models.UserDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vendapues.usersapi.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(@Autowired UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDocument create(UserDto userDto) {
        UserDocument user = userRepository.findByEmail(userDto.getEmail());
        if(user == null){
            return userRepository.save(new UserDocument(userDto));
        }
        throw new UserAlreadyRegisteredException("This email is already registered.");
    }

    public UserDocument findById(String id) {
        UserDocument user = userRepository.findById(id).orElse(null);
        if (user != null) {
            return user;
        }
        throw new NotFoundException("User not found.");
    }

    public UserDocument findByEmail(String email) {
        UserDocument user = userRepository.findByEmail(email);
        if (user != null) {
            return user;
        }
        throw new NotFoundException("User not found.");
    }

    public boolean deleteById(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
}