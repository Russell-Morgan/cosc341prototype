package com.example.sellFood;

import java.util.Scanner;

public class Sale {

    public Sale fromString(String s){
        Scanner scan = new Scanner(s);
        String name = scan.nextLine();
        String description = scan.nextLine();
        String choices = scan.nextLine();
        Integer size = Integer.parseInt(scan.next());
        String unit = scan.next();
        Integer quantity= Integer.parseInt(scan.next());
        Double price = Double.parseDouble(scan.next());

        return new Sale(name, description, choices, unit, size, quantity, price);
    }

    public String fromSale(Sale sale){
        return  sale.getName() + "\n" +
                sale.getDescription() + "\n" +
                sale.choices + "\n" +
                sale.getSize().toString() + " " + sale.getUnit()+ "\n" +
                sale.getQuantity().toString() + "\n" +
                sale.getPrice().toString() + "\n" ;
    }

    @Override
    public String toString() {
        return
                "Name: " + name +
                "\nDescription: " + description +
                "\n" + choices +
                "\nServing Size: " + size + " " + unit +
                "\nQuantity: " + quantity +
                "\nPrice: $" + price;
    }

    public Sale(){
        this.name = "";
        this.description = "";
        this.choices = "";
        this.unit = "";
        this.size = 0;
        this.quantity = 0;
        this.price = 0.0;
    }

    public Sale(String name, String description, String choices, String unit, Integer size, Integer quantity, Double price) {
        this.name = name;
        this.description = description;
        this.choices = choices;
        this.unit = unit;
        this.size = size;
        this.quantity = quantity;
        this.price = price;
    }

    private String name, description, choices, unit;
    private Integer size,quantity;
    private Double price;

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

    public String getChoices() {
        return choices;
    }

    public void setChoices(String choices) {
        this.choices = choices;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


}
