
/**
 * Program to Manage Shopping Cart for user.
 * Adds,deletes items from the cart.Shows the contents of cart.Generates bill.
 * Assumption of the stock is taken as:
 * Shoe priced at 1000(INR)
 * Belt priced at 500(INR)
 * Tie  priced at 650(INR)
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
    public double price;                                           //price of each item
    public String name;                                            //name of each item
    Item(){};
    Item(String name, double price){                               //Parameterized constructor for initialization
    this.price = price;
    this.name = name;
    }
}

/** This class is for the cart*/
class ShoppingCart{
    List<Item> cart = new ArrayList<>();                           //Array list named cart to hold items
    
    //Method to add items in the cart
    //Input is the item to be added and its Quantity
    void  addToCart(Item item , int quantity){                     
        for(int i =1; i<= quantity; i++){
            cart.add(item);                                        //Predefined Method to add elements in array list 
        }  
    System.out.println("Item Added");
    }
    
     //Method to delete items from the cart 
     //Input is the item to be deleted
     void deleteFromCart(Item item){
         int flag = 0;                                              //To identify whether item to be deleted exists 
         for(Item i:cart){
             if(i == item){                                          //To find the required item in cart list
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
         List<Item> cartDistinct = (List<Item>) cart.stream().distinct().collect(Collectors.toList()); //Distinct items list
         System.out.println("Name\tPrice\t\tQuantity");
         for(Item i : cartDistinct){
        	  int temp=Collections.frequency(cart,i);
             System.out.println(i.name +"\t"+ (i.price)*temp +"INR" +"\t"+ temp);      //counts duplicates of a item
         }
     } 
     
     //Method for billing
     double billing(){
         double sum = 0;                                               
         for(Item i:cart){
             sum = sum + i.price;
         }
         return sum;
     }
     
     public static void main(String args[]){
         ShoppingCart s = new ShoppingCart();
         int quantity;                                                  //Quantity of each item to be added
         int number;                                                    //Serial number of items
         char addordelete;                                              
         char yesorno;                                                  //Whether to repeat the loop
         Item choice = new Item();                                      
         Scanner sc = new Scanner(System.in);

         Item item1,item2,item3;
         item1 = new Item("Shoe",1000);
         item2 = new Item("Belt",500);
         item3 = new Item("Tie",650);

         System.out.println("WELCOME");
         System.out.println(" \nThe List of Items Available : ");         //The list of available stock
         System.out.println("Serial Number\t\tName\tPrice");
         System.out.println("\t1\t\tShoe\t1000");
         System.out.println("\t2\t\tBelt\t500");
         System.out.println("\t3\t\tTie\t650");

         do{
	        System.out.println("\n To Add an item to your cart , Enter 'A' \n To Delete an item , Enter 'D' "
	        		           + "\n To view the cart , Enter 'V'  \n For Billing , Enter 'B'");
	        addordelete= sc.next().charAt(0);
	        if(addordelete != 'A' && addordelete != 'a' && addordelete != 'v' && addordelete != 'V'
	        && addordelete != 'd' && addordelete != 'D' && addordelete != 'b'&& addordelete != 'B' ){
                System.out.println("WRONG !Please Enter correctly");
                break;
	        }
	        if(addordelete == 'd' || addordelete == 'D' || addordelete == 'a' || addordelete == 'A'){
	        	if(s.cart.isEmpty() && (addordelete == 'd' || addordelete == 'D') ){
	        		System.out.println("Cart is empty!");
	        		break;
	        	}
                System.out.println("Please Enter the serial number of the item");
                try{
                	number = sc.nextInt();
                    if(number == 1){                                               //Converts the number entered to corresponding item
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
            switch(addordelete){
                case 'A' :
                case 'a' : System.out.println("\nEnter the Quantity");
                           try{
                        	   quantity = sc.nextInt();                                        //Quantity should be positive number
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
                case 'D' :
                case 'd' :s.deleteFromCart(choice);
                          break;
                case 'V' :
                case 'v' :System.out.println("\nItems in the cart :");
                          s.showCart();
                          break;
                case 'B' :
                case 'b' : System.out.println("\nTotal Bill : " + s.billing() +"INR");
                           break;
         }
            
            System.out.println("\nDo You Want Anything Else?(Y/N)");                                   //prompt to repeat
            yesorno= sc.next().charAt(0);
            }while( yesorno == 'Y' || yesorno == 'y');
            System.out.println("\nTHANKYOU FOR SHOPPING");
            sc.close();
          }
}
