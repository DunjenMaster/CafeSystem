package com.utkarsh;

import com.utkarsh.Beverages.Coffee;
import com.utkarsh.Beverages.Tea;

public class Main {
    public static void main(String[] args) {

//        Coffee coffee = new Coffee();
//        coffee.showMenu();
//
//        System.out.println();
//
//        Tea tea = new Tea();
//        tea.showMenu();
//
//        System.out.println();
//
//        Snacks snacks = new Snacks();
//        snacks.showMenu();

        Menu coffeeMenu = new Coffee();
        coffeeMenu.showMenu();
        Menu teaMenu = new Tea();
        teaMenu.showMenu();
        Menu snackMenu = new Snacks();
        snackMenu.showMenu();


    }
}