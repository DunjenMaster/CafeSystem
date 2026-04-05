package com.utkarsh;

//import java.util.List;
import java.util.Map;

public class Snacks extends CafeMenuItem {

    @Override
    public String getMenuTitle() {
        return "Snacks Menu: ";
    }

    @Override
    // public List<String> getMenuItems(){
    // return List.of("Cake", "Biscuits", "Samosa", "Patties");
    // }

    protected Map<String, Double> getMenuItems() {
        return Map.of(
                "Cake", 100.0,
                "Biscuits", 50.0,
                "Samosa", 20.0,
                "Patties", 30.0);
    }

}
