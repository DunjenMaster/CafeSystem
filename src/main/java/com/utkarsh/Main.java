package com.utkarsh;

import com.utkarsh.Beverages.Coffee;
import com.utkarsh.Beverages.Juice;
import com.utkarsh.Beverages.Tea;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        Menu.cafeName();

        List<Menu> cafeMenu = List.of(
                new Coffee(),
                new Tea(),
                new Juice(),
                new Snacks());

        for (Menu menu : cafeMenu) {
            menu.showMenu();
        }
    }
}