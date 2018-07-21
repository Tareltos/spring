package by.tarelko.projectmaneger.repository;

import by.tarelko.projectmaneger.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Integer> {
    List<User> findByLogin(String email);


}