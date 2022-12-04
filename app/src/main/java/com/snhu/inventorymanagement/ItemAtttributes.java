package com.snhu.inventorymanagement;

public class ItemAtttributes {

    private int id;
    private String name;
    private int quantity;

    @Override
    public String toString() {
        return "ItemAtttributes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                '}';
    }

    public ItemAtttributes() {

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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ItemAtttributes(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;

    }
}
