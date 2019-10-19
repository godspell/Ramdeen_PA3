/*
    Zahid Ramdeen
    COP3330-19Fall 0002
    Programming Assignment 3 - Problem 2
 */

public class SavingsAccountTester {

    // simulates the interest accumulating over x-months
    private static void passTime(int months, SavingsAccount saver1, SavingsAccount saver2){
        for(int i = 0; i < months; i++){
            saver1.calculateMonthlyInterest();
            saver2.calculateMonthlyInterest();
        }
    }

    private static void print(SavingsAccount saver1, SavingsAccount saver2){
        System.out.printf("Saver1 new balance is $%.2f\n", saver1.getSavingsBalance());
        System.out.printf("Saver2 new balance is $%.2f\n", saver2.getSavingsBalance());
    }

    public static void main(String[] args) {
        SavingsAccount saver1  = new SavingsAccount(2000.0);
        SavingsAccount saver2  = new SavingsAccount(3000.0);

        // Print out initial
        System.out.println("\nInitial Values in accounts.");
        print(saver1, saver2);

        // Set the interest rate to 4%
        double rate = 0.04;
        SavingsAccount.modifyInterestRate(rate);

        // Calculate the Monthly Interest for 12 months for both savers.
        passTime(12, saver1, saver2);

        // Print new balances
        System.out.printf("\nAfter 12 months with %.2f interest.\n", rate);
        print(saver1, saver2);

        // Set the interest rate to 5%
        rate = 0.05;
        SavingsAccount.modifyInterestRate(rate);
        System.out.printf("\nAfter 12 months with %.2f interest.\n", rate);
        passTime(12, saver1, saver2);
        print(saver1, saver2);


    }
}
