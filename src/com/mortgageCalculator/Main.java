package com.mortgageCalculator;

import java.text.NumberFormat;
import java.util.Scanner;


class Main {
    public static void main(String[] arg) {
        final byte MONTHS_IN_YR = 12;
        final byte PERCENT = 100;

        int principal = 0;

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 1_000_000)
                break;
            System.out.print("Principal ($1k - $1M): ");
        }

        float annualInterest = 0;
        float monthlyInterest = 0;

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if (annualInterest >= 0 && annualInterest <= 30) {
                monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YR;
                break;
            }
            System.out.println("Enter a value between 0 and 30. ");
        }

        byte years = 0;
        int numberOfPayments = 0;

        while (true) {
            System.out.print("Enter Time Period in years: ");
            years = scanner.nextByte();
            if (years >= 1 && years <= 30) {
                numberOfPayments = years * MONTHS_IN_YR;

                double mortgage = principal * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments)) /
                        (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

                String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
                System.out.println("Mortgage: " + mortgageFormatted);
                break;
            }
            System.out.println("Enter a value between 1 and 30. ");
        }
    }
}