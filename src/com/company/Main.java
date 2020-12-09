package com.company;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int principal = (int)readNumbers("Principal: ", 1000, 1000000);
        double annualIntrest = (double) readNumbers("Annual Intrest Rate: ",1,30);
        int year = (int) readNumbers("Year: ",1,30);

        double mortgage = mortgageCalculator(principal, annualIntrest, year);
        String mortageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println(mortageFormatted);
    }

    public static double readNumbers(String prompt, int min, int max){
        Scanner scanner = new Scanner(System.in);

        double value;
        while (true) {
            System.out.print(prompt);
            value = scanner.nextDouble();
            if (value > min && value <= max) {
                break;
            }
            System.out.println("Enter value between " + min + " and " + max);
        }
        return value;
    }

    public static double mortgageCalculator(int principal, double annualIntrest, int year) {
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;
        double monthlyIntrest = (double) (annualIntrest / PERCENT / MONTH_IN_YEAR);
        int noOfPayments = year * MONTH_IN_YEAR;

        double mortage = principal * (monthlyIntrest * Math.pow(1 + monthlyIntrest, noOfPayments))
                    / (Math.pow(1 + monthlyIntrest, noOfPayments) - 1);

        return mortage;
    }
}

