package org.vendapues.users.repository;

import models.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<UserDocument, String> {

    UserDocument findByEmail(String email);
}
