package by.tarelko.projectmaneger.repository;

import by.tarelko.projectmaneger.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByLogin(String email);

    User findByIdIs(int id);

    User findByLoginAndPassword(String login, String password);

    Optional<List<User>> getAllBy();

    Optional<User> getById(int id);

}