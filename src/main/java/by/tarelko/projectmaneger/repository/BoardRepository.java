package by.tarelko.projectmaneger.repository;

import by.tarelko.projectmaneger.entity.Board;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface BoardRepository extends CrudRepository<Board, Integer> {

    Optional<Board> findById(int id);

    Optional<List<Board>> findByUser_Id(int id);

}