public class Lab2_Activity1_Input{
    public static void main(String args[]) 
    throws java.io.IOException{
        char ch;
        do{
            System.out.print("Input a key followed by ENTER: ");
            ch = (char) System.in.read();
            System.out.println();
        } while(ch!='q');}
}