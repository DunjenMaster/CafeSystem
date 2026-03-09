package com.utkarsh;

import java.util.List;

public class Snacks implements Menu{

    private List<String> snackList = List.of("Cake", "Biscuits", "Samosa", "Patties");

    public List<String> getSnackList () {
        return snackList;
    }

    @Override
    public void showMenu(){
        System.out.println("\nSnack's Menu");

        int index = 1;
        for(String snack : snackList) {
            System.out.println(index + ". " +snack);
            index++;
        }

    }
}
