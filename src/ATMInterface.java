import java.util.InputMismatchException;
import java.util.Scanner;

public class ATMInterface {
    private static double balance = 1000.00;
    
    public static double getBalance() {
        return balance;
    }
    public static void displayMenu() {
		// TODO Auto-generated method stub
      System.out.println("\n<<<================ATM MENU================>>>");
      System.out.println("1. Balance Inquiry");
      System.out.println("2. Deposit");
      System.out.println("3. Withdrawal");
      System.out.println("4. Exit");
      System.out.print("Enter your choice: ");

	}
    
    public static void balanceInquiry() {
    	double currentBalance = getBalance();
    	System.out.printf("Balance: %.2f%n", currentBalance); 
    }

    public static void depositAmount(double amount) {
        if (amount <= 0 || !Double.isFinite(amount)) {
            System.out.printf("Invalid amount (%.2f). Deposit must be greater than 0.00.%n", amount);
            return;
        }
        balance += amount;
        System.out.printf("Deposited: %.2f | Updated Balance: %.2f%n", amount, balance);
    }

    public static void withDrawal(double amount) {
        if (amount <= 0 || !Double.isFinite(amount)) {
            System.out.printf("Invalid amount (%.2f). Withdrawal must be greater than 0.00.%n", amount);
        } else if (amount > balance) {
            System.out.printf("Insufficient balance for %.2f! Available Balance: %.2f%n", amount, balance);
        } else {
            balance -= amount;
            System.out.printf("Withdrawn: %.2f | Remaining Balance: %.2f%n", amount, balance);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int choice = 0;

        do {
        	displayMenu();

            try {
                choice = scan.nextInt();

                switch (choice) {
                    case 1:
                        balanceInquiry();
                        break;
                    case 2:
                        System.out.print("Enter the deposit amount: ");
                        depositAmount(scan.nextDouble());
                        break;
                    case 3:
                        System.out.print("Enter the withdrawal amount: ");
                        withDrawal(scan.nextDouble());
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM.");
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter 1 to 4.");
                }
            } catch (InputMismatchException e) {
            	System.out.println("Invalid input! Please enter numeric values with in the options.");
                scan.nextLine();
                choice = 0;
            }

        } while (choice != 4);

        scan.close();
    }
}