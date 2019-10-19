/*
    Zahid Ramdeen
    COP3330-19Fall 0002
    Programming Assignment 3 - Problem 2
 */

public class SavingsAccount {

    // Required Variables
    private static double annualInterestRate;
    private double savingsBalance;

    /* Constructors */
    public SavingsAccount(){
        this(0);
    }
    public SavingsAccount(double savingsBalance){
        this.savingsBalance = savingsBalance;
    }
    public SavingsAccount(double savingsBalance, double interestRate){
        this.savingsBalance = savingsBalance;
        annualInterestRate = interestRate;
    }

    /* Methods */
    // Calculates the monthly interest and updates the variable (also returns?)
    public void calculateMonthlyInterest(){
        this.savingsBalance += this.savingsBalance * annualInterestRate / 12.0;
        System.out.println(this.savingsBalance);
    }

    /* Getters and Setters */
    // annualInterestRate
    public static void modifyInterestRate(double rate){
        annualInterestRate = rate;
    }
    public static double getInterestRate(){
        return annualInterestRate;
    }

    // savingsBalance
    public void setSavingsBalance(double savingsBalance){
        this.savingsBalance = savingsBalance;
    }
    public double getSavingsBalance(){
        return savingsBalance;
    }
}
