import java.util.Scanner;
import java.text.DecimalFormat;
public class BMI
{
    public static void main(String[]args){
    Scanner sc=new Scanner(System.in);
    DecimalFormat df = new DecimalFormat("#.##");
    double w, h, bmi;
    System.out.print("Enter your weight (kg): ");
    w=sc.nextDouble();
    System.out.print("Enter your height  (m): ");
    h=sc.nextDouble();
    bmi=w/(h*h);
    System.out.print("Your BMI is "+df.format(bmi)+" which is ");
    if(bmi<16){
        System.out.print("Severly Underweight.");
    }
    else if(bmi<=18.5){
        System.out.print("Underweight.");
    }
    else if(bmi<=25){
        System.out.print("Normal Weight.");
    }
    else if(bmi<=30){
        System.out.print("Overweight.");
    }
    else if(bmi<=30){
        System.out.print("Moderately Obese.");
    }
    else{
        System.out.print("Severely Obese.");
    }
}
}
