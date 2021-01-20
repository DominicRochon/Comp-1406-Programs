/* Introduction to Computer Science II */
/* Tutorial 1                          */

import java.util.Scanner;

public class Babylonian{

    public static double babylonian(double N, double epsilon){
        double sqrt = -1.0;
        double m1;
        
        //
        // insert your code here
        m1 = 0.5*N;
        sqrt = 0.5*(m1+N/m1);

        while (Math.abs(m1 - sqrt) >= epsilon){
            m1 = sqrt;
            sqrt = 0.5*(m1+N/m1);

        }
        //
        
        return sqrt;

    }

    public static void main(String[] args){
        Scanner keyboard = new Scanner(System.in);
        double epsilon = 0.01;
        double sqrt_n1;
        int inputN;
        String inputS;

        boolean end = false;

        while (!end){
            System.out.println("Enter a positive number or the word 'End': ");
            if( keyboard.hasNextInt() == true){
                inputN = keyboard.nextInt();
                if (inputN > 0){
                    end = true;
                    double babylonian_n1 = babylonian(inputN,epsilon);
                    sqrt_n1 = Math.sqrt(inputN);
                    System.out.println("Babylonian Square Root Computation");
                    System.out.println("            n = " + inputN);
                    System.out.println(" Math.sqrt(n) = " + sqrt_n1);
                    System.out.println("babylonian(n) = " + babylonian_n1);
                    System.out.println(" |difference| = " + Math.abs(sqrt_n1-babylonian_n1));
                }
            }else{
                inputS = keyboard.nextLine();
                if (inputS.equals("End")){
                    end = true;
                }
            }
        }
    }

}