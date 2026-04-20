package com.utkarsh;

import java.util.Map;

public abstract class CafeMenuItem implements Menu {

    public abstract String getMenuTitle();

    public abstract Map<String, Double> getMenuItems();

    @Override
    public void showMenu() {
        System.out.println(getMenuTitle());

        Map<String, Double> items = getMenuItems();

        int index = 1;

        for (Map.Entry<String, Double> entry : items.entrySet()) {
            System.out.println(index + ". " + entry.getKey() + " - ₹" + entry.getValue() + "/- ");
            index++;
        }
        System.out.println();
    }

    @Override
    public String getExactItemName(String itemName) {
        return getMenuItems().keySet().stream()
                .filter(key -> key.equalsIgnoreCase(itemName))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Double getItemPrice(String itemName) {
        String exactName = getExactItemName(itemName);
        if (exactName != null) {
            return getMenuItems().get(exactName);
        }
        return null;
    }
}
