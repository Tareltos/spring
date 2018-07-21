package by.tarelko.projectmaneger.controller;

import by.tarelko.projectmaneger.entity.User;
import by.tarelko.projectmaneger.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public Iterable findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/login/{login}")
    public List findByTitle(@PathVariable String login) {
        return userRepository.findByLogin(login);
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable int id) {
        return userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
    }

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Book create(@RequestBody Book book) {
//        return bookRepository.save(book);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        bookRepository.findById(id)
//                .orElseThrow(BookNotFoundException::new);
//        bookRepository.deleteById(id);
//    }
//
//    @PutMapping("/{id}")
//    public Book updateBook(@RequestBody Book book, @PathVariable Long id) {
//        if (book.getId() != id) {
//            throw new BookIdMismatchException();
//        }
//        bookRepository.findById(id)
//                .orElseThrow(BookNotFoundException::new);
//        return bookRepository.save(book);
//    }
}
