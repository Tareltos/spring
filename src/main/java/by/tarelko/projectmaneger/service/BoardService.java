package by.tarelko.projectmaneger.service;


import by.tarelko.projectmaneger.entity.Board;
import by.tarelko.projectmaneger.entity.User;
import by.tarelko.projectmaneger.repository.BoardRepository;
import by.tarelko.projectmaneger.service.exception.DataNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository repository;

    public List<Board> findByUserId(int id) {

        return repository.findByUser_Id(id).orElseThrow(DataNotFoundException::new);
    }

    public Board updateBoard(Board board, String name) {
        board.setName(name);
        return repository.save(board);
    }

    public Board createNewBoard(Board board) {
        return repository.save(board);
    }

    public void deleteBoardById(int boardId) {
        repository.deleteById(boardId);
    }
}
