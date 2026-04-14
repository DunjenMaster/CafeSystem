package com.utkarsh;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        Menu.cafeName();
        Scanner sc = new Scanner(System.in);

        Map<String, Menu> cafeMenu = new HashMap<>();

        // Using our new Factory Pattern to populate the Map!
        String[] categories = { "Coffee", "Tea", "Juice", "Snacks" };
        for (String category : categories) {
            cafeMenu.put(category, MenuFactory.getMenuCategory(category));
        }

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
                    // Using Java 8 forEach and Method Reference (Menu::showMenu)
                    cafeMenu.values().forEach(Menu::showMenu);
                    break;

                case "3":
                    boolean keepOrdering = true;
                    while (keepOrdering) {
                        try {
                            System.out.println("Enter the name of the item you want to order: ");
                            String itemName = sc.nextLine();

                            // 1. Verify and properly format the case of the item using our new
                            // getExactItemName method
                            String exactItemName = cafeMenu.values().stream()
                                    .map(menu -> menu.getExactItemName(itemName))
                                    .filter(matchedName -> matchedName != null)
                                    .findFirst()
                                    .orElse(null);

                            // 2. If it doesn't exist, throw our Custom Exception!
                            if (exactItemName == null) {
                                throw new ItemNotFoundException(
                                        "Sorry! The item '" + itemName + "' is not available in our menu.");
                            }

                            System.out.println("Enter quantity: ");
                            int quantity = sc.nextInt();
                            sc.nextLine();

                            // Accumulate quantity if the item is already in the cart, using the perfectly
                            // formatted name
                            int currentQty = customerOrderDataBase.getOrDefault(exactItemName, 0);
                            customerOrderDataBase.put(exactItemName, currentQty + quantity);
                            System.out.println(quantity + " " + exactItemName + " has been added to your cart.");

                        } catch (ItemNotFoundException e) {
                            // 3. Catch our specific exception and show a friendly message
                            System.out.println("\n[Error] " + e.getMessage());
                        } catch (Exception e) {
                            System.out.println("\n[Error] Invalid input for quantity. Please try again.");
                            sc.nextLine(); // clear the scanner buffer
                        }

                        System.out.println("\nWould you like to add another item? (yes / no): ");
                        String addMore = sc.nextLine();
                        if (addMore.equalsIgnoreCase("no")) {
                            keepOrdering = false;
                        }
                    }
                    break;

                case "4":
                    System.out.println("\n====== Your Cart & Receipt ======");
                    double totalBill = 0.00;

                    for (Map.Entry<String, Integer> entry : customerOrderDataBase.entrySet()) {
                        String orderedItem = entry.getKey();
                        int qty = entry.getValue();
                        Double pricePerItem = null;

                        // Search through all the menu items to find the price using Java 8 Streams
                        pricePerItem = cafeMenu.values().stream()
                                .map(menu -> menu.getItemPrice(orderedItem)) // Transform Menu to Price
                                .filter(price -> price != null) // Keep only if a price is found
                                .findFirst() // Grab the first valid price found
                                .orElse(null); // If nothing found, keep it null

                        if (pricePerItem != null) {
                            double costforThisItem = pricePerItem * qty;
                            totalBill += costforThisItem;
                            System.out.println("- " + orderedItem + "(Qty: " + qty + ") => ₹" + costforThisItem);
                        } else {
                            System.out.println("- " + orderedItem + "(Item not found in menu!)");
                        }
                    }

                    System.out.println("-----------------------------------");
                    System.out.println("Total Amount Due: ₹" + totalBill);

                    // Add modern timestamp formatting (Java 8 time API)
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    System.out.println("Date & Time: " + LocalDateTime.now().format(formatter));

                    // ---- MULTITHREADING IMPLEMENTATION START ----
                    System.out.println("\n💳 Payment received! Sending orders to the kitchen...");
                    
                    // Create an array of Asynchronous Tasks (one for each unique item type in cart)
                    java.util.concurrent.CompletableFuture<?>[] futures = customerOrderDataBase.entrySet().stream()
                        .map(entry -> java.util.concurrent.CompletableFuture.runAsync(() -> {
                            String orderedItem = entry.getKey();
                            try {
                                System.out.println("👨‍🍳 [Barista] Started preparing " + orderedItem + "...");
                                // Pretend it takes exactly 3 seconds to brew/cook any item
                                Thread.sleep(3000); 
                                System.out.println("✅ [Barista] Finished! " + orderedItem + " is ready on the counter!");
                            } catch (InterruptedException e) {
                                Thread.currentThread().interrupt(); // Best practice error handling for Threads
                            }
                        }))
                        .toArray(java.util.concurrent.CompletableFuture[]::new);
                    
                    // We tell the Main Thread to wait for all the Baristas to finish before locking the doors.
                    java.util.concurrent.CompletableFuture.allOf(futures).join();
                    // ---- MULTITHREADING IMPLEMENTATION END ----

                    System.out.println("\nThanks for ordering! Please revisit us again");
                    systemRunningStatus = false;
                    break;

                case "exit":
                    systemRunningStatus = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please pick 1, 2, 3, or 4.");

            }
        }

        System.out.println("\n[SYSTEM] Session ended.");

        // Only save to file IF the user actually calculated their BMI!
        if (!customerBmiDataBase.isEmpty()) {
            try (FileWriter writer = new FileWriter("cafe_daily_report.txt", true)) {
                DateTimeFormatter logFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                writer.write(
                        "\n=== HEALTH & DIET SESSION REPORT [" + LocalDateTime.now().format(logFormatter) + "] ===\n");

                for (Map.Entry<String, Double> bmiEntry : customerBmiDataBase.entrySet()) {
                    writer.write("Customer Name: " + bmiEntry.getKey() + "\n");
                    writer.write("Recorded BMI: " + String.format("%.2f", bmiEntry.getValue()) + "\n");
                }

                writer.write("Diet Consumed (Orders): \n");
                if (customerOrderDataBase.isEmpty()) {
                    writer.write("- (No items ordered)\n");
                } else {
                    for (Map.Entry<String, Integer> orderEntry : customerOrderDataBase.entrySet()) {
                        writer.write("- " + orderEntry.getKey() + " (Qty: " + orderEntry.getValue() + ")\n");
                    }
                }
                System.out.println("[SYSTEM] Successfully saved Health & Diet records to cafe_daily_report.txt!");
            } catch (IOException e) {
                System.out.println("[SYSTEM ERROR] Failed to save records: " + e.getMessage());
            }
        } else {
            System.out.println("[SYSTEM] Standard order only. No BMI health data to log.");
        }

        sc.close();

    }

}