package cv.mmix.working.domain;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Vacancy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User employe;

    private String name;
    private String contactPerson;
    private String phoneNumber;
    private String city;
    private int salary;
    private String email;
    private boolean available;
    private Date publicationDate;
    private Date lastModifiedDate;

    @Column(columnDefinition = "TEXT")
    @Lob
    private String description;

    public Vacancy() {
    }

    public Vacancy(User employe, String name, String contactPerson, String phoneNumber, String city, int salary, String email, String description) {
        this.employe = employe;
        this.name = name;
        this.contactPerson = contactPerson;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.salary = salary;
        this.email = email;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getEmploye() {
        return employe;
    }

    public void setEmploye(User employe) {
        this.employe = employe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
