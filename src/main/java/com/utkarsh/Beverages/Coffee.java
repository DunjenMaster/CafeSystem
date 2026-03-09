package com.utkarsh.Beverages;

import com.utkarsh.CafeMenuItem;


import java.util.List;

public class Coffee extends CafeMenuItem {

    private List<String> coffeeList = List.of("Black Coffee", "Latte", "Cappuccino", "Regular Milk Coffee");

    public List<String> getCoffeeList(){
        return coffeeList;
    }

    @Override
    protected String getMenuTitle() {
       return "Coffee Menu: ";
    }

    @Override
    protected List<String> getMenuItems(){
        return List.of("Black Coffee", "Latte", "Cappuccino", "Regular Milk Coffee");
    }







}
