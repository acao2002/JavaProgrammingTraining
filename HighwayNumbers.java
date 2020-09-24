// Name:  Andrew Cao 
// VUnetID: caoa5
// Email: an.cao@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 01 (MWF - Arena)
//
// Program description: This program classifies highway in the us
// Date: 9/24/2020
// Honor statement: I have neither given nor received any unauthorized aid on this assignment. 

import java.util.Scanner;

public class HighwayNumbers {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      System.out.println("Enter the highway number:");
      int Input = getHighway(scnr);
      int PN = Input - (Input/100) * 100;
      if (isValidHighway(Input)) {
          if (isValidAuxillaryHighWay(Input)) {
            System.out.print("the "+Input + " is an Auxillary highway, servicing the "+PN+" ");
            calculateAndDisplayDirection(PN);
          }
          else {
            System.out.print("the "+Input + " is a primary highway " );
            calculateAndDisplayDirection(PN);
          }
      }else {
         System.out.println(Input+ "is not a valid interstate highway number. Program cannot continue.");
      }
   }
   public static int getHighway(Scanner sc) {
      return sc.nextInt();
   }
   public static boolean isValidHighway(int number) {
      return (number > 0 && number < 1000); 
   }

   public static boolean isValidAuxillaryHighWay(int number) {
      return(number/100 > 0);  
   }
   public static void calculateAndDisplayDirection(int number) {
      if (number % 2 == 0) {
         System.out.print("east-to-west.");
      }
      else {
         System.out.print("north-to-south");
      }
   }
}