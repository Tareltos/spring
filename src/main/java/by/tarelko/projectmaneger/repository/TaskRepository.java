package by.tarelko.projectmaneger.repository;

import by.tarelko.projectmaneger.entity.ListType;
import by.tarelko.projectmaneger.entity.Task;
import by.tarelko.projectmaneger.entity.TaskList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends CrudRepository<Task, String> {
    Optional<List<Task>> findByTaskList_NameAndTaskList_Board_NameAndTaskList_Board_User_Id(ListType list, String board, int id);


}
