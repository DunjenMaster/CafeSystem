package com.utkarsh;

import com.utkarsh.Beverages.Coffee;
import com.utkarsh.Beverages.Tea;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Menu> cafeMenu = List.of(
                new Coffee(),
                new Tea(),
                new Snacks()
        );

        for(Menu menu : cafeMenu) {
            menu.showMenu();
        }
    }
}