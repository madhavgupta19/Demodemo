package com.myapp;

public class Customer {
    private String custName;
    private String custPhone;
    private String accountNumber;
    private String branchName;

    public Customer() {}

    public Customer(String custName, String custPhone, String accountNumber, String branchName) {
        this.custName = custName;
        this.custPhone = custPhone;
        this.accountNumber = accountNumber;
        this.branchName = branchName;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    @Override
    public String toString() {
        return "\n===== Customer Details =====" +
               "\nName: " + custName +
               "\nPhone: " + custPhone +
               "\nAccount Number: " + accountNumber +
               "\nBranch: " + branchName;
    }
}
