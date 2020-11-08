// Name:  Andrew Cao 
// VUnetID: caoa5
// Email: an.cao@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 01 (MWF - Arena)
//
// Program description: This program output the total price of a shopping cart
// Date: 10/20/2020
// Honor statement: I have neither given nor received any unauthorized aid on this assignment. 

package ShoppingCart;
import java.util.*;

public class ShoppingCartPrinter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Item 1");
        System.out.println("Enter the item name:");
        String name1 = sc.nextLine();
        System.out.println("Enter the item price:");
        int price1 = sc.nextInt();
        System.out.println("Enter the item quantity:");
        int quantity1 = sc.nextInt();
        sc.nextLine();
        System.out.println();
        System.out.println("Item 2");
        System.out.println("Enter the item name:");
        String name2 = sc.nextLine();
        System.out.println("Enter the item price:");
        int price2 = sc.nextInt();
        System.out.println("Enter the item quantity:");
        int quantity2 = sc.nextInt();

        System.out.println();
        System.out.println("TOTAL COST");
        ItemToPurchase item1 = new ItemToPurchase();
        item1.setName(name1);
        item1.setPrice(price1);
        item1.setQuantity(quantity1);
        ItemToPurchase item2 = new ItemToPurchase();
        item2.setName(name2);
        item2.setPrice(price2);
        item2.setQuantity(quantity2);

        item1.printCost();
        item2.printCost();
        System.out.println(); 
        int total = item1.total + item2.total;
        System.out.println("Total: $"+ total);
    }
}
