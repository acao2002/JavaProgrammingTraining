
import java.util.*;
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        System.out.print(BiggestDifference(input, sc));
        
        
    }
    public static int BiggestDifference(int input, Scanner sc) {
        int maxdiff = 0;
        if (input < 2) {
            maxdiff = -1;
        }
        else {
            int k = sc.nextInt();
        
            for(int i = 1; i< input; i++) {
                int b = sc.nextInt();
                if (Math.abs(b - k) > maxdiff) {
                    maxdiff = Math.abs(b-k);

                }
                
                k = b;
            }
        }
        return maxdiff;
     }
}

