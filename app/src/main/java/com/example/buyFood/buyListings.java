package com.example.buyFood;

import java.io.Serializable;
import java.util.ArrayList;

public class buyListings  implements Serializable {

    public static ArrayList<item> arrayList = new ArrayList<>();

    public item getById(Integer id) {
        for (int i = 0; i < arrayList.size(); i++){
            if(arrayList.get(i).getId() == id){
                return arrayList.get(i);
            }
        }
        return null;
    }


    public static class item  implements Serializable{

        private String name;

        private String description;

        public String getName() {
            return name;
        }

        private Double itemPrice;

        public Double getPrice() {
            return itemPrice;
        }

        public Double getSubtotal() {
            return subtotalPrice;
        }

        private Double subtotalPrice;

        private Integer quantity;

        private Integer id;

        public String getDescription() {
            return description;
        }

        public Integer getId() {
            return id;
        }

        //item is for both menu list + cart
        //subtotal n quantity is after user picks how many

        item(String name, String description, Double price, Integer id) {
            this.id = id;
            this.description = description;
            this.name = name;
            this.itemPrice = price;
            arrayList.add(this);
        }

        //count subtotal
        Double countSubtotal(Double price, int quantity) {
            subtotalPrice = price * quantity;
            return subtotalPrice;
        }

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        @Override
        public String toString() {
            return "Name: " + name +
                    "\nPrice: $" + itemPrice;
        }

    }
}