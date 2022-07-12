package br.com.aruw.beans;

import java.util.Date;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

import br.com.aruw.enums.Size;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="TB_PRODUCT")
public class Product {

    @Id
    @Column(name="PRODUCT_ID")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int productID;

    @Column(name="SIZE")
    @Enumerated(EnumType.STRING)
    private Size size;

    @Column(name="QUANTITY", nullable=false)
    private int quantity;

    @Column(name="GIFT", nullable=false)
    private boolean gift;

    @Column(name="PRICE", nullable=false)
    private BigDecimal price;

    @Column(name="NAME", length=50 ,nullable=false)
    private String name;

    @Column(name="DETAILS", length=255 ,nullable=false)
    private String details;

    @Column(name="RELEASE")
    @Temporal(value=TemporalType.DATE)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private Date release;

    @Column(name="IMAGE_URL", length=255 ,nullable=false)
    private String imageUrl;

    @ManyToMany
    private List<Order> order;

    public Product(){

    }


}