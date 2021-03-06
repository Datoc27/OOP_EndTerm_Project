package com.company.entities;

public class Property {
    private int id;
    private String type;
    private String location;
    private int rooms;
    private boolean hasOwner;
    private double price;

    public Property() {
    }

    public Property(int id, String type, String location, int rooms, boolean hasOwner, double price) {
        this.id = id;
        this.type = type;
        this.location = location;
        this.rooms = rooms;
        this.hasOwner = hasOwner;
        this.price = price;
    }

    public Property(String type, String location, int rooms, boolean hasOwner, double price) {
        this.type = type;
        this.location = location;
        this.rooms = rooms;
        this.hasOwner = hasOwner;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public boolean isHasOwner() {
        return hasOwner;
    }

    public void setHasOwner(boolean hasOwner) {
        this.hasOwner = hasOwner;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", location='" + location + '\'' +
                ", rooms=" + rooms +
                ", hasOwner=" + hasOwner +
                ", price=" + price +
                '}';
    }
}
