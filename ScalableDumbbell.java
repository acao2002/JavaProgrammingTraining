// Name:  Andrew Cao 
// VUnetID: caoa5
// Email: an.cao@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 01 (MWF - Arena)
//
// Program description: This program prints a sizable dumbbbell
// Date: 10/7/2020
// Honor statement: I have neither given nor received any unauthorized aid on this assignment. 

import java.util.Scanner;

public class ScalableDumbbell {
   public static void main(String[] args) {
      System.out.println("Enter an integer 2-6 for the scale:");
      Scanner scnr = new Scanner(System.in);
      int Input = getValidInput(scnr);
      PrintDumbbell(Input);

      /* Type your code here. */
   }
   /* obtain valid input from user */
   public static int getValidInput(Scanner sc) {

    int input = sc.nextInt();
    if (input < 2 || input > 6) {
        System.out.println("Scale must be a value between 2-6 inclusive. Enter the scale:");
        input = getValidInput(sc);
    }
    else {
        return input;
    }
    return input;
    }
    //print dumbbell
    public static void PrintDumbbell(int input) {
        printHead(input);
        printMid(input);
        printHead(input);
    }
    //loops for print dumbbell
    public static void printHead(int input) {

        for (int b = 0; b < input; b ++) {

            for (int i=1; i<(input-b); i++){
                System.out.print("  ");
            }
            System.out.print("/=");

            for (int a = 0; a < (input+b*2)+1; a ++) {
                System.out.print("\\/");
            }

            System.out.print("=\\");
            System.out.println();   
        }
        for (int c = 0; c < (5 + 2*(input-2));c++) {
            System.out.print("===");
            
        }
        System.out.println();
        
        for (int c = 0; c < (5 + 2*(input-2));c++) {
            System.out.print("===");   
        }

        System.out.println();
        
        for (int b = input; b >  0 ; b -= 1) {
            for (int i=0; i<(input-b); i++){
                System.out.print("  ");
            }
            System.out.print("\\=");

            for (int a = 1; a < (input+b*2); a ++) {
                System.out.print("/\\");
            }

            System.out.print("=/");
            System.out.println();   
        }      
    }
    public static void printMid(int input) {
        for (int k =0; k<input*input; k++) {

            System.out.print("     ");
            for (int i= 0 ; i<(input-2); i++) {
                System.out.print("  ");
            }
            System.out.print("|");
            for (int i=0; i<(input-2); i++){
                System.out.print("X");
            }
            System.out.print("||");
            for (int i=0; i<(input-2); i++){
                System.out.print("X");
            }
            System.out.println("|");
        }
        
    }

}


