package by.tarelko.projectmaneger.service;


import by.tarelko.projectmaneger.entity.User;
import by.tarelko.projectmaneger.repository.UserRepository;
import by.tarelko.projectmaneger.service.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public User checkLoginAndPassword(String login, String password) {
        return repository.findByLoginAndPassword(login, password);
    }

    public List<User> getAllUsers() {
        return repository.getAllBy().orElseThrow(DataNotFoundException::new);
    }

    public void deleteUserById(int id) {
        repository.deleteById(id);
    }

    public User getUserById(int id) {
        return repository.getById(id).orElseThrow(DataNotFoundException::new);
    }

    public User createUser(User user) {
        return repository.save(user);
    }



}