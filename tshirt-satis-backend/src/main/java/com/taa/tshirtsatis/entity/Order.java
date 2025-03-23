package com.taa.tshirtsatis.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String adress;

    @Column(name = "total_price")
    private float totalPrice;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "orders_products",
        joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id")
    )
    private Set<Product> products;

    @Column(name = "is_active")
    private boolean isActive;

    //@OneToOne
    //private Ordered ordered;

//    public Ordered getOrdered() {
//        return ordered;
//    }
//
//    public void setOrdered(Ordered ordered) {
//        this.ordered = ordered;
//    }


    public Order() {
    }

    public Order(int id, String adress, float totalPrice, Users user, Set<Product> products, boolean isActive) {
        this.id = id;
        this.adress = adress;
        this.totalPrice = totalPrice;
        this.user = user;
        this.products = products;
        this.isActive = isActive;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
