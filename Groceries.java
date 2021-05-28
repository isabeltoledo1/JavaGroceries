import java.util.*;
import java.io.*;
 
class Groceries{  
  public static void main(String []args){
     //For user input output
     Scanner scanner = new Scanner(System.in);
     //To store the shopping list
     ArrayList<String>groceries = new ArrayList<>();
     String fileName = "groceries.txt";
    
     //Load Shopping List from file
      try{
        //Use the Scanner and File to open the file
        File groceriesFile = new File(fileName);
        if(groceriesFile.exists()){
           Scanner fileIn = new Scanner(groceriesFile);
           //Keep reading so long as there are more items in the file
           while(fileIn.hasNext()){
              //Read an a word from the file
              groceries.add(fileIn.nextLine());
           }
           fileIn.close();
         }
         else{
           //Creates empty file
           groceriesFile.createNewFile();
         }
     }
     //If the file is not found, display the error message
     catch(FileNotFoundException e){
        System.out.println("Error: " + e.getMessage());
     }
     //If any other error occurred, display the message
     catch(Exception e){
        System.out.println("Error: " + e.getMessage());
     }
 
     int choice;
     do{
        System.out.println(groceries);
        System.out.println("1. Add Item\n2. Remove Item\n3. Quit");
        //Make sure the user enters a 1 or 2
        try{
           String str = scanner.nextLine();
           choice = Integer.parseInt(str);
        }
        catch(Exception e){
           System.out.println("Your selection must be a number: " + e);
           choice = 3;
        }
       
        switch(choice){
         //Allows the user to enter information to the list. Adds it to the ArrayList
           case 1:
              System.out.println("Add item: " );
              String toAdd = scanner.nextLine();
              groceries.add(toAdd);
              break;
           //Removes an item from the ArrayList
           case 2:
              System.out.println("Remove item: " );
              String toRemove = scanner.nextLine();
              groceries.remove(toRemove);
              break;
        }
     }
     while(choice < 3);  
     //Saves the ArrayList to the file
     try{
        //Creates a PrintWriter to write to the file
        PrintWriter fileOut = new PrintWriter(new FileWriter(fileName));
        //Iterates through the file
        for(String g: groceries){
           //Writes each item to the file
           fileOut.println(g);
        }
        //Closes the file
        fileOut.close();
     }
     catch(IOException e){
        //Prints error message
        System.out.println("Error: " + e.getMessage());
     }
 
  }//End Main
}//End GroceryListDriver

	 





