package com.utkarsh;

public interface Menu {

    static void cafeName() {
        System.out.println("Welcome to the Shukla's Cafe");
    }

    abstract void showMenu();

    abstract Double getItemPrice(String itemName);
    
    abstract String getExactItemName(String itemName);
}