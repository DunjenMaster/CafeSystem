package com.utkarsh;

import java.util.List;

public abstract class CafeMenuItem implements Menu{

    protected abstract String getMenuTitle();
    protected abstract List<String> getMenuItems();

    @Override
    public void showMenu(){
        System.out.println(getMenuTitle());

        List<String> items = getMenuItems();

        int index = 1;
        for(String item : items) {
            System.out.println(index + ". " + item);
            index++;
        }
        System.out.println();
    }

}
