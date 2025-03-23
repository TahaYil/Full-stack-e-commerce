package com.taa.tshirtsatis.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;


    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Order> orders;

    @OneToMany(mappedBy = "user" ,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Rewiew> rewiews;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Ordered> ordereds;



    public Users() {}

    public Users(int id, String email, String password, Gender gender, Role role, Set<Order> orders, Set<Rewiew> rewiews, Set<Ordered> ordereds) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.role = role;
        this.orders = orders;
        this.rewiews = rewiews;
        this.ordereds = ordereds;
    }

    public Set<Rewiew> getRewiews() {
        return rewiews;
    }

    public void setRewiews(Set<Rewiew> rewiews) {
        this.rewiews = rewiews;
    }

    public Set<Ordered> getOrdereds() {
        return ordereds;
    }

    public void setOrdereds(Set<Ordered> ordereds) {
        this.ordereds = ordereds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }
}
