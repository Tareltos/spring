package by.tarelko.projectmaneger.repository;

import by.tarelko.projectmaneger.entity.TaskList;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TaskListRepository extends CrudRepository<TaskList, Integer> {


    Optional<List<TaskList>> findByBoard_NameAndBoard_User_Id(String board, int id);


}
