import java.util.Scanner;

import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors

public class BankAccount {
    private int accountNumber;
    private String accountName;
    private double accountBalance;
    private String accountAddress;
    private int accountAge;
    //private String phoneNumber;

    public BankAccount () {}

    public BankAccount(String accountName, int accountNumber, double accountBalance, String accountAddress, int accountAge) {
        this.accountName = accountName;
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountAddress = accountAddress;
        this.accountAge = accountAge;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }

    public void setAccountAge(int accountAge) {
        this.accountAge = accountAge;
    }
    //public void setPhoneNumber(String phoneNumber) {
      //  this.phoneNumber = phoneNumber;
    //}


    public String getAccountName() {
        return accountName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getAccountAddress() {
        return accountAddress;
    }

    public int getAccountAge() { return accountAge; }

    //public String getPhoneNumber() {
      //  return phoneNumber;
    //}

    public void deposit(double amount) {
        this.accountBalance += amount;
    }

    public void withdraw(double amount) {
        this.accountBalance -= amount;
    }

    public void transfer(BankAccount destination, double amount) {
        accountBalance -= amount;
        destination.accountBalance += amount;
    }

    public String toString() {
        return "Name: " + accountName + "\nAccount Number: " + accountNumber + "\nAccount Balance: " + accountBalance + "\nAddress: " + accountAddress;// + "\nPhone Number: " + phoneNumber;
    }


}



// In while loop run the following:
//      Create Account
//      Login
//          Request Balance
//          Withdraw Money
//          Deposit Money
//          Transfer Money
//          Close Account
//          Logout
//      Exit

// Create Account
//      Enter Name
//      Enter Address
//      Enter Age
//      Enter Contact Number
//      Enter Initial balance
//      Create Account Number
//      Enter Username
//      Enter Password
//      Save Account Details to File
//      Display Account Details

// Login
//      Enter Username
//      Enter Password

//      Request Balance
//          Read Text file and show balance
//      Withdraw Money
//          Read Text file and subtract amount
//      Deposit Money
//          Read Text file and add amount
//      Transfer Money
//          Get Account Number of destination account
//          Read current Text file and subtract amount
//          Read destination Text file and add amount
//      Close Account
//      Logout
//      Exit


// To do
//      Modify the createobject class with method to find curent username from file