// Name:  Andrew Cao 
// VUnetID: caoa5
// Email: an.cao@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 01 (MWF - Arena)
//
// Program description: This program draws the hollabacktable based on the rows input
// Date: 10/8/2020
// Honor statement: I have neither given nor received any unauthorized aid on this assignment. 

import java.util.Scanner;

public class HollabackTable {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      System.out.println("How many rows of the table would you like?");
      int input = getHowManyRows(scnr);
      System.out.println();
      System.out.println("Here is your hollaback table:");
      drawHollabackTable(input);
      System.out.print("Would you like to do it again (Y/N)? ");
      char doagain = getDoAgain(scnr);

      if (doagain == 'Y' || doagain == 'y') {
        System.out.println("How many rows of the table would you like?");
        input = getHowManyRows(scnr);
        System.out.println();
        System.out.println("Here is your hollaback table:");
        drawHollabackTable(input);
        System.out.print("Would you like to do it again (Y/N)? ");
        doagain = getDoAgain(scnr);
  
      }

   }
   //get user's input
   public static int getHowManyRows(Scanner sc)  {
    int input = sc.nextInt();
    if (input < 1 || input > 30) {
        System.out.print("Please enter a value 1-30 inclusive: ");
        input = getHowManyRows(sc);
    }
    else {
        return input;
    }
    return input;
    
   }
   //decide whether to do it again based on user's input
   public static char getDoAgain(Scanner keyboard) {
    char input = keyboard.next().charAt(0);
    if  (input != 'Y' && input != 'N' && input != 'y' && input != 'n') {
        System.out.print("Please enter a valid response (Y/N): ");
        input = getDoAgain(keyboard);
    }
    return input;
    }
    //DrawHollabackTable based on the number of rows
    public static void drawHollabackTable(int in) {
        String input = computeLine(in);

        System.out.println();
        
    }   
    public static String computeLine(int in)  {
        String output = "";
        if (in < 1 || in > 30) {
            output = ""; 

        }
        else {
            output = String.valueOf(in);
            String input = "1";
            for (int t = 0; t < in; t ++) {    
                String newinput = "";
                int count = 1;
                char k = '0';
                if (t == 0) {
                    newinput = "1";
                }
                else {
                    for (int i=0; i< input.length();i++) {
                        if (i == 0) {
                            k = input.charAt(i); 
                        }
                        else
                        if (i != 0) {
                            if (input.charAt(i) == k) {
                                count += 1;
                            }
                            else {
                                newinput += String.valueOf(count)+String.valueOf(k); 
                                count = 1;
                                k = input.charAt(i);
                            }
                        }
                        if (i == input.length()-1) {
                            newinput += String.valueOf(count)+String.valueOf(k); 
                        }
                      
                    } 
                }
                System.out.print(newinput);
                input = newinput;
                System.out.println();
                
                }
            output = input;
        }
        return output;
    }
}
