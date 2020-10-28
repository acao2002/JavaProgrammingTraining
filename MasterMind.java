// Name:  Andrew Cao 
// VUnetID: caoa5
// Email: an.cao@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 01 (MWF - Arena)
//
// Program description: This program plays mastermind
// Date: 10/22/2020
// Honor statement: I have neither given nor received any unauthorized aid on this assignment. 

import java.util.*;

public class MasterMind {
    /**
     * Main method
     * @param args
     */
    public static void main(String[] args) { 
        Random color = new Random();
        Scanner sc = new Scanner(System.in);
        int roundplay = 1;
        int win = 0;
    
        displayInstructions();

        String colors = (buildMasterCode(color));
        if(playOneRound(sc, colors)) {
            win+=1;
        }

        boolean game = true;
        while (game){
            System.out.println("Play again (Y/N)?");
            if (Character.compare(getUserChoice(sc), 'y') == 0) {
                colors = buildMasterCode(color);
                if(playOneRound(sc, colors)) {
                    win+=1;
                }
 
                roundplay += 1;

            }
            else {
                game = false;
                displayStats(roundplay, win);


            }
        }
        
    }

    /**String buildMasterCode(Random r) 
     * build the string of colors
     * 
     * @param r
     * @return string of colors
     */
    public static String buildMasterCode(Random r) {
        String output = "";
        for (int i = 0; i < 4; i ++) {
            output += String.valueOf(getRandomColor(r));
        }
        if(output.equals("YYYY")) {
            output = buildMasterCode(r);
        }
        System.out.println("Ok, I've selected my secret code. Try and guess it.");
        System.out.println();
        return output;
    }
    
    /**
     * display Instructions
     */
    public static void displayInstructions() {

        System.out.println("WELCOME TO MASTERMIND");
        System.out.println();
        System.out.println("How to Play:");
        System.out.println("1. I will pick a 4 character color code out of the following colors: Yellow, Blue, Red, Green.");
        System.out.println("2. You try to guess the code using only the first letter of any color. Example if you type YGBR that means you guess Yellow, Green, Blue, Red.");
        System.out.println("3. I will tell you if you guessed any colors correct and whether or not you guess them in the right order.");
        System.out.println();
        System.out.println("LET'S PLAY!");
        System.out.println();

    }

    /**
     * char getRandomColor(Random input) - get random color from the random object
     * @param input
     * @return random color
     */
    
    public static char getRandomColor(Random input) {
        int random = input.nextInt(4);
        char output = 'k';
        switch (random){ 
            case 0:
                output = 'R';
                break;
            case 1:
                output = 'G';
                break;
            case 2:
                output = 'B';
                break;
            case 3:
                output = 'Y';
                break;
            
        }
        return output;
    }
    /**boolean isValidColor(char k) 
     * 
     * @param k
     * @return whether it is a valid color 
     */
    public static boolean isValidColor(char k) {
        return (Character.toLowerCase(k) == 'r' || Character.toLowerCase(k) == 'g' || Character.toLowerCase(k) == 'b' || Character.toLowerCase(k) == 'y'); 
    }
    
    public static boolean isValidGuess(String guess) {
        boolean output = true;
        if(guess.length() == 4) {
            for( int i =0; i< 4; i++) {
                if(!isValidColor(guess.charAt(i))) {
                    output = false;
                    break;
                }
            }
        }
        else {
            output = false;
        }
        return output;
    }
    /** String getValidGuess(Scanner sc, int gnum) 
     * get valid guess from user
     * @param sc
     * @param gnum
     * @return valid guess
     */
    public static String getValidGuess(Scanner sc, int gnum) {
        String output = "";
        System.out.print("Enter guess #" + gnum + "  (e.g., YBRG ): ");
        
        String input = sc.next();
        if (isValidGuess(input)) {
            output = input;
        }
        else {
            System.out.println("Please enter a valid guess of correct length and colors");
            System.out.println();
            output = getValidGuess(sc, gnum);
        }
        return output.toUpperCase();
    }

    /**countCorrectColors(String ori, String guess)
     *  count correct colors 
     * @param ori
     * @param guess
     * @return correct colors
     */
    public static int countCorrectColors(String ori, String guess) {
        int count = 0;
        for(int i = 0; i<4; i++) {
            for (int k =0; k <4; k++) {
                if (Character.compare(ori.charAt(i), guess.charAt(k)) == 0) {
                    count += 1; 
                    ori = ori.replace(ori.charAt(i), 't');
                    guess = guess.replace(guess.charAt(k), 'm');
                }
            }
        }
        return count;
    }
    /**int countCorrectPositions(String ori, String guess)
     * Count correc positions
     * @param ori
     * @param guess
     * @return correct positions
     */
    public static int countCorrectPositions(String ori, String guess) {
        int count = 0; 
        for (int i = 0; i<4; i ++) {
            if (Character.compare(ori.charAt(i), guess.charAt(i)) == 0) {
                count += 1; 
            }
        }
        return count; 
    } 

    /**
     * boolean checkGuess(String ori, String guess) 
     * @param ori
     * @param guess
     * @return whether guess is right or wrong
     */
    public static boolean checkGuess(String ori, String guess) {
        return(ori.equals(guess));
    }
    /**boolean playOneRound(Scanner sc, String ori)
     * Run a round of the game
     * @param sc
     * @param ori
     * @return whether win or not
     */
    public static boolean playOneRound(Scanner sc, String ori) {
        boolean output = false;
        for (int k = 1; k <7; k ++) {
            String guess = getValidGuess(sc, k);
            if (checkGuess(ori, guess)) {
                output = true;
                break;
            }
            else {
                System.out.println("You have " + countCorrectColors(ori, guess)+ " colors correct");
                System.out.println(countCorrectPositions(ori, guess) +" are in correct position");
                System.out.println();
                
            }
        }
        if(output){
            System.out.println("That's correct! You win this round. Bet you can't do it again!");
        }
        else{
            System.out.println("No more guesses. Sorry you lose. My sequence was "+ori);
        }

        return output;
    }
    /**
     * get user choice whether to play or not
     * @param sc
     * @return whether to play again or no
     */
    public static char getUserChoice(Scanner sc) {
        char output = 'k';
        char input = sc.next().charAt(0); 
        if (Character.compare(Character.toLowerCase(input), 'y') != 0 && Character.compare(Character.toLowerCase(input), 'n') != 0) {
            System.out.println("Please enter a valid response (Y/N):");
            output = getUserChoice(sc);
        }
        else {
            output = input;
        }
        System.out.println();
        return output;
        
    }
    /**
     * display stats
     * @param played
     * @param won
     */
    public static void displayStats(int played, int won) {
        int lost = played -won;
        float ratio = (float) won/played;
        System.out.println();
        System.out.println("YOUR FINAL STATS:");
        System.out.println("Rounds Played: "+played);
        System.out.println("Won: " + won + "  Lost: " + lost);
        System.out.print("Winning Pct: ");
        System.out.printf("%.2f", ratio );
        System.out.println("%");
    }
}
