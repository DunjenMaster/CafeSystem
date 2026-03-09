package com.utkarsh.Beverages;

import com.utkarsh.CafeMenuItem;

import java.util.List;

public class Tea extends CafeMenuItem {

    @Override
    public String getMenuTitle(){
        return "Tea Menu: ";
    }
    @Override
    public List<String> getMenuItems (){
        return List.of("Black Tea", "Liquor Tea", "Ginger Tea", "Regular Milk Tea");
    }
}
