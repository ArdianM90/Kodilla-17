package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ITEMS")
public class Item {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PRODUCT")
    private Product product; //produkt nalezacy do tej pozycji na fakturze

    @Column(name = "PRICE")
    private BigDecimal price;

    @Column(name = "QUANTITY")
    private int quantity;

    @Column(name = "VALUE")
    private BigDecimal value;

    @OneToMany(
            targetEntity = Invoice.class,
            mappedBy = "item",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<Invoice> invoices = new ArrayList<>();

    public Item() {
    }

    public Item(Product product, BigDecimal price, int quantity, BigDecimal value) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal getValue() {
        return value;
    }

    public List<Invoice> getInvoices() {
        return invoices;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setProduct(Product product) {
        this.product = product;
    }

    private void setPrice(BigDecimal price) {
        this.price = price;
    }

    private void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private void setValue(BigDecimal value) {
        this.value = value;
    }

    private void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }
}
