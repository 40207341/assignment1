/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.assignment1;

/**
 *
 * @author stanfernrego10
 */
import java.util.Scanner;

public class Assignment1 {

    static String[] months = {
        "Jan", "Feb", "Mar", "Apr", "May", "Jun",
        "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
    };

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] temperatures2023 = new int[12];
        int[] temperatures2024 = new int[12];

        System.out.println();
        System.out.println("Average Temperature in London (Celsius)");
        System.out.println();

        // Input temperature for 2023
        System.out.println("Enter temperatures for 2023:");
        for (int i = 0; i < 12; i++) {
            System.out.print(months[i] + ": ");
            temperatures2023[i] = scanner.nextInt();
        }

        // Input temperature for 2024
        System.out.println();
        System.out.println("Enter temperatures for 2024:");
        for (int i = 0; i < 12; i++) {
            System.out.print(months[i] + ": ");
            temperatures2024[i] = scanner.nextInt();
        }

        // Display temperature data for 2023
        System.out.println();
        System.out.println("--- 2023 Temperature Data ---");
        displayData(months, temperatures2023);

        // Display temperature data for 2024
        System.out.println();
        System.out.println("--- 2024 Temperature Data ---");
        displayData(months, temperatures2024);

        // Display averages for both years
        System.out.println();
        System.out.println("Average temperature for 2023: "
                + calculateAverage(temperatures2023) + "°C");
        System.out.println("Average temperature for 2024: "
                + calculateAverage(temperatures2024) + "°C");

        /* LINEAR SEARCH SECTION*/
        System.out.println();
        System.out.println("Search a record for a particular month.");
        System.out.println();

        System.out.print("Select year to search (2023 or 2024): ");
        int yearToSearch = scanner.nextInt();

        System.out.print("Enter month to search (Jan, Feb, Mar ... Dec): ");
        String monthToSearch = scanner.next();

        if (yearToSearch == 2023) {
            linearSearch(months, temperatures2023, monthToSearch, "2023");
        } else if (yearToSearch == 2024) {
            linearSearch(months, temperatures2024, monthToSearch, "2024");
        } else {
            System.out.println("Invalid year selected.");
        }

        scanner.close();
    }

    // Display data
    public static void displayData(String[] months, int[] temperatureData) {

        for (int i = 0; i < 12; i++) {
            System.out.println(months[i] + ": " + temperatureData[i] + "°C");
        }
    }

    // Linear search method
    public static void linearSearch(String[] months, int[] temperatureData,
                                    String targetMonth, String year) {

        boolean monthFound = false;

        for (int i = 0; i < 12; i++) {
            if (months[i].equalsIgnoreCase(targetMonth)) {
                System.out.println("Temperature for " + months[i]
                        + " in " + year + ": " + temperatureData[i] + "°C");
                monthFound = true;
                break;
            }
        }

        if (!monthFound) {
            System.out.println("Month not found for " + year);
        }
    }

    // Average calculation method
    public static double calculateAverage(int[] temperatureData) {

        int total = 0;

        for (int i = 0; i < 12; i++) {
            total += temperatureData[i];
        }

        return (double) total / 12;
    }
}
