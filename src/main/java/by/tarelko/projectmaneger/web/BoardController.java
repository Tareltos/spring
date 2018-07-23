package by.tarelko.projectmaneger.web;

import by.tarelko.projectmaneger.entity.Board;
import by.tarelko.projectmaneger.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/{id}")
public class BoardController {

    @Autowired
    private BoardService service;

    @GetMapping(value = "/boards", produces = {MediaType.APPLICATION_JSON_VALUE, //
            MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Board> getBoards(@PathVariable int id) {
        return service.findByUserId(id);
    }

    @PostMapping(value = "/board", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Board updateBoard(@RequestBody Board board, String name) {
        return service.updateBoard(board, name);
    }

    @PutMapping(value = "/newBoard", produces = {MediaType.APPLICATION_JSON_VALUE, //
            MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public Board createBoard(@RequestBody Board board) {
        return service.createNewBoard(board);
    }

    @DeleteMapping(value = "/delete/{board_id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public void deleteEmployee(@PathVariable int board_id) {
        service.deleteBoardById(board_id);
    }
}
