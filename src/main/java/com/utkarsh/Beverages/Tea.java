package com.utkarsh.Beverages;

import com.utkarsh.CafeMenuItem;

import java.util.Map;
import java.util.HashMap;

public class Tea extends CafeMenuItem {

    @Override
    public String getMenuTitle() {
        return "Tea Menu: ";
    }

    Map<String, Double> getHealthyTeaOptions = new HashMap<>();

    public Tea() {
        getHealthyTeaOptions.put("Black Tea", 100.0);
        getHealthyTeaOptions.put("Liquor Tea", 120.0);
        getHealthyTeaOptions.put("Ginger Tea", 130.0);
        getHealthyTeaOptions.put("Regular Milk Tea", 110.0);
        getHealthyTeaOptions.put("Green Tea", 140.0);
        getHealthyTeaOptions.put("Lemon Tea", 150.0);
        getHealthyTeaOptions.put("Masala Chai", 160.0);
        getHealthyTeaOptions.put("Elaichi Chai", 170.0);
        getHealthyTeaOptions.put("Kadak Chai", 180.0);
        getHealthyTeaOptions.put("Cutting Chai", 190.0);
        getHealthyTeaOptions.put("Irani Chai", 200.0);
        getHealthyTeaOptions.put("Kashmiri Chai", 210.0);
        getHealthyTeaOptions.put("Tulsi Tea", 220.0);
        getHealthyTeaOptions.put("Herbal Tea", 230.0);
        getHealthyTeaOptions.put("Chamomile Tea", 240.0);
        getHealthyTeaOptions.put("Peppermint Tea", 250.0);
        getHealthyTeaOptions.put("Lavender Tea", 260.0);
        getHealthyTeaOptions.put("Rose Tea", 270.0);
        getHealthyTeaOptions.put("Hibiscus Tea", 280.0);
        getHealthyTeaOptions.put("Lemongrass Tea", 290.0);
        getHealthyTeaOptions.put("Ginger Lemon Tea", 300.0);
        getHealthyTeaOptions.put("Honey Lemon Tea", 310.0);
        getHealthyTeaOptions.put("Lemon Ginger Tea", 320.0);
        getHealthyTeaOptions.put("Lemon Honey Tea", 330.0);
        getHealthyTeaOptions.put("Lemon Mint Tea", 340.0);
        getHealthyTeaOptions.put("Lemon Grass Tea", 350.0);
        getHealthyTeaOptions.put("Lemon Verbena Tea", 360.0);
        getHealthyTeaOptions.put("Lemon Balm Tea", 370.0);
        getHealthyTeaOptions.put("Lemon Thyme Tea", 1040.0);
        getHealthyTeaOptions.put("Lemon Sage Tea", 1050.0);
        getHealthyTeaOptions.put("Lemon Rosemary Tea", 1060.0);
        getHealthyTeaOptions.put("Lemon Basil Tea", 1070.0);
        getHealthyTeaOptions.put("Lemon Cilantro Tea", 1080.0);
        getHealthyTeaOptions.put("Lemon Parsley Tea", 1090.0);
        getHealthyTeaOptions.put("Lemon Dill Tea", 990.0);
        getHealthyTeaOptions.put("Lemon Chives Tea", 1000.0);
        getHealthyTeaOptions.put("Lemon Tarragon Tea", 1010.0);
        getHealthyTeaOptions.put("Lemon Marjoram Tea", 1020.0);
        getHealthyTeaOptions.put("Lemon Oregano Tea", 1030.0);
    }

    @Override
    protected Map<String, Double> getMenuItems() {
        return getHealthyTeaOptions;
    }



    public void addNewTeaItem(String name, Double price) {
        getHealthyTeaOptions.put(name, price);
    }

    public void removeTeaItem(String name) {
        getHealthyTeaOptions.remove(name);
    }
}
