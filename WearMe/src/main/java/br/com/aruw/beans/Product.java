package br.com.aruw.beans;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import java.math.BigDecimal;
import br.com.aruw.enums.Size;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="TB_PRODUCT")
public class Product {

    @Id
    @Column(name="PRODUCT_ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    @Column(name="NAME", length=50, nullable=false)
    private String name;

    @Column(name="DETAILS", length=255, nullable=false)
    private String details;

    @Column(name="LAUNCHED_DATE", nullable=false)
    @Temporal(value=TemporalType.DATE)
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd/MM/yyyy")
    private Date launchedDate;

    @Column(name="IMAGE_URL", length=255, nullable=false)
    private String imageUrl;

    @ManyToMany(mappedBy="products")
    @JsonIgnoreProperties("products")
    private List<Order> order;

    public Product(){

    }

    public Product(int productID, Size size, int quantity, boolean gift, BigDecimal price, String name, String details, Date launchedDate, String imageUrl, List<Order> order) {
        this.productID = productID;
        this.size = size;
        this.quantity = quantity;
        this.gift = gift;
        this.price = price;
        this.name = name;
        this.details = details;
        this.launchedDate = launchedDate;
        this.imageUrl = imageUrl;
        this.order = order;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isGift() {
        return gift;
    }

    public void setGift(boolean gift) {
        this.gift = gift;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Date getLaunchedDate() {
        return launchedDate;
    }

    public void setLaunchedDate(Date launchedDate) {
        this.launchedDate = launchedDate;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public List<Order> getOrder() {
        return order;
    }

    public void setOrder(List<Order> order) {
        this.order = order;
    }

}