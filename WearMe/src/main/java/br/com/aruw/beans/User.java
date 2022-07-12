package br.com.aruw.beans;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="TB_USER")
public class User {

    @Id
    @Column(name="USER_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int userID;

    @Column(name="CPF", length=11 ,nullable=false)
    private String cpf;

    @Column(name="EMAIL", length=100 ,nullable=false)
    private String email;

    @Column(name="NAME", length=30 ,nullable=false)
    private String name;

    @Column(name="BIRTHDAY")
    @Temporal(value=TemporalType.DATE)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private Date birthday;

    @Column(name="LAST_NAME", length=30 ,nullable=false)
    private String lastName;

    @Column(name="NICK_NAME", length=30 ,nullable=false)
    private String nickName;

    @Column(name="PASSWORD", length=20 ,nullable=false)
    private String password;

    @Column(name="PHONE_NUMBER", length=11 ,nullable=false)
    private String phoneNumber;

    @JsonIgnoreProperties("user")
    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<Address> addresses;

    @JsonIgnoreProperties("user")
    @ManyToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<Order> orders;

    public User(){

    }

    public User(int userID, String cpf, String email, String name, Date birthday, String lastName, String nickName, String password, String phoneNumber, List<Address> addresses, List<Order> orders) {
        this.userID = userID;
        this.cpf = cpf;
        this.email = email;
        this.name = name;
        this.birthday = birthday;
        this.lastName = lastName;
        this.nickName = nickName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.addresses = addresses;
        this.orders = orders;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

}