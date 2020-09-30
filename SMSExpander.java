// Name:  Andrew Cao 
// VUnetID: caoa5
// Email: an.cao@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 01 (MWF - Arena)
//
// Program description: This program expands the SMS message
// Date: 9/30
// Honor statement: I have neither given nor received any unauthorized aid on this assignment. 



import java.util.*;

public class SMSExpander {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      
      String input = getText(scnr);
    
      String output =  expandAbbreviation(input);

      printExpanded(output); 
   }

   /* String getText(Scanner scnr) - obtain input from the user to be translated */
   
   public static String getText(Scanner scnr) {
      System.out.println("Input the text you'd like to decode below followed by the enter key:");
      System.out.println();
      String input = scnr.nextLine();
      return input;
   }

   /*String expandAbbreviation(String userString) - replace the abbreviated words with expanded terms in the input */

   public static String expandAbbreviation(String userString) {
        
       if (!userString.contains("BFF") && !userString.contains("BTE") && !userString.contains("IDK") && !userString.contains("STT") ) {
        
        System.out.println("Could not find any SMS abbreviations I know to expand.");
       }
       if (userString.contains("BFF")) {

        userString = userString.replace("BFF", "best friend forever");
        System.out.println("Replacing \"BFF\" with \"best friend forever\"");
       }

       if (userString.contains("BTE")) {

        userString = userString.replace("BTE", "blow the exam");
        System.out.println("Replacing \"BTE\" with \"blow the exam\"");
       }

       if (userString.contains("STT")) {

        userString = userString.replace("STT", "spill the tea");
        System.out.println("Replacing \"STT\" with \"spill the tea\"");
       }

       if (userString.contains("IDK")) {

        userString = userString.replace("IDK", "I don't know");
        System.out.println("Replacing \"IDK\" with \"I don't know\"");
       }
       
       


       return userString; 
   }

   /* void printExpanded(String result)- print the expanded message */
   public static void printExpanded(String result) {
        System.out.println();
        System.out.println("Expanded: "+ result) ;
   }
}