package by.tarelko.projectmaneger.web;

import by.tarelko.projectmaneger.entity.User;
import by.tarelko.projectmaneger.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/user/singin")
    public String singIn(Model model, @RequestParam String login, @RequestParam String password) {
        try {
            User user = userService.checkLoginAndPassword(login, password);
            System.out.println(user.getId());
            model.addAttribute("id", user.getId());
            return "welcome";
        } catch (RuntimeException e) {
            model.addAttribute("errorMsg", "Invalid credentials");
        }
        return "home";
    }

    @GetMapping(value = "/users", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<User> getUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/user/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public User getUserById(@PathVariable int id) {
        return userService.getUserById(id);
    }

    @PutMapping(value = "/user/", //
            produces = {MediaType.APPLICATION_JSON_VALUE, //
                    MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public User addUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @DeleteMapping(value = "/user/delete/{id}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public void deleteEmployee(@PathVariable int id) {
        userService.deleteUserById(id);
    }


}
