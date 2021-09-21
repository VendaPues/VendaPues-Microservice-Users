package ieti.proyecto.service;

import ieti.proyecto.controller.user.UserDto;
import ieti.proyecto.exception.UserNotFoundException;
import ieti.proyecto.repository.document.User;

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
