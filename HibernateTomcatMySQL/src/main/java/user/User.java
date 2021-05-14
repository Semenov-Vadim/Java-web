package user;

 
//import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
@Entity
@Table(name = "s_user")
public class User {
     
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    */
    
    @Column(name = "u_name")
    private String name;

    @Column(unique = true)
    private String surname;

    @Column(unique = true)
    private String email;
    
    @Column(unique = true)
    private String phone;
    
    @Column(name = "u_password")
    private String password;
    
    public User() {
    	
    }
    
    public User(String name, String surname, String email, String phone, String password) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }
     
    /*public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    */

    public String getPassword() {
        return this.password;
    }
     
    public void setPassword(String password) {
        this.password = password;
    }
     
    public String getEmail() {
        return this.email;
    }
 
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }
    
    public String getName() {
        return this.name;
    }
 
    public void setName(String newName) {
        this.name = newName;
    }
    
    public String getSurname() {
        return this.surname;
    }
 
    public void setSurname(String newSurname) {
        this.surname = newSurname;
    }
    
    public String getPhone() {
        return this.phone;
    }
 
    public void setPhone(String newPhone) {
        this.phone = newPhone;
    }
    
    @Override
    public String toString() {
        return "User:\n" +
                "password: " + password + "\n" +
                "name: " + name + "\n" +
                "surname: " + surname + "\n" +
                "phone: " + phone + "\n" +
                "email: " + email + "\n";
    }
}

