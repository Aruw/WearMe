package br.com.aruw.beans;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="TB_ADDRESS")
public class Address {

    @Id
    @Column(name="ADDRESS_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int addressId;

    @Column(name="CEP", length=8 ,nullable=false)
    private String cep;

    @Column(name="CITY", length=30 ,nullable=false)
    private String city;

    @Column(name="NUMBER", nullable=false)
    private int number;

    @Column(name="STATE", length=20 ,nullable=false)
    private String state;

    @Column(name="STREET", length=150 ,nullable=false)
    private String street;

    @Column(name="COMPLEMENT", length=100 ,nullable=false)
    private String complement;

    @Column(name="REFERENCE_POINT", length=200 ,nullable=false)
    private String referencePoint;

    @OneToOne(mappedBy="address")
    //@JsonIgnoreProperties("address")
    private User user;

    public Address(){

    }

    public Address(int addressId, String cep, String city, int number, String state, String street, String complement, String referencePoint, User user) {
        this.addressId = addressId;
        this.cep = cep;
        this.city = city;
        this.number = number;
        this.state = state;
        this.street = street;
        this.complement = complement;
        this.referencePoint = referencePoint;
        this.user = user;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    public String getReferencePoint() {
        return referencePoint;
    }

    public void setReferencePoint(String referencePoint) {
        this.referencePoint = referencePoint;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}