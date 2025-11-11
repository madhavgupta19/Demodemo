package com.myapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainApp {

    BufferedReader buff;
    BankOperations bankOps;

    public MainApp() {
        buff = new BufferedReader(new InputStreamReader(System.in));
        bankOps = new BankOperations(buff);
    }

    public static void main(String[] args) {
        MainApp app = new MainApp();
        app.startBanking();
    }

    public void startBanking() {
        System.out.println("💰 Welcome to Indian Banking System (IBS)");
        System.out.println("----------------------------------------");
        System.out.println("Select Your Bank:");
        System.out.println("1. ICICI\n2. HDFC\n3. HSBC\n4. AXIS\n5. SBI");

        try {
            String choice = buff.readLine();
            switch (Integer.parseInt(choice)) {
                case 1 -> System.out.println("🏦 ICICI Bank selected!");
                case 2 -> System.out.println("🏦 HDFC Bank selected!");
                case 3 -> System.out.println("🏦 HSBC Bank selected!");
                case 4 -> System.out.println("🏦 AXIS Bank selected!");
                case 5 -> System.out.println("🏦 SBI Bank selected!");
                default -> System.out.println("⚠️ No valid bank selected!");
            }

            while (true) {
                System.out.println("\nPlease select your Operation:");
                System.out.println("1. Create Account");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Open FD");
                System.out.println("5. Apply Loan");
                System.out.println("6. Exit");
                System.out.print("Enter choice: ");

                String op = buff.readLine();
                switch (Integer.parseInt(op)) {
                    case 1 -> bankOps.createAccount();
                    case 2 -> bankOps.depositMoney();
                    case 3 -> bankOps.withdrawMoney();
                    case 4 -> bankOps.openFD();
                    case 5 -> bankOps.applyLoan();
                    case 6 -> {
                        System.out.println("🙏 Thank you for using Indian Banking System!");
                        System.exit(0);
                    }
                    default -> System.out.println("⚠️ Invalid option!");
                }
            }

        } catch (IOException e) {
            System.out.println("Input error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("⚠️ Invalid input! Please enter numeric choices only.");
        }
    }
}
