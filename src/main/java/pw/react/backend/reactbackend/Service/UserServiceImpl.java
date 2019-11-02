package pw.react.backend.reactbackend.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import pw.react.backend.reactbackend.Entity.User;
import pw.react.backend.reactbackend.Repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;
    @Override
    public User CheckUser(String login) {
        User user = repository.findByLogin(login);
        if (user != null )
            throw new ResourceNotFoundException(String.format("User with login [%s] is already created.", user.getLogin()));
        return user;
    }
}
