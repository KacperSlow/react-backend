package pw.react.backend.reactbackend.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {
    private static final long serialVersionUID = -2343243243242432341L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "indexnumber")
    private  String indexNumber;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "active")
    private String active;
    public Customer(){}
    public Customer(String indexNumber,String firstName, String lastName, String Active) {
        this.indexNumber=indexNumber;
        this.firstName=firstName;
        this.lastName=lastName;
        this.active = Active;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getIndexNumber() {
        return indexNumber;
    }
    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }
    public String getActive() {
        return active;
    }
    public void setActive(String active) {
        this.active = active;
    }

}