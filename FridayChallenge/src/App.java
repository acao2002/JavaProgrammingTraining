import java.util.Scanner;
// Input one positive number < 1000 and calculate the range of values of its digits.
// That is defined as 1 more than the difference between the largest digit value and the smallest digit value.

public class App {
    public static void main(String[] args) {
        int uTest = unitTest();
        if (uTest != 0) {
            // Display error number and exit
            System.out.println("Error " + uTest + " in testing digitRange");
            System.exit(0);
        };

        Scanner scn = new Scanner(System.in);
        System.out.print("Enter a positive integer smaller than 1000 ? ");
        int nb = scn.nextInt();
        if ( (nb < 0) || (nb > 1000) ) {
            System.out.println(nb + " is not a positive integer smaller than 1000");
            // We exit right away
            System.exit(0);
        }
        System.out.println("The range of values for " + nb + " is " + digitRange(nb));
    }

    // Calculate digitRange for number nb (in [0..999]
    public static int digitRange (int nb) {
        int d1 = nb % 10;
        int d2 = (nb-d1)%100 /10;
        int d3 = (nb - d1 - d2*10)/100 ;
        return (Math.max(Math.max(d1,d2),d3)) - (Math.min(Math.min(d1,d2),d3));      
   }

    public static int unitTest(){
       return 0; 
    }
}
 