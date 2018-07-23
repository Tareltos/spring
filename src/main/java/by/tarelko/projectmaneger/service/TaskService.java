package by.tarelko.projectmaneger.service;

import by.tarelko.projectmaneger.entity.ListType;
import by.tarelko.projectmaneger.entity.Task;
import by.tarelko.projectmaneger.repository.TaskRepository;
import by.tarelko.projectmaneger.service.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    public List<Task> findByListNameBoardNameAndUserId(String task, String name, int id) {
        return repository.findByTaskList_NameAndTaskList_Board_NameAndTaskList_Board_User_Id(ListType.valueOf(task.toUpperCase()), name, id).orElseThrow(DataNotFoundException::new);
    }


}
