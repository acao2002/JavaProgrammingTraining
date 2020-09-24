import java.util.Scanner;
public class SMSTranslator {
   public static void main(String[] args) {
      /* Type your code here. Don't forget your comment block */
      Scanner scnr = new Scanner(System.in);
      String abbreSMS = getAbbreviation(scnr); // abbreSMS stands for abbreviated SMS
      String decodeAbbreviation = decodeAbbreviation(abbreSMS);
      printAbbreviation(decodeAbbreviation);
   }
   
   // Ask to input the SMS abbreviation
   public static String getAbbreviation(Scanner scnr) {
      System.out.println("Input the SMS abbreviation and I'll decode it for you:");
      String abbreSMS = scnr.next();
      return abbreSMS;
      
   }
   
   //This method returns the appropriate non-abbreviated string
   public static String decodeAbbreviation(String abbreSMS) {
      String decodedMessage;
      
      if (abbreSMS.equals("BTE")) {
         decodedMessage = "Translation: Blew The Exam :-(";
      }
      else
      if (abbreSMS.equals("BFF")) {
         decodedMessage = "Translation: Best Friends FOREVER!!! :-)";
      }
      else
      if (abbreSMS.equals("STT")) {
         decodedMessage = "Translation: Spill The Tea ;-)";
      }
      
      else {
         decodedMessage = "Translation: I'm sorry. I don't know that abbreviation yet.";
      }
      return decodedMessage;
      
   }
   
   
   //This method print the corresponsing output 
   public static void printAbbreviation(String abbreSMS) {
      System.out.println(abbreSMS);
   }
   
   
      
}
