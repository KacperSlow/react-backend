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
    private UserRepository repository;
    @Autowired
    UserService service;
    HttpServletResponse response;
    @PostMapping("")
    public String create(@RequestBody User user) {
        service.CheckUser(user.getLogin());
        repository.save(new User(user.getLogin(), user.getFirstName(), user.getLastName(), user.getActive()));
        return "user is created";
    }
    @GetMapping("/{login}")
    public String search(@PathVariable String login, HttpServletResponse respon ){
        User user = repository.findByLogin(login);
        if(user == null)
        {
            response = respon;
            response.setStatus(404);
            return String.format("User with login: [%s] does not exist",login);
        }
        return "User: " + user.getLogin() + ", " + user.getFirstName()+ ", " + user.getLastName() + ", "+ user.getActive();
    }
}