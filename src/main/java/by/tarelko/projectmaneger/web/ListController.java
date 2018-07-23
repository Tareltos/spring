package by.tarelko.projectmaneger.web;


import by.tarelko.projectmaneger.entity.TaskList;
import by.tarelko.projectmaneger.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/{id}/{project}")
public class ListController {

    @Autowired
    private ListService service;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE, //
            MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<TaskList> getLists(@PathVariable int id, @PathVariable String project) {
        return service.findByProjectNameAndUserId(project, id);
    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE, //
            MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public TaskList updateList(@PathVariable int id, @PathVariable String board, @RequestBody TaskList list, String name) {
        return service.updateTaskList(list, name);
    }

    @PutMapping(value = "/add", produces = {MediaType.APPLICATION_JSON_VALUE, //
            MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public TaskList addTaskList(@RequestBody TaskList list) {
        return service.addTaskList(list);
    }

    @DeleteMapping(value = "/remove/{list}", produces = {MediaType.APPLICATION_JSON_VALUE, //
            MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public void deleteTaskList(@PathVariable int list) {
        service.deleteList(list);
    }
}
