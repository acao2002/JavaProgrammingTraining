// Name:  Andrew Cao 
// VUnetID: caoa5
// Email: an.cao@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 01 (MWF - Arena)
//
// Program description: This program reads the stats of the file
// Date: 10/28/2020
// Honor statement: I have neither given nor received any unauthorized aid on this assignment. 

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class StudentsFile {

    public static final String FILENAME = "Students.csv";
    public static final String F1 = "Freshman.txt";
    public static final String F2 = "Sophomore.txt";
    public static final String F3 = "Junior.txt";
    public static final String F4 = "Senior.txt";
    public static final String FBAD = "Bad.txt";
    public static int bad = 0;
    
    public static ArrayList<String> F = new ArrayList<String>();
    public static ArrayList<String> S = new ArrayList<String>();
    public static ArrayList<String> J = new ArrayList<String>();
    public static ArrayList<String> Se = new ArrayList<String>();
    public static ArrayList<String> badlist = new ArrayList<String>();
    public static ArrayList<String> goodlist = new ArrayList<String>();
    public static ArrayList<Double> ave1101 = new ArrayList<Double>();
    public static ArrayList<Double> ave1104 = new ArrayList<Double>();
    public static ArrayList<Double> ave2212 = new ArrayList<Double>();
    
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        File myFile = getInputFile(sc);
        try {
            Scanner fr = new Scanner(myFile);
            System.out.println("Can be read: "+myFile.canRead());
            System.out.println("Length: "+myFile.length());
            
            System.out.println();
            System.out.println("Student file Statistics");
            System.out.println("----------------------------------------------------------------------------------------");

            repeat(fr);
            fr.close();     
            
        } 
        catch (FileNotFoundException e) {
           System.out.println("An error occurred.");
           e.printStackTrace();
        }
        System.out.print("Total number of records analyzed: [");
        int allRecords = (goodlist.size()+badlist.size());
        System.out.printf("%3s", allRecords);
        System.out.print("]    rejected: [");
        System.out.printf("%3s", badlist.size());
        System.out.println("]");
        System.out.println();
        System.out.println("Average GPA per class:  cs1101    cs1104    cs2212");
        
        System.out.print("                        ");
        System.out.printf("%6.2f",calcAverage(ave1101));
        System.out.print("    ");
        System.out.printf("%6.2f",calcAverage(ave1104));
        System.out.print("    ");
        System.out.printf("%6.2f",calcAverage(ave2212));
        System.out.println();
        System.out.println();
        printNotEnroll();
    }

    /**
     * Get input file
     * @param sc
     * @return File
     */
    public static File getInputFile(Scanner sc) {
        String filename = "";
        System.out.print("Enter path for file \"Students.csv\" (e.g. allFiles/)? ");
        boolean file = false; 
        while (!file) {
            String path = sc.nextLine();
            filename = path +"Students.csv";
            File myFile = new File(filename);
            if (!myFile.exists()) {
                System.out.println("File does not exist. Please try again.");
                System.out.print("Enter path for file \"Students.csv\"? ");
            }
            else {
                file = true;
                System.out.println("Students.csv successfully found.");
                System.out.println();
            }
        }
        File myFile = new File(filename);
        return myFile;
    }
    /**
     * Scan over one record and perform operations
     * @param scn
     * @return whether its valid or not
     */
    public static boolean ScanOneLine(Scanner scn) {
        boolean valid = scn.hasNext();
        int n = 0; 
        String email ="";
        String id ="";
        double gpa =0;
        int year = 0;
        char cs01 = 'k';
        char cs04 = 'm';
        char cs20 = 'j';

        if (valid) {        
            email = scn.next();
            if(!IsValidEmail(email)){
                valid = false;
            }
            else {
                valid = scn.hasNext();
            }
        }
        if (valid) {
            id= scn.next(); 
            valid = scn.hasNextDouble();
        }
        if(valid){
            gpa = scn.nextDouble();
            valid = scn.hasNextInt();
        }
        if(valid){
            year = scn.nextInt();
            valid = scn.hasNext();
        }

        if(valid) {
            cs01 = scn.next().charAt(0);
            if (Character.compare(Character.toLowerCase(cs01), 'y') != 0 && Character.compare(Character.toLowerCase(cs01), 'n') != 0) { 
                valid = false;
            }
            else {
                if (Character.compare(Character.toLowerCase(cs01), 'y') == 0){
                    ave1101.add(gpa);
                }
                else{
                    n+=1;
                }
                valid = scn.hasNext();
            }   
        }
        if(valid) {
            cs04 = scn.next().charAt(0);
            if (Character.compare(Character.toLowerCase(cs04),'y') != 0 && Character.compare(Character.toLowerCase(cs04), 'n') != 0) {
                valid = false;
            }
            else {
                if (Character.compare(Character.toLowerCase(cs04), 'y') == 0){
                    ave1104.add(gpa);
                }
                else{
                    n+=1;
                }
                valid = scn.hasNext();
            }  
        }
        if(valid) {
            cs20 = scn.next().charAt(0);
            if (Character.compare(Character.toLowerCase(cs20), 'y') != 0 && Character.compare(Character.toLowerCase(cs20), 'n') != 0) {
                valid = false;
            }
            else {
                if (Character.compare(Character.toLowerCase(cs20), 'y') == 0){
                    ave2212.add(gpa);
                }
                else{
                    n+=1;
                }
                valid = true;
            }  
        }
        if (n == 3){
            switch (year){
                case 1:
                    F.add(email.replace("@vanderbilt.edu", ""));
                    break;
                case 2:
                    S.add(email.replace("@vanderbilt.edu", ""));
                    break;
                case 3: 
                    J.add(email.replace("@vanderbilt.edu", ""));
                    break;
                case 4: 
                    Se.add(email.replace("@vanderbilt.edu", ""));
                    break;
            }
        }
        if (!valid){
            badlist.add(email.replace("@vanderbilt.edu", "").replace(".", " "));
        }
        else {
            goodlist.add(email);
        }
        return valid;
    }
    /**
     * is valid email?
     * @param email
     * @return valid email or not
     */
    public static boolean IsValidEmail(String email) {
        return (email.contains("@vanderbilt.edu"));
    }
    /**
     * repeat scanoneline until no line is found
     * @param sc
     */
    public static void repeat (Scanner sc) {
        Scanner scn = new Scanner(sc.nextLine());
        scn.useDelimiter("[, \n]");
        ScanOneLine(scn);
        if(sc.hasNextLine()) {
            repeat(sc);
        }
    }
    /**
     * count the average of each class
     * @param list
     * @return average
     */
    public static double calcAverage(ArrayList<Double> list) {
        int a = 0;
        double sum = 0;
        double result = 0;
        if (list.size() > 0) {
            for(Double elem: list){
                a += 1;
                sum+= elem;
            }
            result =  (double)(sum/a);
        }
        else {
            result = -1;
        }
     
        return result;
    }

    /**
     * print the list of people not enrolled
     */
    public static void printNotEnroll(){
        int Fsize = F.size();
        int Ssize = S.size();
        int Jsize = J.size();
        int Sesize = Se.size();
        int max = Math.max(Math.max(Fsize,Ssize),Math.max(Jsize,Sesize));
        String Fitem = "";
        String Sitem = "";
        String Jitem = "";
        String Seitem = "";

        System.out.println("Students not registered in CS1101 nor CS1104 nor CS2212");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.print("Freshman [");
        System.out.printf("%2s",Fsize);
        System.out.print("]            Sophomore [");
        System.out.printf("%2s", Ssize);
        System.out.print("]           Junior [");
        System.out.printf("%2s", Jsize);
        System.out.print("]              Senior [");
        System.out.printf("%1s", Sesize);
        System.out.println("]");
        System.out.println("----------------------------------------------------------------------------------------");

        for(int i = 0; i< max; i++){
            if (i < Fsize){
                Fitem = F.get(i);
            }
            else {
                Fitem =" ";
            }
            if (i < Ssize){
                Sitem = S.get(i);
            }
            else {
                Sitem =" ";
            }
            if (i < Jsize){
                Jitem = J.get(i);
            }
            else {
                Jitem =" ";
            }
            if (i < Sesize){
                Seitem = Se.get(i);
            }
            else {
                Seitem =" ";
            }
            printNotLine(Fitem, Sitem, Jitem, Seitem);

        }
    }
    /**
     * print one line of not enrolled
     * @param F
     * @param S
     * @param J
     * @param Se
     */
    public static void printNotLine(String F, String S, String J,String Se){
        System.out.printf("%-25s", F);
        System.out.printf("%-25s", S);
        System.out.printf("%-25s", J);
        System.out.printf("%-25s", Se);
        System.out.println();
    }

}
