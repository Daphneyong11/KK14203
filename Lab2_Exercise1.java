public class Lab2_Exercise1
{
    public static void main(String []args){
    int i,j;
    for (i=0; i<5;i++){
        for(j=5; j>i;j--){
            System.out.print("*");
        }
        System.out.print("\n");
    }
    System.out.println();
    for(i=1; i<=5; i++){
        for(j=1;j<=i;j++){
            System.out.print("*");
        }
        System.out.println();
    }
    System.out.println();
    for(i=1; i<=5; i++){
        for(j=1;j<=5-i;j++){
            System.out.print(" ");
        }
        for(j=1;j<=i;j++){
            System.out.print("*");
        }
        System.out.println();
    }
        System.out.println();
    }
}

