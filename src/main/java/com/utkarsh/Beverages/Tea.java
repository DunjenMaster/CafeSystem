package com.utkarsh.Beverages;

import com.utkarsh.Menu;

import java.util.List;

public class Tea implements Menu {

    private List<String> teaList = List.of("Black Tea", "Liquor Tea", "Ginger Tea", "Regular Milk Tea");

    public List<String> getTeaList(){
        return teaList;
    }

    @Override
    public void showMenu(){
        System.out.println("\nTea's Menu");

        int index = 1;
        for(String tea : teaList) {
            System.out.println(index+ ". " + tea);
            index++;
        }
    }

}
