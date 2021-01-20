/* Introduction to Computer Science II */
/* Tutorial #1                         */

import java.util.Scanner; // used for keyboard input

public class PrintQs{

 /* the main method is the "program"              */
 /* this is what is executed when we run the code */
 public static void main(String[] args){
  
  Scanner keyboard = new Scanner(System.in);
  String input = null;
  int size = 0;

  System.out.print("enter a number (integer) : ");
  if( keyboard.hasNextInt() == true){
    // input was an integer so proceed
    size = keyboard.nextInt();
  }else{
    // input was not an integer so store it in a string variable
    input = keyboard.next();
    System.out.println("you entered  \"" + input + "\", which is not an integer. Try again.");
    return; // exit program
  }

  for (int j = 0; j < size; j++){
    for (int i = 0; i < size; i++){
      System.out.print("Q");
    }
    System.out.println("");
  }
  System.out.print("\n");

  for (int k = 1; k < size + 1; k++){
    for (int j = 0; j < k; j++){
      System.out.print("Q");
    }
    System.out.println("");
  }
  System.out.print("\n");

  for (int k = size; k > 0; k--){
    for (int j = 0; j < k; j++){
      System.out.print("Q");
    }
    System.out.println("");
  }
  System.out.print("\n");

  for (int j = 0; j < size; j++){
    for (int i = 0; i < size; i++){
      if (j > i){
        System.out.print(" ");
      }else{
        System.out.print("Q");
      }
    }
    System.out.println("");
  }
  System.out.print("\n");

  for (int j = size; j > 0; j--){
    for (int i = 0; i < size; i++){
      if (j-1 > i){
        System.out.print(" ");
      }else{
        System.out.print("Q");
      }
    }
    System.out.println("");
  }
  System.out.print("\n");
  
  //
  // proceed to draw the images as requested in the tutorial now...
  //
  
  
 }
 
}