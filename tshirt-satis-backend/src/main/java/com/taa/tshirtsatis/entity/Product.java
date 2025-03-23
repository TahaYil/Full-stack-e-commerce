package com.taa.tshirtsatis.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private int quantity;

//    @Column(nullable = false)
//    private String image;
    @Column(nullable = false)
    private byte[] image;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "products_categories" ,
            joinColumns = @JoinColumn(name = "category_id") ,
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Category> categories;

    @ManyToMany(mappedBy = "products")
    private Set<Order> orders;

    @OneToMany(mappedBy = "product")
    private Set<Rewiew> rewies;


    public Product() {}

    public Product(String name, String description, float price, int quantity, byte[] image, Set<Category> categories, Set<Order> orders, Set<Rewiew> rewies) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.categories = categories;
        this.orders = orders;
        this.rewies = rewies;
    }

    public Set<Rewiew> getRewies() {
        return rewies;
    }

    public void setRewies(Set<Rewiew> rewies) {
        this.rewies = rewies;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
