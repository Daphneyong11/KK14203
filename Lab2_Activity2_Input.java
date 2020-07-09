import java.util.Scanner;
public class Lab2_Activity2_Input{
    public static void main(String args[])
    throws java.io.IOException{
        char ch;
        Scanner scan = new Scanner(System.in);
        do{
            System.out.print("Input a key followed by ENTER: ");
            String input = scan.nextLine();
            //read string input
            ch = input.charAt(0);
            System.out.println(ch);
        } while(ch!='q');
    }
}