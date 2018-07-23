package by.tarelko.projectmaneger.service;

import by.tarelko.projectmaneger.entity.TaskList;
import by.tarelko.projectmaneger.repository.TaskListRepository;
import by.tarelko.projectmaneger.service.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListService {

    @Autowired
    private TaskListRepository repository;

    public List<TaskList> findByProjectNameAndUserId(String project, int id) {

        return repository.findByBoard_NameAndBoard_User_Id(project, id).orElseThrow(DataNotFoundException::new);
    }
}
