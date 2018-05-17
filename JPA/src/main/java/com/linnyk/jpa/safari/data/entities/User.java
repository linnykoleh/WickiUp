package com.linnyk.jpa.safari.data.entities;

import org.hibernate.annotations.Formula;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.linnyk.jpa.safari.data.entities.association.Credential;
import com.linnyk.jpa.safari.data.entities.embedded.Address;

@Entity
@Table(name = "FINANCES_USER")
@Access(AccessType.FIELD) //or AccessType.PROPERTY
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "BIRTH_DATE", nullable = false) //not null
    private Date birthDate;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    /*Bidirectional association*/
    @OneToOne(mappedBy = "user") // поле которое есть в другой ентити для связи
    private Credential credential;

    @ElementCollection
    @CollectionTable(
            name = "USER_ADDRESS", //название таблицы
            joinColumns = @JoinColumn(name = "USER_ID")) // имя id нашей таблицы
    @AttributeOverrides({
            @AttributeOverride(name = "addressLine1", column = @Column(name = "USER_ADDRESS_LINE_1")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "USER_ADDRESS_LINE_2"))
    })
    private List<Address> addresses = new ArrayList<>();

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "addressLine1", column = @Column(name = "USER_ADDRESS_LINE_1")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "USER_ADDRESS_LINE_2"))
    })
    private Address address = new Address();

    @Column(name = "LAST_UPDATED_DATE")
    private Date lastUpdatedDate;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @Column(name = "CREATED_DATE", updatable = false) //not using while updating
    private Date createdDate;

    @Column(name = "CREATED_BY", updatable = false) //not using while updating
    private String createdBy;

    @Transient // ignore for persistence
    private boolean valid;

    @Formula(value = "datediff('YEAR', birth_date, curdate())") // http://www.h2database.com/html/functions.html
    private int age;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDay) {
        this.birthDate = birthDay;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddressLine1(String addressLine1) {
        this.address.setAddressLine1(addressLine1);
    }

    public String getAddressLine2() {
        return address.getAddressLine2();
    }

    public void setAddressLine2(String addressLine2) {
        this.address.setAddressLine2(addressLine2);
    }

    public String getCity() {
        return address.getCity();
    }

    public void setCity(String city) {
        this.address.setCity(city);
    }

    public String getState() {
        return address.getState();
    }

    public void setState(String state) {
        this.address.setState(state);
    }

    public String getZipCode() {
        return address.getZipCode();
    }

    public void setZipCode(String zipCode) {
        this.address.setZipCode(zipCode);
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Credential getCredential() {
        return credential;
    }

    public void setCredential(Credential credential) {
        this.credential = credential;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", emailAddress='" + emailAddress + '\'' +
                ", addresses=" + addresses +
                ", address=" + address +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", valid=" + valid +
                ", age=" + age +
                '}';
    }
}
