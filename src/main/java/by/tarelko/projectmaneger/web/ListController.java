package by.tarelko.projectmaneger.web;


import by.tarelko.projectmaneger.entity.Board;
import by.tarelko.projectmaneger.entity.TaskList;
import by.tarelko.projectmaneger.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/{id}")
public class ListController {

    @Autowired
    private ListService service;

    @GetMapping(value = "/{project}", produces = {MediaType.APPLICATION_JSON_VALUE, //
            MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<TaskList> getLists(@PathVariable int id, @PathVariable String project) {
        return service.findByProjectNameAndUserId(project, id);
    }


}
