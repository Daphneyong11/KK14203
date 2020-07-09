// This is one line comment
/* This is block comment
 * File: Errors.java
 * Purpose: A program with lots of syntax errors
Correct all of the errors (STUDY the program carefully!!)
*/
//line 9 below: to import java packageto read input from keyboard
import java.util.Scanner;
public class Lab1_Activity3{
    public static void main (String[] args){
        String Name;
        int number;
        int numSq;
        Scanner scan = new Scanner(System.in);
        System.out.print ("Enter your name, please: ");
        Name = scan.next();
        System.out.print ("What is your favourite number?");
        number = scan.nextInt();
        numSq = number * number;
        System.out.println (Name+", the square of your number is "+numSq);
    } 
}