package com.myapp;

import java.util.Random;

public class Helper {

    // Validate Customer Name
    public static boolean isValidName(String name) {
        return name != null && name.matches("^[a-zA-Z ]{3,50}$");
    }

    // Validate Customer Phone
    public static boolean isValidPhone(String phone) {
        return phone != null && phone.matches("^[6-9]\\d{9}$");
    }

    // Validate Branch Name
    public static boolean isValidBranch(String branch) {
        return branch != null && branch.length() >= 3;
    }

    // Generate Random Account Number
    public static String generateAccountNumber() {
        Random rand = new Random();
        long num = 1000000000L + rand.nextInt(900000000);
        return "IBS" + num; // IBS prefix = Indian Banking System
    }

    // Validate Amount (Deposit, Withdraw, Loan, FD)
    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }
}
