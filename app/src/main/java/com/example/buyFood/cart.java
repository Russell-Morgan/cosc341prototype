package com.example.buyFood;

import com.example.buyFood.buyListings.item;

import java.io.Serializable;
import java.util.ArrayList;

public class cart implements Serializable{

    ArrayList<item> cartL ;
    private Integer total;

    cart(){
        cartL = new ArrayList<>();
        total = 0;
    };


    void add(item item, int quantity){
        item toCart = item;
        toCart.setQuantity(quantity);
        toCart.countSubtotal(toCart.getPrice(), quantity);
        cartL.add(toCart);

    }

    void delete(int index){
        cartL.remove(index);
    }

    void cancel(){};

    Double countTotal(){
        Double total = 0.0;
        for(int i = 0; i < cartL.size(); i++ )
           total += cartL.get(i).getSubtotal();
        return total;
    }
}

