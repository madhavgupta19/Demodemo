package com.myapp;

import java.io.BufferedReader;
import java.io.IOException;

public class BankOperations implements RBI {

    private BufferedReader buff;
    private Customer cust;
    private double balance = 0;
    private double bankInterestRate = 6.5; // Bank’s own FD rate (above RBI)
    private String branchName;

    public BankOperations(BufferedReader buff) {
        this.buff = buff;
    }

    @Override
    public void createAccount() {
        try {
            System.out.println("Enter Customer Name:");
            String name = buff.readLine();
            while (!Helper.isValidName(name)) {
                System.out.println("❌ Invalid name! Enter alphabets only (min 3 letters):");
                name = buff.readLine();
            }

            System.out.println("Enter Customer Phone (10 digits):");
            String phone = buff.readLine();
            while (!Helper.isValidPhone(phone)) {
                System.out.println("❌ Invalid phone! Must be 10 digits and start with 6–9:");
                phone = buff.readLine();
            }

            System.out.println("Enter Branch Name:");
            branchName = buff.readLine();
            while (!Helper.isValidBranch(branchName)) {
                System.out.println("❌ Invalid branch! Minimum 3 characters required:");
                branchName = buff.readLine();
            }

            String accNum = Helper.generateAccountNumber();
            cust = new Customer(name, phone, accNum, branchName);
            balance = MIN_BALANCE;

            System.out.println("\n✅ Account created successfully!");
            System.out.println(cust);
            System.out.println("Minimum Balance Maintained: ₹" + MIN_BALANCE + " (as per RBI)");
        } catch (IOException e) {
            System.out.println("Error creating account: " + e.getMessage());
        }
    }

    @Override
    public void depositMoney() {
        if (cust == null) {
            System.out.println("❌ No account exists. Please create an account first.");
            return;
        }
        try {
            System.out.println("Enter amount to deposit:");
            double amount = Double.parseDouble(buff.readLine());
            if (!Helper.isValidAmount(amount)) {
                System.out.println("❌ Invalid amount!");
                return;
            }
            balance += amount;
            System.out.println("✅ ₹" + amount + " deposited successfully. Current balance: ₹" + balance);
        } catch (Exception e) {
            System.out.println("Error depositing money: " + e.getMessage());
        }
    }

    @Override
    public void withdrawMoney() {
        if (cust == null) {
            System.out.println("❌ No account exists. Please create an account first.");
            return;
        }
        try {
            System.out.println("Enter amount to withdraw:");
            double amount = Double.parseDouble(buff.readLine());
            if (!Helper.isValidAmount(amount)) {
                System.out.println("❌ Invalid amount!");
                return;
            }

            if ((balance - amount) >= MIN_BALANCE) {
                balance -= amount;
                System.out.println("✅ ₹" + amount + " withdrawn successfully. Remaining balance: ₹" + balance);
            } else {
                System.out.println("❌ Cannot withdraw! Maintain minimum ₹" + MIN_BALANCE + " as per RBI rules.");
            }
        } catch (Exception e) {
            System.out.println("Error withdrawing money: " + e.getMessage());
        }
    }

    @Override
    public void openFD() {
        if (cust == null) {
            System.out.println("❌ No account exists. Please create an account first.");
            return;
        }
        try {
            System.out.println("Enter FD amount:");
            double amount = Double.parseDouble(buff.readLine());
            if (!Helper.isValidAmount(amount) || amount < 1000) {
                System.out.println("❌ FD amount must be at least ₹1000.");
                return;
            }

            System.out.println("Enter FD duration in years:");
            int years = Integer.parseInt(buff.readLine());

            if (years < MIN_FD_YEARS) {
                System.out.println("❌ FD duration must be at least " + MIN_FD_YEARS + " years (RBI rule).");
                return;
            }

            double effectiveRate = Math.max(bankInterestRate, MIN_FD_INTEREST);
            double maturity = amount + (amount * effectiveRate * years) / 100;

            System.out.println("\n✅ Fixed Deposit Created Successfully!");
            System.out.println("Principal Amount: ₹" + amount);
            System.out.println("Duration: " + years + " years");
            System.out.println("Interest Rate: " + effectiveRate + "%");
            System.out.println("Maturity Amount: ₹" + maturity);
        } catch (Exception e) {
            System.out.println("Error creating FD: " + e.getMessage());
        }
    }

    @Override
    public void applyLoan() {
        if (cust == null) {
            System.out.println("❌ No account exists. Please create an account first.");
            return;
        }
        try {
            System.out.println("Enter loan amount:");
            double amount = Double.parseDouble(buff.readLine());
            if (!Helper.isValidAmount(amount)) {
                System.out.println("❌ Invalid loan amount!");
                return;
            }

            System.out.println("Enter duration in years:");
            int years = Integer.parseInt(buff.readLine());

            System.out.println("Enter interest rate offered by bank:");
            double rate = Double.parseDouble(buff.readLine());

            double totalInterest = (amount * rate * years) / 100;
            double totalRepay = amount + totalInterest;

            System.out.println("\n✅ Loan Approved!");
            System.out.println("Principal: ₹" + amount);
            System.out.println("Interest Rate: " + rate + "%");
            System.out.println("Tenure: " + years + " years");
            System.out.println("Total Repayment: ₹" + totalRepay);
        } catch (Exception e) {
            System.out.println("Error applying for loan: " + e.getMessage());
        }
    }
}
