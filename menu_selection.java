import java.util.Scanner;
public class menu_selection
{
    public static void main(String[]args)
    {
        Scanner sc= new Scanner(System.in);
        char ch;
        int num;
        double price;
        System.out.println("Menu: ");
        System.out.println("1. Nasi Lemak [RM2.00]");
        System.out.println("2. Teh Tarik  [RM1.50]");
        System.out.println("3. Roti       [RM1.00]");
        System.out.println();
        System.out.println("Place order or type 'q' to exit.");
        do{
            System.out.print("Add menu: ");
            ch = sc. next(). charAt(0);
            switch(Character. getNumericValue(ch)){
                case 1:
                System.out.print("Quantity: ");
                num = sc.nextInt();
                System.out.println("\t"+num+" Nasi Lemak is added to order");
                price=num*2;
                System.out.println("\tPrice: RM "+price);
                break;
                case 2:
                System.out.print("Quantity: ");
                num = sc.nextInt();
                System.out.println("\t"+num+" Teh Tarik is added to order");
                price=num*1.5;
                System.out.println("\tPrice: RM "+price);
                break;
                case 3: 
                System.out.print("Quantity: ");
                num = sc.nextInt();
                System.out.println("\t"+num+" Roti is added to order");
                price=num*1;
                System.out.println("\tPrice: RM "+price);
                break;
            }
        }while (ch != 'q');
        System.out.print("\nThank you for your order.");
    }
}
