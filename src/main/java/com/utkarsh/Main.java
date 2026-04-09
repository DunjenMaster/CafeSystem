package com.utkarsh;

import com.utkarsh.Beverages.Coffee;
import com.utkarsh.Beverages.Juice;
import com.utkarsh.Beverages.Tea;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    // public static void main(String[] args) {

    // Menu.cafeName();

    // Scanner scanner = new Scanner(System.in);
    // System.out.print(
    // "\nAre you health conscious? Calculate your BMI for personalized menu
    // recommendations! (yes/no): ");
    // String checkBmi = scanner.nextLine();

    // if (checkBmi.equalsIgnoreCase("yes")) {
    // BMICalculator bmiCalculator = new BMICalculator();
    // bmiCalculator.calculateAndSuggest(scanner);
    // System.out.println("Here is our full menu for you to explore:\n");
    // } else {
    // System.out.println("\nAlright, here is our full menu...\n");
    // }

    // Map<String, Menu> cafeMenu = new HashMap<>();
    // cafeMenu.put("Coffee", new Coffee());
    // cafeMenu.put("Tea", new Tea());
    // cafeMenu.put("Juice", new Juice());
    // cafeMenu.put("Snacks", new Snacks());

    // for (Menu menu : cafeMenu.values()) {
    // menu.showMenu();
    // }

    // scanner.close();
    // }

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
            System.out.println(
                    "1. Are you health conscious? Calculate your BMI for personalized menu recommendations! (yes/no): ");
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
                        System.out.println(name + "Your BMI has been saved for future reference.");
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
                    System.out.println("\n====== Your Cart ======");
                    for (Map.Entry<String, Integer> entry : customerOrderDataBase.entrySet()) {
                        System.out.println("- " + entry.getKey() + " (Qty: " + entry.getValue() + ")");
                    }

                    System.out.println("Thanks for ordering! Please revisit us again");
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