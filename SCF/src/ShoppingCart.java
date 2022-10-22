
/**
 * Program to Manage Shopping Cart for user.
 * Adds,deletes items from the cart.Shows the contents of cart.Generates bill.
 * Assumption of the stock is taken as:
 * Shoe priced at 1000(INR)
 * Belt priced at 500(INR)
 * Tie  priced at 650(INR)
 * Bag  priced at 1250(INR)
 * File priced at   50(INR)
 * Quantity of each item is assumed to be Unlimited.
 */


/** Package for the ShoppingCart class */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/** This class is for the items in the stock */
class Item{ 
	//price of item
    public double price;
    //name of item
    public String name;  
    //Serial number of item
    public int  serialNumber ;
    Item(){};
    Item(int serialNumber , String name, double price){                               
    this.price = price;
    this.name = name;
    this.serialNumber = serialNumber;
    }
}

/** This class is for the cart*/
class ShoppingCart{
    List<Item> cart = new ArrayList<>();                           
    
    //Method to add items in the cart
    //@param is the item to be added and its Quantity
    void  addToCart(Item item , int quantity){                     
        for(int i =1; i<= quantity; i++){
            cart.add(item);                                         
        }  
    System.out.println("Item Added");
    }
    
     //Method to delete items from the cart 
     //@param is the item to be deleted
     void deleteFromCart(Item item){
         int flag = 0;                                               
         for(Item i:cart){
             if(i == item){                                          
                 flag = 1;
                 cart.remove(i);
                 System.out.println("Cart Updated!");
                 break;
             }
         }
         if(flag == 0){
             System.out.println("The Item doesn't exist in the cart");
         }
      }
     
     //Method to show the contents of cart
     void showCart(){
         List<Item> cartDistinct = (List<Item>) cart.stream().distinct().collect(Collectors.toList()); 
         System.out.println("Name\tPrice\t\tQuantity");
         for(Item i : cartDistinct){
        	  int temp=Collections.frequency(cart,i);
             System.out.println(i.name +"\t"+ (i.price)*temp +"INR" +"\t"+ temp);      
         }
     } 
     
     //Method for billing
     //returns the total price of the items in the cart
     double billing(){
         double sum = 0;                                               
         for(Item i:cart){
             sum = sum + i.price;
         }
         return sum;
     }
     
     public static void main(String args[]){
         ShoppingCart s = new ShoppingCart();
         int quantity;                                                  
         int number;                                                    
         String addOrDelete;  
         String lower;
         int yesOrNo;                                                  
         Item choice = new Item();                                      
         Scanner sc = new Scanner(System.in);
         Scanner sc1 = new Scanner(System.in);

         Item item1 = new Item(1,"Bag",1200);
         Item item2 = new Item(2,"Belt",500);
         Item item3 = new Item(3,"Tie",650);
         Item item4 = new Item(4,"Shoe",1050);
         Item item5 = new Item(5,"File",50);

         System.out.println("WELCOME");
         System.out.println(" \nThe List of Items Available : ");         
         System.out.println("Serial Number\t\tName\tPrice");
         System.out.println("\t"+item1.serialNumber+"\t\t"+item1.name +"\t" + item1.price);
         System.out.println("\t"+item2.serialNumber+"\t\t"+item2.name +"\t" + item2.price);
         System.out.println("\t"+item3.serialNumber+"\t\t"+item3.name +"\t" + item3.price);
         System.out.println("\t"+item4.serialNumber+"\t\t"+item4.name +"\t" + item4.price);
         System.out.println("\t"+item5.serialNumber+"\t\t"+item5.name +"\t" + item5.price);
         
         do{
	            System.out.println("\n To Add an item to your cart , Enter 'A' \n To Delete an item , Enter 'D' "
	        		           + "\n To view the cart , Enter 'V'  \n For Billing , Enter 'B'");
	            addOrDelete= sc.nextLine();
	            lower = addOrDelete.toLowerCase();
	            if(!"a".equals(lower) && !"d".equals(lower) && !"v".equals(lower) && !"b".equals(lower)){
                    System.out.println("WRONG !Please Enter correctly");
                    break;
	            }
	            if("a".equals(lower) || "d".equals(lower)){
	        	    if(s.cart.isEmpty() && "d".equals(lower)){
	        		    System.out.println("Cart is empty!");
	        		    break;
	        	     }
                    System.out.println("Please Enter the serial number of the item");
                    try{
                	    number = sc1.nextInt();
                        if(number == 1){                                              
                           choice = item1;
                        }else if(number == 2){
                           choice = item2;
                        }else if(number == 3){
                           choice = item3;
                        }else{
                           System.out.println("WRONG!Please enter correct serial number");
                           break;
                        }
	                }
                    catch(Exception e){
             	       System.out.println("Please Enter a valid number");
             	       break;
                    }
	            }
                switch(lower){
                    case "a" : System.out.println("\nEnter the Quantity");
                               try{
                        	       quantity = sc1.nextInt();                                        
                        	       if(quantity > 0){
                        	           s.addToCart(choice,quantity);
                                       break;
                        	       }else{
                        		       throw new Exception();
                        	       }
                                }
                                catch(Exception e){
                        	       System.out.println("Please Enter a valid number");
                        	       break;
                                }
                    case "d" :s.deleteFromCart(choice);
                              break;
                    case "v" :System.out.println("\nItems in the cart :");
                              s.showCart();
                              break;
                    case "b" : System.out.println("\nTotal Bill : " + s.billing() +"INR");
                               break;
                 }
            
                 System.out.println("\nDo You Want Anything Else?(1/0)");                                
                 yesOrNo= sc1.nextInt();
            }while( yesOrNo == 1);
         
            System.out.println("\nTHANKYOU FOR SHOPPING");
            sc.close();
            sc1.close();
    }
  }
