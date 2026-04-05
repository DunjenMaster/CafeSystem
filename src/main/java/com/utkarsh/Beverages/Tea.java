package com.utkarsh.Beverages;

import com.utkarsh.CafeMenuItem;

//import java.util.List;
import java.util.Map;

public class Tea extends CafeMenuItem {

    @Override
    public String getMenuTitle() {
        return "Tea Menu: ";
    }

    @Override
    // public List<String> getMenuItems (){
    // return List.of("Black Tea", "Liquor Tea", "Ginger Tea", "Regular Milk Tea");
    // }

    protected Map<String, Double> getMenuItems() {
        return Map.of(
                "Black Tea", 100.0,
                "Liquor Tea", 120.0,
                "Ginger Tea", 130.0,
                "Regular Milk Tea", 110.0);
    }
}
