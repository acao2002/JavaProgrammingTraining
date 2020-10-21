// Name:  Andrew Cao 
// VUnetID: caoa5
// Email: an.cao@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 01 (MWF - Arena)
//
// Program description: This program does Monte Carlo
// Date: 10/16/2020
// Honor statement: I have neither given nor received any unauthorized aid on this assignment. 

import java.util.Scanner;

public class MonteCarlo {
    static int rnd;
    static final int N_CNT = 6;     //  Each question has that many outcomes
    static final int Q_CNT = 10000; //  Number of questions for the test


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); 
        rnd = getSeed(sc);
        System.out.println();
        System.out.println("*****************************************************************");
        System.out.println("*  (1)  *  (2)  *  (3)  *  (4)  *  (5)  *  (6)  *  (7)  *  (8)  *");
        System.out.println("*****************************************************************");
        for (int i = 10; i<110; i+= 10){
            printTable(i);
        }
        System.out.println();
        System.out.println(" (1) : Probability for each student to be right.");
        System.out.println(" (2) : Number of questions simulated.");
        System.out.println(" (3) : Number of times student 1 was right.");
        System.out.println(" (4) : Number of times student 2 was right.");
        System.out.println(" (5) : Number of times student 1&2 were both right.");
        System.out.println(" (6) : Number of times student 1&2 agreed but were wrong.");
        System.out.println(" (7) : Number of times student 1&2 disagreed.");
        System.out.println(" (8) : Ratio (5) / [(5) + (6)].");

            


    }
        /**
     * Create a pseudo random number between MIN (included) and MAX (included)
     * Note: modifies the global number rnd each time.
     * @return: random number
        */
    public static int getRandom (int rnd){
        long multiplier = 16807;
        long modulus = 2147483647;
        return (int)((multiplier * rnd) % modulus);
    }

        /**
         * check input and prompt until the right one is typed
         * @param sc
         * @return correct input typed by user
         */

    public static int getSeed(Scanner sc) {
        int input = -1;
        System.out.print("Enter an integer in ]0, 100] ? ");
        if (sc.hasNextInt()) {
            input = sc.nextInt();
            if (input < 0 || input > 100) {
                System.out.println("Incorrect value.");
                input = getSeed(sc);
            }
        }
        else {
            sc.nextLine(); 
            System.out.println("Incorrect value.");
            input = getSeed(sc);
        }
        return input;
    }
    /**
     * get random value and check if its correct or not
     * @param pright
     * @return the answer of student
     */
    public static int getAnswer(int pright) {
        int ans = 0;
        rnd = getRandom(rnd); 
        if ((rnd % 100) < pright) {
            ans = 1;
        }
        else {   
            rnd = getRandom(rnd);   
            ans = (rnd%5)+2;
        }
        return ans;
    }

    /**
     * Print the table of the percentage using getAnswer()
     * @param pright
     */
    public static void printTable(int pright) {
        int count1 = 0;
        int count2 = 0;
        int bothright = 0;
        int agreewrong = 0;
        int disagree = 0;
        double ratio = 0;
        for (int i =0; i <10000; i++){  
            int ans1 = getAnswer(pright); 
            int ans2 = getAnswer(pright);
            if (ans1 == 1) {
                count1+=1;
                if (ans2 == ans1) {
                    bothright +=1;
                    count2+=1;
                }

            }
            else {
                if (ans2 == 1) {
                    count2+=1;
                }
                if(ans2 == ans1) {
                    agreewrong +=1;
                }
 
            }
            if (ans1 != ans2) {
                disagree +=1;
            }
 
        }
        ratio = (double) bothright/(bothright+agreewrong);
        
        System.out.print("*  ");
        System.out.printf("%3d",pright);
        System.out.print("% * 10000 * ");
        System.out.printf("%5d",count1);
        System.out.print(" * ");
        System.out.printf("%5d",count2);
        System.out.print(" * ");
        System.out.printf("%5d",bothright);
        System.out.print(" * ");
        System.out.printf("%5d",agreewrong);
        System.out.print(" * ");
        System.out.printf("%5d",disagree);
        System.out.print(" * ");
        System.out.printf("%5.2f",ratio);
        System.out.println(" *");

    } 

}