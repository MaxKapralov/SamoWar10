package project.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.model.data.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByLogin(String login);
    User save(User user);
}
