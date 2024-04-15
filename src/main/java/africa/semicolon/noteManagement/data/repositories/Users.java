package africa.semicolon.noteManagement.data.repositories;

import africa.semicolon.noteManagement.data.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Users extends MongoRepository<User, String> {
    User findUserBy(String username);

}
