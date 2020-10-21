// Name:  Andrew Cao 
// VUnetID: caoa5
// Email: an.cao@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 01 (MWF - Arena)
//
// Program description: This program verifies inputs
// Date: 10/15/2020
// Honor statement: I have neither given nor received any unauthorized aid on this assignment. 

import java.util.Scanner;

public class ValidateMeII {
   public static final double TOLERANCE=  0.0001;
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      
      System.out.println("Enter an integer test score between 0-100 inclusive:");

      int testscore = getValidIntScore(scnr);
      
      System.out.println("Enter student's full name:");
      String a = scnr.nextLine();
      String fullname = getValidStrName(scnr);
      System.out.println("Enter class average 0-100 inclusive:");
      double average = getValidDoubleClassAvg(scnr);
      System.out.println("Enter the student grade (A, B, C, D, F):");
      char grade = getValidCharGrade(scnr);
   }
   /* getValidIntScore(Scanner sc): return a valid student score from the input */

   public static int getValidIntScore(Scanner sc) {
        int input = 0;
        if (sc.hasNextInt() && sc.hasNext()) {

            input = sc.nextInt();
            if (input < 0 || input > 100) {
                System.out.println("Test score must be a value between 0-100 inclusive. Enter the test score:");
                
                getValidIntScore(sc);
            }
            else {
                System.out.println("You entered a valid test score of: " + input);
            }
        }
        else {
            String a = sc.nextLine();
 
            System.out.println("Test score must be a value between 0-100 inclusive. Enter the test score:");
            
            getValidIntScore(sc);
        }
        
        
        return input;

   }
   /* String getValidStrName(Scanner sc): return a valid student name from the input */

   public static String getValidStrName(Scanner sc) {
        
        String input = sc.nextLine();
        if (input == null || input.trim().isEmpty()) {
            
            System.out.println("Name must be non-empty and non-blank. Enter the student's full name:");
            getValidStrName(sc);
        }
        else {
            
            System.out.println("You entered the student: " + input);
        }
        return input;
   }
   
   public static double getValidDoubleClassAvg(Scanner sc) {
       
        double input = 0; 
        if (sc.hasNextDouble() && sc.hasNext()) {
            input = sc.nextDouble();
            if ((Math.abs(input - Math.round(input))) <= TOLERANCE) {
                input = Math.round(input) ;
            }
            if (input < 0 || input > 100) {
                System.out.println("Class average must be a value between 0 - 100 inclusive. Enter the class average:");
                getValidDoubleClassAvg(sc);
            }
            else {
                //System.out.printf("'%5.2f'%n", 5.1473);
                System.out.print("You entered a valid avg: ");
                System.out.printf("%.2f", (Math.round(input*100.00)/100.00));
                System.out.println();
            }
        }
        else {
            String a = sc.nextLine();
            if (a == null || a.trim().isEmpty()) {
                System.out.println("Class average must be a value between 0 - 100 inclusive. Enter the class average:");
                System.out.println("Class average must be a value between 0 - 100 inclusive. Enter the class average:");
                getValidDoubleClassAvg(sc);
            }
            else {
                System.out.println("Class average must be a value between 0 - 100 inclusive. Enter the class average:");
                getValidDoubleClassAvg(sc);
            }
            
        }
        
        return input;
    }
    public static char getValidCharGrade(Scanner keyboard) {
        char input = '1';
        String a = keyboard.nextLine(); 
        if (a == null || a.trim().isEmpty()) {
            
            if( a.length() == 0 ) {
                System.out.println("Grade must be one of: A, B, C, D, F. Enter the student grade:");
            }
            
            getValidCharGrade(keyboard);
            
        }
        else {
            input = a.charAt(0);
            input = Character.toUpperCase(input);
            if  ( input!= 'A' && input != 'B' && input != 'C' && input != 'D' && input != 'E' && input != 'F') {
                System.out.println("Grade must be one of: A, B, C, D, F. Enter the student grade:");
                getValidCharGrade(keyboard);
            }
            else {
            //System.out.printf("'%5.2f'%n", 5.1473);
                System.out.println("You entered a valid grade: "+ input);
        }
        }
        
        return input;
    }
}