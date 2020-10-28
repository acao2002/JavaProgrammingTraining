// Name:  Andrew Cao 
// VUnetID: caoa5
// Email: an.cao@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 01 (MWF - Arena)
//
// Program description: This program plays who am I game
// Date: 10/26/2020
// Honor statement: I have neither given nor received any unauthorized aid on this assignment. 


import java.util.Scanner;

public class WhoAmI {

    static final int T_MAX = 100;

    /**
     * main program
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String []qt = new String[100];
        populateQuestion(qt);
        askQuestion(sc, qt);
        boolean game = true;
        while (game){
            System.out.print("Do you want to play again ? ");
            char ans = Character.toLowerCase(sc.next().charAt(0));
            if(Character.compare(ans,'y') == 0) { 

                askQuestion(sc, qt);
            }
            else if((Character.compare(ans,'n') == 0)) {
                game = false;
            }

        }
       
    }

    /**void askQuestion (Scanner sc, String [] qt) 
     * ask question depending on user's input
     * @param sc
     * @param qt
     */

    public static void askQuestion (Scanner sc, String [] qt) {
        System.out.println(qt[0]);
        int i = 1;
        while (i < 100) {
            char ans = (readYN(sc, qt[i]));
            if(Character.compare(ans,'y') == 0) {
                if (!qt[i].contains(" ?")){
                    System.out.println("Person found !");
                    i = 1000;
                    break;
                }
                i = i*2;
            }
            else
            if(Character.compare(ans,'n') == 0) {
                if (!qt[i].contains(" ?")){
                    System.out.print("Who are you thinking of ? ");
                    String name = sc.nextLine();
                    name =sc.nextLine();
                    System.out.print("What would be a discriminating question to ask such that the answer is: "+"\n"+"\""+ name+"\" ? ");
                    updateQuestion(sc, qt, i, name);
                    break;
                }
                i = i*2 + 1;
            }
            if (i>100) {
                break;
            }
        }
       


    }
    /**static char readYN (Scanner sc, String question)
     * read user's respond and print question
     * @param sc
     * @param question
     * @return response(y or n)
     */
    public static char readYN (Scanner sc, String question) {
        if (question.contains(" ?")){
            System.out.print(question);
        }
        else{
            question ="I suggest: "+ question+"\n"+"Did I guess correctly ? ";
            System.out.print(question);
        }
        char input = 'k';
        while (input != 'n' && input!= 'y') {
            char in = sc.next().charAt(0);
            in = Character.toLowerCase(in);
            if (Character.compare(in, 'n') == 0 || Character.compare(in, 'y') == 0){
                input = in;
            }
            else {
                System.out.println("Please enter Y or N");
                System.out.print(question);
            }
        }
        return input;
    }
    /**static void updateQuestion (Scanner sc, String [] qt, int lastIndex, String newName)
     * update question
     * @param sc
     * @param qt
     * @param lastIndex
     * @param newName
     */

    public static void updateQuestion (Scanner sc, String [] qt, int lastIndex, String newName){
        String question = sc.nextLine();
        if (!question.contains(" ?")){
            question+=" ? ";
        }
        System.out.print("Ok. At the question: "+ "\" "+ question +"\""+"\n"+"Would you reply Y or N to get the answer "+ "\""+ newName+"\" ? ");
        char answer = sc.next().charAt(0);
        if (Character.compare(answer, 'y') == 0) {
            qt[lastIndex] = question;
            qt[lastIndex*2] = newName;
            qt[lastIndex*2+1] = qt[lastIndex];
        }
        else {
            qt[lastIndex] = question;
            qt[lastIndex*2] = qt[lastIndex];
            qt[lastIndex*2+1] = newName;
        }

    }

        
    /**
     * initialize array
     * @param qt
     */
    public static void populateQuestion (String [] qt) {
        for (int i = 0; i < T_MAX; i++){
            qt [i] = "";
        }
        qt[0]= "\n*** WhoAmI guessing game. ***\n";
        qt[0] += "Think of a person and answer questions by Y or N.";
        qt[1]= "Is the person alive ? ";
        qt[2]= "Queen Elizabeth of England.";
        qt[3]= "Adam";
    }

}