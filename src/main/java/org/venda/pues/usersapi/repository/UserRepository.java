package org.venda.pues.usersapi.repository;

import org.venda.pues.usersapi.repository.document.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail( String email );
}
