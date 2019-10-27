package pw.react.backend.reactbackend.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pw.react.backend.reactbackend.Entity.Customer;
import pw.react.backend.reactbackend.Repository.CustomerRepository;


@RestController
public class CustomerController {
    @Autowired
    CustomerRepository repository;
    @PostMapping("/create")
    public String create(@RequestBody Customer customer) {
// save a single Customer
        if(repository.findByIndexNumber(customer.getIndexNumber())!=null)
            return "Customer of this index already exist";
        repository.save(new Customer(customer.getIndexNumber(), customer.getFirstName(), customer.getLastName(), customer.getActive()));
        return "Customer is created";
    }

    @GetMapping("/findbyindexnumber/{indexnumber}")
    public String findByIndexNumber(@PathVariable String indexnumber) {
        Customer customer = repository.findByIndexNumber(indexnumber);
        if (customer == null)
            return "Customer does not exist";
        return customer.toString();
    }
    @GetMapping("/search/{indexnumber}")
    public String Search(@PathVariable String indexnumber) {
        Customer customer = repository.findByIndexNumber(indexnumber);
        if (customer == null)
            return "Customer does not exist";
        return "Customer of this index exist";
    }

    @GetMapping("/delete/{indexnumber}")
    public String Delete(@PathVariable String indexnumber) {
        Customer customer = repository.findByIndexNumber(indexnumber);
        if (customer == null)
            return "There is no Customer with this indexnumber";
        repository.delete(customer);
        return "Customer deleted";
    }
    @PostMapping("/update/{indexnumber}")
    public String Update(@PathVariable String indexnumber, @RequestBody Customer updateCustomer) {
        Customer customer = repository.findByIndexNumber(indexnumber);
        if (customer == null)
            return "There is no Customer with this indexnumber";
        if(updateCustomer.getIndexNumber()== customer.getIndexNumber())
        {
            customer.setFirstName(updateCustomer.getFirstName());
            customer.setLastName(updateCustomer.getLastName());
            customer.setActive(updateCustomer.getActive());
            return "Customer Update: " + customer.toString();
        }
        return "Not this customer you want to update";
    }
}