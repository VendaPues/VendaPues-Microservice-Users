package org.vendapues.usersapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.vendapues.usersapi.repository.document.User;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email );
}
