package pw.react.backend.reactbackend.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pw.react.backend.reactbackend.Entity.Customer;

import java.util.ArrayList;

@Repository
public abstract class CustomerRepositoryImpl implements CustomerRepository {
    @Autowired
    CustomerRepository repository;
    @Override
    public Customer findByIndexNumber(String indexNumber) {
        ArrayList<Customer> customers ;
        customers = (ArrayList<Customer>) repository.findAll();
        for (Customer customer : customers) {
            if (customer.getIndexNumber()!=null && customer.getIndexNumber().equals(indexNumber))
                return customer;
        }
        return null;
    }
}