package com.myapp;

public interface RBI {
    double MIN_BALANCE = 5000.0;
    int MIN_FD_YEARS = 3;
    double MIN_FD_INTEREST = 3.0; // RBI base interest %

    void createAccount();
    void depositMoney();
    void withdrawMoney();
    void openFD();
    void applyLoan();
}
