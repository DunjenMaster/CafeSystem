package com.utkarsh.service;

import com.utkarsh.Menu;
import com.utkarsh.MenuFactory;

import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.HashMap;

@Service
public class CafeService {

    public Map<String, Menu> getFullMenu() {

        Map<String, Menu> cafeMenu = new HashMap<>();

        String[] categories = { "Coffee", "Tea", "Juice", "Snacks" };

        for (String category : categories) {
            cafeMenu.put(category, MenuFactory.getMenuCategory(category));
        }
        return cafeMenu;

    }

}
