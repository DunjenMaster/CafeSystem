package com.utkarsh.Beverages;

import com.utkarsh.CafeMenuItem;

import java.util.HashMap;
import java.util.Map;

public class Coffee extends CafeMenuItem {

    @Override
    protected String getMenuTitle() {
        return "Coffee Menu: ";
    }

    private Map<String, Double> getHealthyCoffeeOptions = new HashMap<>();

    public Coffee() {
        getHealthyCoffeeOptions.put("Black Coffee", 160.00);
        getHealthyCoffeeOptions.put("Latte", 190.00);
        getHealthyCoffeeOptions.put("Cappuccino", 200.00);
        getHealthyCoffeeOptions.put("Regular Milk Coffee", 150.00);
    }

    @Override
    protected Map<String, Double> getMenuItems() {
        return getHealthyCoffeeOptions;
    }



    // To add the new coffee item in the present menu.
    public void addNewCoffeeItem(String name, Double price) {
        getHealthyCoffeeOptions.put(name, price);
    }

    // To remove the coffee item from the present menu.
    public void removeCoffeeItem(String name) {
        getHealthyCoffeeOptions.remove(name);
    }

}
