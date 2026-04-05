package com.utkarsh.Beverages;

import com.utkarsh.CafeMenuItem;

//import java.util.List;
import java.util.Map;

public class Coffee extends CafeMenuItem {

    @Override
    protected String getMenuTitle() {
        return "Coffee Menu: ";
    }

    @Override
    // protected List<String> getMenuItems(){
    // return List.of("Black Coffee", "Latte", "Cappuccino", "Regular Milk Coffee");
    // }
    protected Map<String, Double> getMenuItems() {
        return Map.of(
                "Black Coffee", 160.0,
                "Latte", 190.0,
                "Cappuccino", 200.0,
                "Regular Milk Coffee", 150.0);
    }

}
