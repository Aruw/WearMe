package br.com.aruw.beans;

import javax.persistence.*;

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

    @ManyToOne
    private User user;

    public Address(){

    }



}