package org.vendapues.usersapi.service;

import org.vendapues.usersapi.controller.dto.UserDto;
import org.vendapues.usersapi.exception.UserNotFoundException;
import org.vendapues.usersapi.repository.document.User;

import java.util.List;

public interface UserService {
    User create(UserDto userDto );

    User findById( String id ) throws UserNotFoundException;

    User findByEmail( String email ) throws UserNotFoundException;

    List<User> all();

    boolean deleteById( String id );

    User update( UserDto userDto, String id );
}
