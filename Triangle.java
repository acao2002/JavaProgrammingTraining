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


public class Triangle {
    double base;
    double height;
    
    public Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }
    
    public double getArea() {
       double area = 0.5 * base * height;
       return area;
    }
    
    public void printInfo() {
       System.out.printf("Base: %.2f\n", base);
       System.out.printf("Height: %.2f\n", height);
       System.out.printf("Area: %.2f\n", getArea());
    }
 }