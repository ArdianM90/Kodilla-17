package com.kodilla.hibernate.invoice;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "INVOICES")
public class Invoice {
    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    private int id;

    @Column(name = "NUMBER")
    private String number;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ITEMS")
    private Item item; //pozycja nalezaca do tej faktury

    public Invoice() {
    }

    public Invoice(String number) {
        this.number = number;
        this.item = item;
    }

    public int getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public Item getItem() {
        return item;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setNumber(String number) {
        this.number = number;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
