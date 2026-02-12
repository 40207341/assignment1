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

        // Input 2023
        System.out.println("Enter temperatures for 2023:");
        for (int i = 0; i < 12; i++) {
            System.out.print(months[i] + ": ");
            temperatures2023[i] = scanner.nextInt();
        }

        // Input 2024
        System.out.println();
        System.out.println("Enter temperatures for 2024:");
        for (int i = 0; i < 12; i++) {
            System.out.print(months[i] + ": ");
            temperatures2024[i] = scanner.nextInt();
        }

        // Display formatted table
        System.out.println();
        displayTable(months, temperatures2023, temperatures2024);

        // Display averages
        System.out.println();
        System.out.printf("Average temperature for 2023: %.2f°C%n",
                calculateAverage(temperatures2023));
        System.out.printf("Average temperature for 2024: %.2f°C%n",
                calculateAverage(temperatures2024));

        /*
         * LINEAR SEARCH SECTION
         */
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

    // Properly aligned table using printf
    public static void displayTable(String[] months, int[] data2023, int[] data2024) {

        System.out.printf("%-6s", "Year");
        for (int i = 0; i < 12; i++) {
            System.out.printf("%-6s", months[i]);
        }
        System.out.println();

        System.out.printf("%-6s", "2023");
        for (int i = 0; i < 12; i++) {
            System.out.printf("%-6s", data2023[i] + "°C");
        }
        System.out.println();

        System.out.printf("%-6s", "2024");
        for (int i = 0; i < 12; i++) {
            System.out.printf("%-6s", data2024[i] + "°C");
        }
        System.out.println();
    }

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

    public static double calculateAverage(int[] temperatureData) {

        int total = 0;

        for (int i = 0; i < 12; i++) {
            total += temperatureData[i];
        }

        return (double) total / 12;
    }
}

