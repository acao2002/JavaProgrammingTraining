// Name:  Andrew Cao 
// VUnetID: caoa5
// Email: an.cao@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 01 (MWF - Arena)
//
// Program description: This runs simulation
// Date: 11/4/2020
// Honor statement: I have neither given nor received any unauthorized aid on this assignment. 

import java.util.Arrays;

public class Parking {
    static final int[] PKG_SIZE = {50, 100, 150, 200, 250};
    static final int HOURLY_COST = 3;
    static final int DAiLY_COST = 20;
    static final int HOUR_MAX = 72;
    static final int HOURS_SIMULATION = 31 * 24;
    static final long MODULUS = 2147483647;
    static final long SEED = 314159;
    static int accept = 0;
    static int refuse = 0;
    static int rnd = (int) SEED;
    static int [ ] totPaid = new int [PKG_SIZE.length];    // Total paid by cars for the simulation.
    static int [ ] totIn = new int [PKG_SIZE.length];      // Total number of cars accepted to enter the parking.
    static int [ ] totRefused = new int [PKG_SIZE.length]; // Total number of cars not accepted to enter the parking.
    static int [ ] totHour = new int [PKG_SIZE.length]; 
    /**
     * main method
     * @param args
     */
    public static void main(String[] args) {
        initializeA(5, totHour);
        initializeA(5, totIn);
        initializeA(5, totPaid);
        initializeA(5, totRefused);
        int[ ] array50 = new int[50];
        int[ ] sum50 = new int[50];
        int[ ] array100 = new int[100];
        int[ ] array150 = new int[150];
        int[ ] array200 = new int[200];
        int[ ] array250 = new int[250];
        int[ ] sum100 = new int[100];
        int[ ] sum150 = new int[150];
        int[ ] sum200 = new int[200];
        int[ ] sum250 = new int[250];
        System.out.println("Result of simulation.");
        System.out.println("Duration for each parking size: 744 hours (31 Days and 0 hours)");
        System.out.println("            (1)            (2)            (3)            (4)            (5)            (6)");
        runSimulation(50, array50, sum50);
        runSimulation(100, array100, sum100);
        runSimulation(150, array150, sum150);
        runSimulation(200, array200, sum200);
        runSimulation(250, array250, sum250);
        System.out.println();
        System.out.println("	(1) : parking size (number of slots)");
        System.out.println("	(2) : total ($) paid during simulation.");
        System.out.println("	(3) : number of cars accepted to park during simulation.");
        System.out.println("	(4) : number of cars refused to park during simulation.");
        System.out.println("	(5) : total number of hours for all cars which parked.");
        System.out.println("	(6) : average number of hours that a car parked.");
        System.out.println();



    }

    /**
     * get random
     * @param rnd
     * @return random number
     */
    public static int getRandom(int rnd) {
        long multiplier = 16807;
        return (int) ((multiplier * rnd) % MODULUS);
    }
    /**
     * initalize array
     * @param size
     * @param array
     */
    public static void initializeA(int size, int [] array){
        for(int i =0; i< size; i++) {
            array[i] = 0;
        }
    }
    /**
     * update hours after each hour
     * @param size
     * @param array
     * @return totalhours
     */
    public static int updateHours(int size, int[] array){
        int totalHours = 0;
        for( int i =0 ; i<size; i++){
            if (array[i] != 0) {
                totalHours += 1;
                array[i] -= 1;
                
            }
        }
        return totalHours;
    }
    /**
     * get money and free space
     * @param size
     * @param array
     * @param sum
     * @return total 
     */

    public static int getMoney(int size, int [] array, int [] sum){
        int cost = 0;
        int total = 0;
        for (int i =0; i<size; i++){
            if (array[i]==0) { 
                if (sum[i]!= 0) {
                    if (sum[i] < 7){
                        cost = sum[i]*3;
                    }
                    else if(sum[i] >= 7 && sum[i] <31){
                        cost = 20 + (Math.max(sum[i]-24,0))*3;
                    }
                    else if(sum[i] >= 31 && sum [i] <55){
                        cost = 40 + (Math.max(sum[i]-48,0))*3;
                    }
                    else {
                        cost = 60;
                    }
                    total += cost;
                }
                
                sum[i] = 0;
            }
            

        }
        return total;
    }
    /**
     * add arrray depends on condition
     * @param size
     * @param array
     * @param sum
     * @param value
     */

    public static void addArray(int size, int[]array, int [] sum, int value){
        if (isFull(size, array)){
            refuse += 1;
        }
        else {
            accept += 1;
            for (int i = 0; i < size; i++){
                if(array[i] == 0){
                    array[i] = value;
                    sum[i] = value;
                    break;
                }
            }
        }
    }
    /**
     * find empty
     * @param size
     * @param array
     * @return empty slots
     */
    public static int findEmpty(int size, int[] array){
        int count = 0;
        for (int i =0; i<size; i++){
            if (array[i] == 0) {
                count += 1;
            }
        }
        return count;
    }
    /**
     * check whether its full
     * @param size
     * @param array
     * @return true or false
     */
    public static boolean isFull(int size, int [] array) {
        boolean full = true;
        for (int i =0; i< size; i++){
            if (array[i] == 0){
                full = false;
            }
        }
        return full;
    }
    /** run simulation for each park size */

    public static void runSimulation(int size, int [] array, int [] sum) {
        int totalCost = 0;
        refuse = 0;
        accept = 0;
        int totalHours= 0;
        double averagecost = 0;
        int cars = 0;
        initializeA(size, array);
        initializeA(size, sum);

        for (int i =0; i<744; i++){
            totalHours += updateHours(size, array);

            totalCost += getMoney(size, array, sum);
            if ((i%24) > 5 && (i%24)<18){
                rnd = getRandom(rnd);
                cars = (rnd%5) +5;
            }
            else if ((i% 24) >=18 && (i%24)< 21){
                rnd = getRandom(rnd);
                cars = (rnd%2) +1;
               
            }
            else {
                cars = 0;
            }
            int empty = findEmpty(size, array);
            if (cars > empty){
                refuse += (cars-empty);
                cars = empty;
            }
            
            for(int k= 0; k < cars; k++){
                rnd = getRandom(rnd);
                int hour = rnd%72+1;
                addArray(size, array, sum, hour);
            }
 

        }
        for (int m =0; m <size; m++){
            totalHours += array[m];
        }
        averagecost = (double)totalHours/accept;
        System.out.print("            ");
        System.out.printf("%3s", size);
        System.out.print("         ");
        System.out.printf("%,5d",totalCost);
        System.out.print("          ");
        System.out.printf("%,5d", accept);
        System.out.print("          ");
        System.out.printf("%,5d", refuse);
        System.out.print("        ");
        System.out.printf("%,7d", totalHours);
        System.out.print("          ");
        System.out.printf("%.2f", averagecost);
        System.out.println();
    }
    /**
     * simulate at one hour
     * @param ipk
     * @param iHour
     * @param parking
     * @param time
     * @param totPaid
     * @param totIn
     * @param totRefused
     * @param totHour
     */

    public static void simulateHour (int ipk, int iHour, int[ ] parking, int[ ] time, int[ ] totPaid, int[ ] totIn, int[ ] totRefused, int[ ] totHour) {
            int size = PKG_SIZE[ipk];
            totPaid[ipk] += getMoney(size, time, parking); 
            int cars = 0;
            refuse = 0;
            accept = 0;
            if ((iHour) > 5 && (iHour)<18){
                rnd = getRandom(rnd);
                cars = (rnd%5) +5;
            }
            else if (iHour >=18 && iHour< 21){
                rnd = getRandom(rnd);
                cars = (rnd%2) +1;
               
            }
            else {
                cars = 0;
            }
            int empty = findEmpty(size, time);
            if (cars > empty){
                refuse += (cars-empty);
                cars = empty;
            }
            accept += cars;
            
            for(int k= 0; k < cars; k++){
                rnd = getRandom(rnd);
                int hour = rnd%72+1;
                addArray(size, time, parking, hour);
            }

            totIn[ipk] += accept;
            totRefused[ipk] += refuse;
            totHour[ipk] += updateHours(size, time);
            
    }
}
