package ru.fenris06.repository;

import org.springframework.data.repository.CrudRepository;
import ru.fenris06.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);
}
