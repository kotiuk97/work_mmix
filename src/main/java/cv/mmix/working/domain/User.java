package cv.mmix.working.domain;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "usr")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String companyName;
    private Date registrationDate;

    @NotBlank(message = "This field cannot be empty")
    private String phoneNumber;

    @Email(message = "Email is not correct")
    @NotBlank(message = "Email cannot be empty")
    private String email;

    @NotBlank(message = "Password cannot be empty")
    private String password;

//    @Transient
//    private String password2;

    @Enumerated(EnumType.STRING)
    private Role role;

    private boolean active;

//    private String activationCode;
//    private boolean isActive;
//    private boolean isBlocked;

    public User() {
    }

//    private String username;
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }

    public User(@NotBlank(message = "Password cannot be empty") String password, String username, boolean active) {
        this.password = password;
        this.active = active;
    }

    /*    public User(String firstName,
                    String lastName,
                    String companyName,
                    @NotBlank(message = "This field cannot be empty") String phoneNumber,
                    @Email(message = "Email is not correct") @NotBlank(message = "Email cannot be empty") String email,
                    @NotBlank(message = "Password cannot be empty") String password,
                    Role role) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.companyName = companyName;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.password = password;
            this.password2 = password2;
            this.role = role;
        }
    */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

//    public String getActivationCode() {
//        return activationCode;
//    }
//
//    public void setActivationCode(String activationCode) {
//        this.activationCode = activationCode;
//    }
//
//    public boolean isActive() {
//        return isActive;
//    }
//
//    public void setActive(boolean active) {
//        isActive = active;
//    }
//
//    public boolean isBlocked() {
//        return isBlocked;
//    }
//
//    public void setBlocked(boolean blocked) {
//        isBlocked = blocked;
//    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
