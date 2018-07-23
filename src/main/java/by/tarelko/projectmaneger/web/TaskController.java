package by.tarelko.projectmaneger.web;


import by.tarelko.projectmaneger.entity.Task;
import by.tarelko.projectmaneger.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/{id}/{name}")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping(value = "/{task}", produces = {MediaType.APPLICATION_JSON_VALUE, //
            MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Task> getTasksByList(Model model, @PathVariable int id, @PathVariable String name, @PathVariable String task) {

        return service.findByListNameBoardNameAndUserId(task, name, id);

    }

}
