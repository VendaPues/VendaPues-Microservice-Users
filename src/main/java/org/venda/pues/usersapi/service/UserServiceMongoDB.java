package org.venda.pues.usersapi.service;

import org.venda.pues.usersapi.controller.dto.UserDto;
import org.venda.pues.usersapi.exception.UserNotFoundException;
import org.venda.pues.usersapi.repository.UserRepository;
import org.venda.pues.usersapi.repository.document.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceMongoDB
    implements UserService
{

    private final UserRepository userRepository;

    public UserServiceMongoDB( @Autowired UserRepository userRepository )
    {
        this.userRepository = userRepository;
    }

    @Override
    public User create( UserDto userDto )
    {
        return userRepository.save( new User( userDto ) );
    }

    @Override
    public User findById( String id )
    {
        Optional<User> optionalUser = userRepository.findById( id );
        if ( optionalUser.isPresent() )
        {
            return optionalUser.get();
        }
        else
        {
            throw new UserNotFoundException();
        }
    }

    @Override
    public User findByEmail( String email )
        throws UserNotFoundException
    {
        Optional<User> optionalUser = userRepository.findByEmail( email );
        if ( optionalUser.isPresent() )
        {
            return optionalUser.get();
        }
        else
        {
            throw new UserNotFoundException();
        }
    }

    @Override
    public List<User> all()
    {
        return userRepository.findAll();
    }

    @Override
    public boolean deleteById( String id )
    {
        if ( userRepository.existsById( id ) )
        {
            userRepository.deleteById( id );
            return true;
        }
        return false;
    }

    @Override
    public User update( UserDto userDto, String id )
    {
        if ( userRepository.findById( id ).isPresent() )
        {
            User user = userRepository.findById( id ).get();
            user.update( userDto );
            userRepository.save( user );
            return user;
        }
        return null;
    }
}
