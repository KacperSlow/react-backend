package pw.react.backend.reactbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pw.react.backend.reactbackend.Entity.User;
import pw.react.backend.reactbackend.Repository.UserRepository;
import pw.react.backend.reactbackend.Service.UserService;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping(path = "/users")
public class UserController {
    @Autowired
    UserService service;
    @Autowired
    UserRepository repository;

    @PostMapping("")
    public String create(@RequestBody User user) {
        if(service.CheckUser(user.getLogin()) != null)
            return "user of this index already exist";
        repository.save(new User(user.getLogin(), user.getFirstName(), user.getLastName(), user.getActive()));
        return "user is created";
    }


}