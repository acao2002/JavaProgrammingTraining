// Name:  Andrew Cao 
// VUnetID: caoa5
// Email: an.cao@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 01 (MWF - Arena)
//
// Program description: This program checks if safe or not
// Date: 11/2/2020
// Honor statement: I have neither given nor received any unauthorized aid on this assignment. 

import java.util.Scanner;

public class TennesseeTwister {

    /**
     * main method
     * @param args
     */
   public static void main(String[] args) {
       int [] wl = new int [5];
    
        Scanner sc = new Scanner(System.in);
        int numR = loadWeights(wl,sc);
        if (numR > 0) {
            int totalWeight = totalWeights(wl, numR);
            double ave = calcAvgWeight(totalWeight, numR);
            System.out.println("Performing Safety Tests...");
            if(isSafeToRide(wl,totalWeight,ave,numR)) {
                System.out.println("Tennessee Twister is good to go. Have fun!");
            }
            else {
                System.out.println("Tennessee Twister is UNSAFE. DO NOT PROCEED!");
            }

        }

        System.out.println();
    
        System.out.println("Do you have another group of riders (y/n)?");
        char ans = Character.toLowerCase(sc.next().charAt(0));
        if(Character.compare(ans,'y') == 0) { 
            main(null);
        }
        


   }
   /**
    * get Weight from user each time
    * @param sc
    * @return weight
    */
   public static int getWeight(Scanner sc) {
    int input = 0;
    if (sc.hasNextInt() && sc.hasNext()) {
        input = sc.nextInt();
        if (input < -1 || input == 0) {
            System.out.println("Rider weight must be a value > 0 or -1 to stop. Enter the rider weight:");
            input = getWeight(sc);
        }
    }
    else {
        String a = sc.nextLine();

        System.out.println("Rider weight must be a value > 0 or -1 to stop. Enter the rider weight:");
        
        input = getWeight(sc);
    }
    
    
    return input;

    }
    /**
     * append items into list and return num of riders
     * @param weightlist
     * @param sc
     * @return number of riders
     */

    public static int loadWeights(int [] weightlist, Scanner sc ) {
        int i = 0; 
        int output = 0;
        while (i != -1){
            i++;
            System.out.println("Enter weight of rider #"+i+" (or -1 when done): ");
            int input = getWeight(sc);
            if (input != -1 && i!=5 ) {
                weightlist[i-1]= input;
            }
            else {
                output = i-1;
                i = -1;
            }
            
            
        }
        System.out.println("The number of riders is "+output);
        return output;
    }
    /**
     * get totalweights
     * @param wl
     * @param numR
     * @return total weight
     */
    public static int totalWeights(int wl[], int numR) {
        int sum = 0;
        for (int i =0; i <numR; i++){
            sum += wl[i];
        }
        System.out.println("Total ride weight: "+ sum);
        return sum;
    }
    /**
     * calculate the average
     * @param totalWeight
     * @param numRiders
     * @return the average
     */

    public static double calcAvgWeight(int totalWeight, int numRiders) {
       
        System.out.print("Avg rider weight:  ");
        System.out.printf("%.1f",  (double)totalWeight/numRiders);
        System.out.println();
        System.out.println();
        
        return (double)totalWeight/numRiders;
    }

    /**
     * return whether its safe or not
     * @param userWeight
     * @param totalWeight
     * @param avgWeight
     * @param numRiders
     * @return safe or not
     */

    public static boolean isSafeToRide(int[] userWeight, int totalWeight, double avgWeight, int numRiders) {
        boolean valid =  numRiders >= 2;
        if(valid){
            valid = totalWeight >= 200;
            if (valid){
                valid = totalWeight <= 900; 
                if (valid) {
                    for (int i = 0; i< numRiders; i++){
                        if ((userWeight[i]-100) > avgWeight) {
                            valid = false;
                        }
                        if (!valid){
                            System.out.println("SAFETY CHECK FAILED: Ride weight UNBALANCED.");
                        }
                    }    
            
                }
                else {
                    System.out.println("SAFETY CHECK FAILED: Ride weight OVER maximum capacity.");
                }
            }
            else {
                System.out.println("SAFETY CHECK FAILED: Ride weight UNDER minimum capacity.");
            }
        }
        else{
            System.out.println("SAFETY CHECK FAILED: Ride must have at least two riders.");
        }
        if (valid) {
            System.out.println("All safety checks passed.");
        }
        



        return valid; 

    }


}

