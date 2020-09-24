// Name:  Andrew Cao 
// VUnetID: caoa5
// Email: an.cao@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 01 (MWF - Arena)
//
// Program description: This program selects the winning numbers for the Powerball lottery
// Date: 
// Honor statement: I have neither given nor received any unauthorized aid on this assignment. 


import java.util.*;

public class WeShip {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);  //scanner object to pass around

        //get item description
        String itemDescription = getItemDescription(keyboard);
        if (itemDescription.length() == 0) {
        System.out.println("Invalid description. Program cannot continue");
        System.exit(0);
        }

        double shipWeight = getShipWeight(keyboard);
        if (shipWeight <= 0.0) {
        System.out.println("Invalid shipping weight. Program cannot continue");
        System.exit(0);
        }

        //get shipping method
        char shipMethod = getShipClass(keyboard);
        String st = String.valueOf(shipMethod);
        if  (!st.equals("o")) {
                if  (!st.equals("t")) {
                           if  (!st.equals("e")) {
                              System.out.println("Invalid shipping method. Program cannot continue");
                              System.exit(0);
                           }
                 }
        }

        
        shipMethod = Character.toUpperCase(shipMethod);
        String sm = String.valueOf(shipMethod);
        //calculate shipping cost and display results
        double shipCost = calculateShipping(shipMethod, shipWeight);
        displayResults(itemDescription, shipCost, shipMethod, shipWeight);
    }

    //get item description and return it
    public static String getItemDescription(Scanner keyboard) {

        System.out.println("Enter item description:");
        String description = keyboard.nextLine();
        return description;
    }

    //get item weight and return it
    public static double getShipWeight(Scanner console) {
        //get shipping weight
        System.out.println("Enter item weight in lbs:");
        double weight = console.nextDouble();

        return weight;
    }

    //get user's choice for shipping method and return it
    public static char getShipClass(Scanner keyboard) {
        char shipMethod;

        //get shipping method
        System.out.println();
        System.out.println("How fast would you like to ship your package:");
        System.out.println("(O)vernight");
        System.out.println("(T)wo Days");
        System.out.println("(E)conomy (may take up to 7 days)");
        System.out.print("Choose an option: ");
        shipMethod = keyboard.next().charAt(0); //Prof. Dan says leave this line in here. Will explain in class.
        return shipMethod;
    }

    //calculate and return shipping charge
    public static double calculateShipping(char shipMethod, double weight) {

        double shipCharge = 0.0;
        String shipmethod = String.valueOf(shipMethod);

        if (shipmethod == "O") {
        shipCharge = weight * 5;
        } else if (shipmethod == "T") {
        shipCharge = weight * 3;
        } else {
        shipCharge = weight * 2;}
        return (shipCharge);
        
    }

    //display shipping charge invoice
    public static void displayResults(String itemDescription,double shipWeight, char shipMethod, double shipCost) {
        System.out.println();
        System.out.println("*** WE SHIP INVOICE ***");
        System.out.println("Item Description: " + itemDescription);
        System.out.printf("Item Weight: %.2f\n", shipWeight);
        System.out.println("Ship Method: " + shipMethod);
        System.out.printf("Total Cost: %.2f\n", shipCost);
        
    }
}