package ieti.proyecto.service;

import ieti.proyecto.controller.user.UserDto;
import ieti.proyecto.exception.UserNotFoundException;
import ieti.proyecto.repository.document.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Override
    public User create(UserDto userDto) {
        return null;
    }

    @Override
    public User findById(String id) throws UserNotFoundException {
        return null;
    }

    @Override
    public User findByEmail(String email) throws UserNotFoundException {
        return null;
    }

    @Override
    public List<User> all() {
        return null;
    }

    @Override
    public boolean deleteById(String id) {
        return false;
    }

    @Override
    public User update(UserDto userDto, String id) {
        return null;
    }
}
