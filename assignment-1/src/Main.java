import bankAccount.BankAccount;
import bankAccount.CurrentAccount;
import bankAccount.SavingsAccount;
import exception.BankUserInputException;
import exception.InsufficientBalanceException;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static Map<String, BankAccount> accounts = new HashMap<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nWelcome to Bank System");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Display Account Details");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    depositMoney();
                    break;
                case 3:
                    withdrawMoney();
                    break;
                case 4:
                    displayAccount();
                    break;
                case 5:
                    System.out.println("Thank you for using the Bank System!");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter account type (savings/current): ");
        String type = scanner.next();
        System.out.print("Enter account number: ");
        String accNumber = scanner.next();
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();

        if (type.equalsIgnoreCase("saving")) {
            accounts.put(accNumber, new SavingsAccount(accNumber, name, balance));
        } else if (type.equalsIgnoreCase("current")) {
            accounts.put(accNumber, new CurrentAccount(accNumber, name, balance));
        } else {
            try {
                throw new BankUserInputException("The Account which user entered is not valid!");
            } catch (BankUserInputException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void depositMoney() {
        System.out.print("Enter account number: ");
        String accNumber = scanner.next();
        BankAccount account = accounts.get(accNumber);
        if (account == null) {
            try {
                throw new BankUserInputException("The Account which user entered is not found");
            } catch (BankUserInputException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
    }

    private static void withdrawMoney() {
        System.out.print("Enter account number: ");
        String accNumber = scanner.next();
        BankAccount account = accounts.get(accNumber);
        if (account == null) {
            try {
                throw new BankUserInputException("The Account which user entered is not found");
            } catch (BankUserInputException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        try{
            account.withdraw(amount);
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    private static void displayAccount() {
        System.out.print("Enter account number: ");
        String accNumber = scanner.next();
        BankAccount account = accounts.get(accNumber);
        if (account == null) {
            try {
                throw new BankUserInputException("The Account which user entered is not found");
            } catch (BankUserInputException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        account.displayAccountDetails();
    }

}