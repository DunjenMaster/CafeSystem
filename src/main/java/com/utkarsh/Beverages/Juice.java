package com.utkarsh.Beverages;

import com.utkarsh.CafeMenuItem;

//import java.util.List;
import java.util.Map;

public class Juice extends CafeMenuItem {

    @Override
    protected String getMenuTitle() {
        return "Juice Menu: ";
    }

    @Override
    // protected List<String> getMenuItems() {
    // return List.of("Mousami Juice", "Orange Juice", "Pineapple Juice",
    // "Watermelon Juice");
    // }

    protected Map<String, Double> getMenuItems() {
        return Map.of(
                "Mousami Juice", 120.0,
                "Orange Juice", 135.0,
                "Pineapple Juice", 140.0,
                "Watermelon Juice", 150.0);
    }

}