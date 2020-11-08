// Name:  Andrew Cao 
// VUnetID: caoa5
// Email: an.cao@vanderbilt.edu
// Class: CS 1101 - Vanderbilt University
// Section: 01 (MWF - Arena)
//
// Program description: This is the itemtopurchase class
// Date: 10/20/2020
// Honor statement: I have neither given nor received any unauthorized aid on this assignment. 

package ShoppingCart;

public class ItemToPurchase {
    String itemName ="";
    int itemPrice = 0;
    int quantity = 0;
    int total;
    /**
     * Constructor method
     * @param name
     * @param price
     * @param quantity
     */

    /**
     * set the name
     * @param name
     */
    public void setName(String name){
        this.itemName = name;
    }
    /**
     * set price
     * @param price
     */
    public void setPrice(int price){
        this.itemPrice = price;
    }
    /**
     * set quantity
     * @param quantity
     */
    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
    /**
     * get name
     * @return name
     */

    public String getName() {
        return this.itemName;
    }
    /**
     * get price
     * @return price
     */
    public int getPrice(){
        return this.itemPrice;
    }
    /**
     * get quantity
     * @return quantity
     */
    public int getQuantity(){
        return this.quantity;
    }

    /**
     * print the total cost
     */
    public void printCost(){
        this.total = this.itemPrice*this.quantity;
        System.out.println(this.itemName+" "+quantity +" @ $"+this.itemPrice  +" = "+"$"+total);

    }
}
