package br.com.aruw.beans;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import java.math.BigDecimal;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    @ManyToOne
    @JsonIgnoreProperties("orders")
    @JoinColumn(name="USER_ID", nullable=false)
    private User user;

    @ManyToMany
    @JoinTable(
            name="order_product",
            joinColumns = @JoinColumn(name="oderID"),
            inverseJoinColumns = @JoinColumn(name="productID"))
    private List<Product> products;

    public Order(){

    }

    public Order(int oderID, BigDecimal total, Date purchaseDate, User user, List<Product> products) {
        this.oderID = oderID;
        this.total = total;
        this.purchaseDate = purchaseDate;
        this.user = user;
        this.products = products;
    }

    public int getOderID() {
        return oderID;
    }

    public void setOderID(int oderID) {
        this.oderID = oderID;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

}