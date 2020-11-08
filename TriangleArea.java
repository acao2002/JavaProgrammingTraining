// Name:  Andrew Cao 
// VUnetID: caoa5
// Email: an.cao@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 01 (MWF - Arena)
//
// Program description: This program compares Triangles
// Date: 11/9/2020
// Honor statement: I have neither given nor received any unauthorized aid on this assignment. 

package Triangle;
import Triangle.Triangle;
import java.util.*;

public class TriangleArea {
    /**
     * Compare triangles and print statements
     * @param args
     */
    public static void main( String[] args) {
        Scanner sc = new Scanner(System.in);
        double b1 = sc.nextDouble();
        double h1 = sc.nextDouble();
        double b2 = sc.nextDouble();
        double h2 = sc.nextDouble();
        Triangle t1 = new Triangle(b1, h1);
        Triangle t2 = new Triangle(b2, h2);
        
        System.out.println("Triangle with larger area:");
        if (t1.getArea()< t2.getArea()){
            t2.printInfo();
        }
        else {
            t1.printInfo();
        }
    
    }

}
