// Name:  Andrew Cao 
// VUnetID: caoa5
// Email: an.cao@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 01 (MWF - Arena)
//
// Program description: This program reads a file and output the num of Armstrongnum in the file
// Date: 10/20/2020
// Honor statement: I have neither given nor received any unauthorized aid on this assignment. 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Armstrong {

    /**
     * main
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        
        int armNum = 0; 
        int nArmNum = 0; 
        int badToken = 0; 
        File myFile = getInputFile(sc);
        try {
             System.out.println("Scanning data.txt...");
             Scanner fr = new Scanner(myFile);
             while (fr.hasNext()) {

                if (fr.hasNextInt()){
                    int token = fr.nextInt();
                    if (isArmstrong(token)) {
                        System.out.println("Number : " + token + " is an Armstrong number.");
                        armNum +=1;
                    }
                    else {
                        nArmNum +=1;
                    }
                }

                else {
                    String p = fr.next();
                    badToken +=1;
                }
             }
            fr.close();     
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        displayReport(myFile, armNum, nArmNum, badToken);
        
    }
    /** File getInputFile(Scanner sc)
     * Ask the user to enter the path of the file then use it to acquire the file
     * @param sc
     * @return file input
     */
 
    public static File getInputFile(Scanner sc) {
        String filename = "";
        System.out.print("Enter path for file \"data.txt\"? ");
        boolean file = false; 
        while (!file) {
            String path = sc.nextLine();
            filename = path +"data.txt";
            File myFile = new File(filename);
            if (!myFile.exists()) {
                System.out.println("Cannot find file at that location. Please try again.");
                System.out.print("Enter path for file \"data.txt\"? ");
            }
            else {
                file = true;
                System.out.println("data.txt successfully found.");
                System.out.println();
            }
        }
        File myFile = new File(filename);
        return myFile;
    }

    /**isArmstrong(int number)
     * Determine whether a number is an armstrong num or not
     * @param number
     * @return armstrong num or not(true or false)
     */
    public static boolean isArmstrong(int number) {
        int d1 = number/100; 
        int d2 = (number-d1*100)/10;
        int d3 = number - d1*100 - d2*10;
        
        return(d1*d1*d1 + d2*d2*d2 + d3*d3*d3 == number);

    }
    /**displayReport(File file, int armNum, int nArmNum, int badToken)
     * Print the final results
     * @param file
     * @param armNum
     * @param nArmNum
     * @param badToken
     */
    public static void displayReport(File file, int armNum, int nArmNum, int badToken) {
        System.out.println();
        System.out.println("Final Report for data.txt");
        System.out.println();
        System.out.print("File Length (in bytes): ");
        System.out.println(file.length());
        System.out.println("The file has "+ armNum + " Armstrong numbers.");
        System.out.println("The file has " + nArmNum + " non-Armstrong numbers." );
        System.out.println("The file has "+ badToken +" bad tokens.");
    }
}