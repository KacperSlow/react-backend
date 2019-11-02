package pw.react.backend.reactbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pw.react.backend.reactbackend.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,String> {
    User findByLogin(String indexNumber);
}
