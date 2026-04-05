package com.utkarsh;

//import java.util.List;
import java.util.Map;

public abstract class CafeMenuItem implements Menu {

    protected abstract String getMenuTitle();

    protected abstract Map<String, Double> getMenuItems();

    @Override
    public void showMenu() {
        System.out.println(getMenuTitle());

        Map<String, Double> items = getMenuItems();

        int index = 1;
        // for(String item : items) {
        // System.out.println(index + ". " + item);
        // index++;
        // }
        // System.out.println();

        for (Map.Entry<String, Double> entry : items.entrySet()) {
            System.out.println(index + ". " + entry.getKey() + " - ₹" + entry.getValue() + "/- ");
            index++;
        }
        System.out.println();
    }

}
