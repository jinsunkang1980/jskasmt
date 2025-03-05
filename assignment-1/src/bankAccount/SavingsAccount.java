package bankAccount;

import exception.InsufficientBalanceException;

public class SavingsAccount extends BankAccount {
    private static final double MIN_BALANCE = 500;

    public SavingsAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (getBalance() - amount < MIN_BALANCE) {
            throw new InsufficientBalanceException("Insufficient balance! Minimum balance of " + MIN_BALANCE + " required.");
        }
        setBalance(getBalance() - amount);
        System.out.println("Withdrawal successful! New balance: " + getBalance());
    }
}
