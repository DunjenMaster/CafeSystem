package com.utkarsh;

import com.utkarsh.Beverages.Coffee;
import com.utkarsh.Beverages.Juice;
import com.utkarsh.Beverages.Tea;

/**
 * Factory Design Pattern Implementation.
 * This class abstracts the creation of Menu objects. 
 */
public class MenuFactory {

    public static Menu getMenuCategory(String categoryType) {
        if (categoryType == null) {
            return null;
        }

        switch (categoryType.toLowerCase()) {
            case "coffee":
                return new Coffee(); // Imagine if Coffee took 5 parameters to build, the Factory handles it!
            case "tea":
                return new Tea();
            case "juice":
                return new Juice();
            case "snacks":
                return new Snacks();
            default:
                throw new IllegalArgumentException("Unknown Menu Category: " + categoryType);
        }
    }
}
