package org.venda.pues.usersapi.service;

import org.venda.pues.usersapi.controller.user.UserDto;
import org.venda.pues.usersapi.exception.UserNotFoundException;
import org.venda.pues.usersapi.repository.document.User;

import java.util.List;

public interface UserService
{
    User create( UserDto userDto );

    User findById( String id )
        throws UserNotFoundException;

    User findByEmail( String email )
        throws UserNotFoundException;

    List<User> all();

    boolean deleteById( String id );

    User update( UserDto userDto, String id );
}
