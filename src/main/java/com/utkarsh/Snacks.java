package com.utkarsh;

import java.util.List;

public class Snacks extends CafeMenuItem {

    @Override
    public String getMenuTitle(){
        return "Snacks Menu: ";
    }

    @Override
    public List<String> getMenuItems(){
        return List.of("Cake", "Biscuits", "Samosa", "Patties");
    }

}
