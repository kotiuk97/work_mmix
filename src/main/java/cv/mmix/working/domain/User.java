package cv.mmix.working.domain;

//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "usr")
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String firstName;
    private String lastName;
    private String companyName;
    private Date registrationDate;
    private Date lastModifiedDate;
    private String imageName;

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

    public boolean isAdmin(){
        return role.equals(Role.ADMIN);
    }

    public boolean isEmployer(){
        return role.equals(Role.EMPLOYER);
    }

    public boolean isUser(){
        return role.equals(Role.USER);
    }

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Arrays.asList(role);
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive();
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

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
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
