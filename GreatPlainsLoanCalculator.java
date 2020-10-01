// Name:  Andrew Cao 
// VUnetID: caoa5
// Email: an.cao@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 01 (MWF - Arena)
//
// Program description: This program outlines the mortgage schedule
// Date: 10/1/2020
// Honor statement: I have neither given nor received any unauthorized aid on this assignment. 


import java.util.Scanner;
public class GreatPlainsLoanCalculator {
    
    public static final double initbalance = 5000;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        double input = getMonthlyPayment(sc);

        if (input < 250 || input > 850) {
            System.out.println("Monthly payment must be $250-$850. Program cannot continue.");
            System.exit(0);
        }
        else {
            printMortgageSchedule(input);
        }
        

    }

    /*int getMonthlyPayment(Scanner sc) - acquire input */

    public static double getMonthlyPayment(Scanner sc) {
        
        System.out.println("Enter the amount you will pay every month on the line below:");
        System.out.println();
        

        return sc.nextDouble();
    }

    /*void printMortgageSchedule - print the schedule as outlined by the prompt */

    public static void printMortgageSchedule(double amount) {

        printReportHeadings();

        double balance = initbalance; 
        double remaining = 5000;
        double finbalance = 0;

        for (int i = 1 ;i < 25; i ++) {
            
            double interest = remaining*2/12; 
            balance += interest;
            remaining = balance - amount;

            if (i < 24) {
                printSchedule(i, interest, balance, remaining, amount);
            }
            else {
                System.out.println(" 24        See final payment info below\n");
            }
            finbalance = balance;
            balance = remaining;

        }
        double totalpaid = remaining+amount*24;
        double totalinterestpaid = totalpaid - initbalance;


        printFinalPayment(finbalance, totalpaid, totalinterestpaid);
    }

    /*void printReportHeadings - print the heading of the mortgage schedule */

    public static void printReportHeadings() {

        System.out.println("Mortgage Payment Schedule");
        System.out.println("--------------------------");
        System.out.println("Amount borrowed: $5000");
        System.out.println("Month        Int.        Balance         Payment         Remaining");
    }

    /*void printSchedule - print the stats for each month */

    public static void printSchedule(int no, double interest, double balance,double remain, double amount) {
       
        System.out.print("  ");
        System.out.printf("%,d",no);
        System.out.print("           ");
        System.out.printf("%,9.2f", interest);
        System.out.print("        ");
        System.out.printf("%,9.2f", balance);
        System.out.print("          ");
        System.out.printf("%,9.2f", amount);
        System.out.println();
        System.out.print("        ");
        System.out.printf("%,9.2f", remain);
        System.out.println();

    }

    /*void printFinalPayment(double remaining, double totalpaid, double totalinterestpaid) - print the fianl payment of the mortgage */

    public static void printFinalPayment(double remaining, double totalpaid, double totalinterestpaid){
        
        System.out.print("Final payment: $");
        System.out.printf("%,9.2f", remaining);
        System.out.println();
        System.out.print("Total paid over 24 months: $");
        System.out.printf("%,9.2f", totalpaid);
        System.out.println();
        System.out.print("Total interest paid: $");
        System.out.printf("%,9.2f", totalinterestpaid);
        System.out.println();
        System.out.println("Thank you for your business...at Great Plains Loans, we treat you like family!");
    }
 }
 
 