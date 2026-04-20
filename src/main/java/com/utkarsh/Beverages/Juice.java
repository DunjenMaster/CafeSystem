package com.utkarsh.Beverages;

import com.utkarsh.CafeMenuItem;

import java.util.Map;
import java.util.HashMap;

public class Juice extends CafeMenuItem {

    @Override
    public String getMenuTitle() {
        return "Juice Menu: ";
    }

    Map<String, Double> getHealthyJuiceOptions = new HashMap<>();

    public Juice() {
        getHealthyJuiceOptions.put("Mousami Juice", 120.0);
        getHealthyJuiceOptions.put("Orange Juice", 135.0);
        getHealthyJuiceOptions.put("Pineapple Juice", 140.0);
        getHealthyJuiceOptions.put("Watermelon Juice", 150.0);
        getHealthyJuiceOptions.put("Apple Juice", 160.0);
        getHealthyJuiceOptions.put("Grapes Juice", 170.0);
        getHealthyJuiceOptions.put("Pomegranate Juice", 180.0);
        getHealthyJuiceOptions.put("Pineapple Juice", 190.0);

    }

    @Override
    public Map<String, Double> getMenuItems() {
        return getHealthyJuiceOptions;
    }

    public void addNewJuiceItem(String name, Double price) {
        getHealthyJuiceOptions.put(name, price);
    }

    public void removeJuiceItem(String name) {
        getHealthyJuiceOptions.remove(name);
    }
}