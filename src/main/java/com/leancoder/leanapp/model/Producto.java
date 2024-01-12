package com.leancoder.leanapp.model;

public class Producto implements Cloneable{
    
    private Long id;
    private String name;
    private double price;
    
    public Producto() {
    }

    public Producto(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            return new Producto(this.id, this.name, this.price);
        }
    }

}
