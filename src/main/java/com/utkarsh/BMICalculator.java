package com.utkarsh;

import java.util.Scanner;

public class BMICalculator {

    public double calculateAndSuggest(Scanner scanner) {
        try {
            System.out.print("Enter your weight in kg (e.g., 70): ");
            double weight = scanner.nextDouble();

            System.out.print("Enter your height in meters (e.g., 1.75): ");
            double height = scanner.nextDouble();

            // consume newline
            scanner.nextLine();

            if (height <= 0 || weight <= 0) {
                System.out.println("Invalid height or weight entered.");
                return 0.00;
            }

            double bmi = weight / (height * height);
            System.out.printf("Your BMI is: %.2f\n", bmi);

            suggestItemsBasedOnBMI(bmi);
            return bmi;

        } catch (Exception e) {
            System.out.println("Invalid input for BMI calculation.");
            scanner.nextLine(); // clear buffer
            return 0.00;
        }
    }

    private void suggestItemsBasedOnBMI(double bmi) {
        System.out.println("\n--- Health Based Recommendations ---");
        if (bmi < 18.5) {
            System.out.println("Category: Underweight");
            System.out.println("Suggestion: We recommend energy-rich items from our menu!");
            System.out.println(" -> Beverages: Latte, Cappuccino");
            System.out.println(" -> Snacks: Cake, Patties");
        } else if (bmi >= 18.5 && bmi < 25.0) {
            System.out.println("Category: Normal weight (Healthy)");
            System.out.println("Suggestion: Great job! You can balance your diet with anything you like.");
            System.out.println(" -> Beverages: Any Juice or our Signature Coffee");
            System.out.println(" -> Snacks: Feel free to treat yourself to a Samosa occasionally!");
        } else if (bmi >= 25.0 && bmi < 30.0) {
            System.out.println("Category: Overweight");
            System.out.println("Suggestion: We recommend choosing healthier, low-calorie options.");
            System.out.println(" -> Beverages: Black Coffee, Black Tea");
            System.out.println(" -> Juices: Fresh Watermelon or Mousami Juice (No added sugar)");
            System.out.println(" -> (It is better to avoid heavy snacks)");
        } else {
            System.out.println("Category: Obese");
            System.out.println("Suggestion: We highly recommend sticking strictly to our healthiest options.");
            System.out.println(" -> Beverages: Black Coffee, Liquor Tea (No sugar)");
            System.out.println(" -> Please avoid exploring the Snacks menu.");
        }
        System.out.println("------------------------------------\n");
    }
}
