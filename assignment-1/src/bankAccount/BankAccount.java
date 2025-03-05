package bankAccount;

import exception.InsufficientBalanceException;

public abstract class BankAccount implements AccountOperations {
    private final String accountNumber;
    private final String accountHolderName;
    private double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public abstract void deposit(double amount);
    public abstract void withdraw(double amount) throws InsufficientBalanceException;

    public String getAccountNumber() { return accountNumber; }

    public double getBalance() { return balance; }

    public void setBalance(double balance) {
        this.balance = balance;
    }
    public void displayAccountDetails() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber + "\n" +
        "Account Holder: " + accountHolderName + "\n" +
        "Balance: " + balance;
    }
}
