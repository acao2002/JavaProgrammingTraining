import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Armstrong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename = "";
        boolean file = false; 
        while (!file) {
            String path = getInputFile(sc);
            filename = path +"data.txt";
            File myFile = new File(filename);
            if (!myFile.exists()) {
                System.out.println("Cannot find file at that location. Please try again.");
            }
            else {
                file = true;
                System.out.println("data.txt successfully found.");
                System.out.println();
            }
        }
        int armNum = 0; 
        int nArmNum = 0; 
        int badToken = 0; 
        File myFile = new File(filename);
        try {
             System.out.println("Scanning data.txt...");
             Scanner fr = new Scanner(myFile);
             while (fr.hasNext()) {

                if (fr.hasNextInt()){
                    int token = fr.nextInt();
                    if (isArmstrongNumber(token)) {
                        System.out.println("Number : " + token + " is an Armstrong number");
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
     
 
    public static String getInputFile(Scanner sc) {
        System.out.print("Enter path for file \"data.txt\"? ");
        return sc.nextLine();
    }
    public static boolean isArmstrongNumber(int number) {
        int d1 = number%100; 
        int d2 = (number-d1*100)%10;
        int d3 = number - d1*100-d2*10;
        return(d1*d1*d1 + d2*d2*d2 + d3*d3*d3 == number);

    }
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