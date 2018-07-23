package by.tarelko.projectmaneger.config;

import by.tarelko.projectmaneger.entity.*;
import by.tarelko.projectmaneger.repository.BoardRepository;
import by.tarelko.projectmaneger.repository.TaskListRepository;
import by.tarelko.projectmaneger.repository.TaskRepository;
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

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    TaskListRepository taskListRepository;


    @Autowired
    TaskRepository taskRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User user = new User("tareltos", "privet");
        User user2 = new User("tareltos2", "privet");
        User user3 = new User("tareltos3", "privet");

        repository.save(user);
        repository.save(user2);
        repository.save(user3);

        Board b1 = new Board("Project1", user);
        Board b2 = new Board("Project2", user);
        Board b3 = new Board("Project3", user2);
        boardRepository.save(b1);
        boardRepository.save(b2);
        boardRepository.save(b3);
        TaskList todo = new TaskList("TODO", b1);
        TaskList doing = new TaskList("DOING", b1);
        TaskList testing = new TaskList("TESTING", b1);
        TaskList done = new TaskList("DONE", b1);
        taskListRepository.save(todo);
        taskListRepository.save(doing);
        taskListRepository.save(testing);
        taskListRepository.save(done);


        Task task = new Task("task1", todo);
        Task task1 = new Task("task2", todo);
        Task task2 = new Task("task3", todo);
        Task task1p1 = new Task("task4", doing);
        Task task2p1 = new Task("task5", testing);
        Task tas = new Task("task6", done);

        taskRepository.save(task);
        taskRepository.save(task1);
        taskRepository.save(task2);
        taskRepository.save(task2p1);
        taskRepository.save(tas);
        taskRepository.save(task1p1);


    }
}