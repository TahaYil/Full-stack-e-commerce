package com.taa.tshirtsatis.dto;

import com.taa.tshirtsatis.entity.Category;
import com.taa.tshirtsatis.entity.Product;
import jakarta.persistence.Column;

import java.util.Set;

public class ProductDto {
    private int id;

    private String name;

    private String description;

    private float price;

    private int quantity;

    private Set<Category> categories;

    private String image;

    public ProductDto(Product p) {
        this.id = p.getId();
        this.name = p.getName();
        this.description = p.getDescription();
        this.price = p.getPrice();
        this.quantity = p.getQuantity();
        this.categories = p.getCategories();
        this.image = "/products/" + p.getId() + "/image";
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

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
