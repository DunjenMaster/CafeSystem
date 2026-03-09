package com.utkarsh.Beverages;

import com.utkarsh.CafeMenuItem;


import java.util.List;

public class Coffee extends CafeMenuItem {

    @Override
    protected String getMenuTitle() {
       return "Coffee Menu: ";
    }

    @Override
    protected List<String> getMenuItems(){
        return List.of("Black Coffee", "Latte", "Cappuccino", "Regular Milk Coffee");
    }







}
