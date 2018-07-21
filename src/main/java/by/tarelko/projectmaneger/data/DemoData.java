package by.tarelko.projectmaneger.data;

import by.tarelko.projectmaneger.entity.User;
import by.tarelko.projectmaneger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DemoData implements ApplicationRunner {

    @Autowired
    UserRepository repository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user = new User(1, "tareltos", "privet");
        User user2 = new User(1, "tareltos2", "privet");
        User user3 = new User(1, "tareltos3", "privet");

        repository.save(user);
        repository.save(user2);
        repository.save(user3);

    }
}