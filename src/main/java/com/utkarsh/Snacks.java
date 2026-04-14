package com.utkarsh;

import java.util.Map;
import java.util.HashMap;

public class Snacks extends CafeMenuItem {

    @Override
    public String getMenuTitle() {
        return "Snacks Menu: ";
    }

    Map<String, Double> getHealthySnacksOptions = new HashMap<>();

    public Snacks() {
        getHealthySnacksOptions.put("Cake", 100.0);
        getHealthySnacksOptions.put("Biscuits", 50.0);
        getHealthySnacksOptions.put("Samosa", 20.0);
        getHealthySnacksOptions.put("Patties", 30.0);
    }

    @Override
    protected Map<String, Double> getMenuItems() {
        return Map.of(
                "Cake", 100.0,
                "Biscuits", 50.0,
                "Samosa", 20.0,
                "Patties", 30.0);
    }



    public void addNewSnacksItem(String name, Double price) {
        getHealthySnacksOptions.put(name, price);
    }

    public void removeSnacksItem(String name) {
        getHealthySnacksOptions.remove(name);
    }
}
