package al.ikubinfo.fjalorth.domain;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = "user")
public class User extends BaseEntity{

    @Column(name = "email")
    @Email(message = "*Ju lutem te vendosni emrin te sakte")
    @NotEmpty(message = "*Ju lutem te vendosni email")
    private String email;

    @Column(name = "username")
    @Length(min = 5, message = "*Ju lutem te vendosni username")
    @NotEmpty(message = "*Please provide your username")
    private String username;

    @Column(name = "password")
    @Length(min = 5, message = "*Passwordi duhet te kete te pakten 5 germa")
    @NotEmpty(message = "*Ju lutem te vendosni passwordin")
    private String password;

    @Column(name = "firstname")
    @NotEmpty(message = "*Ju lutem te vendosni emrin")
    private String firstname;

    @Column(name = "lastname")
    @NotEmpty(message = "*Ju lutem te vendosni mbiemrin")
    private String lastname;

    @Column(name = "active")
    private int active;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
