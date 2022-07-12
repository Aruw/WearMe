package br.com.aruw.beans;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;

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

    @OneToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<Address> addresses;

    @ManyToMany(mappedBy="user", cascade=CascadeType.ALL)
    private List<Order> orders;

    public User(){

    }


}