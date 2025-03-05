package bankAccount;

import exception.InsufficientBalanceException;

public class CurrentAccount extends BankAccount{
    private final static double OVERDRAFT_LIMIT = -1000;

    public CurrentAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (getBalance() - amount < OVERDRAFT_LIMIT) {
            throw new InsufficientBalanceException("Withdrawal exceeds overdraft limit: "  + OVERDRAFT_LIMIT);
        }
        setBalance(getBalance() - amount);
        System.out.println("Withdrawal successful! New balance: " + getBalance());
    }
}
