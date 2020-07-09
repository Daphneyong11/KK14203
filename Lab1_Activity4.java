import java.text.DecimalFormat; //required for decimal formatter
public class Lab1_Activity4{
    public static void main(String args[]){
        System.out.printf("%s%n%s%n", "Hello world", "Welcome to Java Programming!");
        double num1 = 2.5432;
        int num2 = 4;
        //formatting decimal using printf
        System.out.printf("Sum of %f and %d is :%.2f%n", num1, num2, num1+num2);
        //formatting decimal using DecimalFormat
        DecimalFormat df = new DecimalFormat("#.##");
        //decimal formatter to 2 places
        System.out.println("Division of num1 and num2 is: "+ df.format(num1/num2)); 
        //Q2
        double x, y=150.50;
        int temp=5;
        x = y / 3 - 34 * temp + 120;
        System.out.println("x is "+ df.format(x));
        //Q3 truth table of P and Q
        boolean P,Q;
        P=true; Q=true;
        System.out.printf("p\tq\tTruth\n========================\n");
        System.out.print("true    "+"true    ");
        System.out.print(P&&Q);
        Q=false;
        System.out.print("\ntrue    "+"false   ");
        System.out.print(P&&Q);
        P=false;Q=true;
        System.out.print("\nfalse   "+"true    ");
        System.out.print(P&&Q);
        Q=false;
        System.out.print("\nfalse   "+"false   ");
        System.out.print(P&&Q);
    }
}