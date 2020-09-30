// Name:  Andrew Cao 
// VUnetID: caoa5
// Email: an.cao@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 01 (MWF - Arena)
//
// Program description: This program classifies palindrome numbers 
// Date: 9/30/2020
// Honor statement: I have neither given nor received any unauthorized aid on this assignment. 


import java.util.Scanner;

public class PalindromeNums {
   public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int input = getNum(sc);
        if (isNumericPal(input)) {
            System.out.println(""+input + " is a numeric palindrome.");
        }
        else {
            System.out.println(""+input + " is not a numeric palindrome.");
        }

   }

   public static int getNum(Scanner sc) {
        System.out.println("Enter your integer number (1-999) on the line below:");
        System.out.println();
        int input = sc.nextInt();
        if (input < 1 || input > 999) {
           System.out.println("Input must be 1-999. Program cannot continue.");
           System.exit(0);
        }
        return input;
   }

   public static boolean isNumericPal(int input) {
         return (input < 10 || (input < 100 && (input/10 == input % 10)) || (input < 1000 && (input / 100 == input % 10)));  
   } 
}
