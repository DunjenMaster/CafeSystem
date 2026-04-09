package com.utkarsh;

import com.utkarsh.Beverages.Coffee;
import com.utkarsh.Beverages.Juice;
import com.utkarsh.Beverages.Tea;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Menu.cafeName();
        Scanner sc = new Scanner(System.in);

        Map<String, Menu> cafeMenu = new HashMap<>();
        cafeMenu.put("Coffee", new Coffee());
        cafeMenu.put("Tea", new Tea());
        cafeMenu.put("Juice", new Juice());
        cafeMenu.put("Snacks", new Snacks());

        Map<String, Double> customerBmiDataBase = new HashMap<>();
        Map<String, Integer> customerOrderDataBase = new HashMap<>();

        boolean systemRunningStatus = true;
        while (systemRunningStatus) {
            System.out.println("\n====== Welcome to our Cafe ======");
            System.out
                    .println("1. Are you health conscious? Calculate your BMI for personalized menu recommendations! ");
            System.out.println("2. View Full Menu");
            System.out.println("3. Order an Item");
            System.out.println("4. View Cart & Checkout");
            System.out.println("Choose an option (1-4) or type 'exit' to quit: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Customer's name: ");
                    String name = sc.nextLine();

                    BMICalculator bmiCalculator = new BMICalculator();
                    double bmi = bmiCalculator.calculateAndSuggest(sc);

                    if (bmi > 0) {
                        customerBmiDataBase.put(name, bmi);
                        System.out.println(name + " Your BMI has been saved for future reference.");
                    }

                    break;

                case "2":
                    System.out.println("\n====== Menu ======");
                    for (Menu menu : cafeMenu.values()) {
                        menu.showMenu();
                    }
                    break;

                case "3":
                    System.out.println("Enter the name of the item you want to order: ");
                    String itemName = sc.nextLine();

                    System.out.println("Enter quantity");
                    int quantity = sc.nextInt();
                    sc.nextLine();

                    customerOrderDataBase.put(itemName, quantity);
                    System.out.println(quantity + " " + itemName + " has been added to your cart.");

                    break;

                case "4":
                    System.out.println("\n====== Your Cart & Receipt ======");
                    double totalBill = 0.00;

                    for (Map.Entry<String, Integer> entry : customerOrderDataBase.entrySet()) {
                        String orderedItem = entry.getKey();
                        int qty = entry.getValue();
                        Double pricePerItem = null;

                        // Search through all the menu items to find the price
                        for (Menu menu : cafeMenu.values()) {
                            Double foundPrice = menu.getItemPrice(orderedItem);
                            if (foundPrice != null) {
                                pricePerItem = foundPrice;
                                break; // Item found stop the search.
                            }
                        }

                        if (pricePerItem != null) {
                            double costforThisItem = pricePerItem * qty;
                            totalBill += costforThisItem;
                            System.out.println("- " + orderedItem + "(Qty: " + qty + ") => ₹" + costforThisItem);
                        } else {
                            System.out.println("- " + orderedItem + "(Item not found in menu!)");
                        }
                    }

                    System.out.println("-----------------------------------");
                    System.out.println("Total Ammount Due: ₹" + totalBill);
                    System.out.println("Thanks for ordering! Please revisit us again");
                    systemRunningStatus = false;
                    break;

                case "exit":
                    systemRunningStatus = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please pick 1, 2, 3, or 4.");

            }
        }

        System.out.println("\n[SYSTEM] BMI Records for today: " + customerBmiDataBase);
        sc.close();

    }

}