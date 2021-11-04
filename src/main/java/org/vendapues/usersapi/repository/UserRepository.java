package org.vendapues.usersapi.repository;

import models.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDocument, String> {

    UserDocument findByEmail(String email);
}
