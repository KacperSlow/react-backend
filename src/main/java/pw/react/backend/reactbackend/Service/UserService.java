package pw.react.backend.reactbackend.Service;

import pw.react.backend.reactbackend.Entity.User;

public interface UserService {
    User CheckUser(String login);
}
