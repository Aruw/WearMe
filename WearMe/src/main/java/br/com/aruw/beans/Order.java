package br.com.aruw.beans;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="TB_ORDER")
public class Order {

    @Id
    @Column(name="ORDER_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int oderID;

    @Column(name="ORDER_TOTAL", nullable=false)
    private BigDecimal total;

    @Column(name="PURCHASE_DATE")
    @Temporal(value=TemporalType.DATE)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private Date purchaseDate;

    @Column(name="DELIVERY_ADDRESS")
    private Address deliveryAddress;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Product> products;

    public Order(){

    }


}