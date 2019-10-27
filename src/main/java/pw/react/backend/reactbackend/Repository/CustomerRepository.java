package pw.react.backend.reactbackend.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pw.react.backend.reactbackend.Entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {
    Customer findByIndexNumber(String indexNumber);
}
