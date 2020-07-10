abstract class Cake{
   public String name;
   public String[] topping;
   public String[] topping_order;
   public double price_small;
   public double price_medium;
   public double price_big;
   public double total_price;
   public int size;
   public int quantity;
   
   Cake(String n){
      name = n;
   }
   
   String getName(){
      return name;
   }
   
   String[] getTopping(){
      return topping;
   }
   
   String[] getToppingOrder(){
      return topping_order;
   }
   
   double getPriceSmall(){
      return price_small;
   }
   
   double getPriceMedium(){
      return price_medium;
   }

   double getPriceBig(){
      return price_big;
   }
   
   int getQuantity(){
      return quantity;
   }

   abstract void setCake(String[] topping, double priceSmall, double priceMedium, double priceBig);
   
   void orderCake(String[] toppingOrder, int quantity, int size){
       this.topping_order = topping_order;
       this.quantity = quantity;
       this.size = size;
   }
   
   double getSizePrice(int size, double priceSmall, double priceMedium, double priceBig){
       double sizePrice = 0.0;
       if(size == 1){
          sizePrice = priceSmall;
       }
       else if(size == 2){
          sizePrice = priceMedium;
       }
       else if(size == 3){
          sizePrice = priceBig;
       }
       return sizePrice;
   }
   
    double getTotalPrice(double getSizePrice, int quantity, String[] toppingOrder){
       double totalPrice = getSizePrice(size, price_small, price_medium, price_big) * quantity + (toppingOrder.length*10);
       return totalPrice;
   }

   String getSize(int size){
       String cakeSize = " ";
       if(size == 1){
         cakeSize = "Small";
       }
       else if(size == 2){
         cakeSize = "Medium";
       }
       else if(size == 3){
         cakeSize = "Big";
       }
       return cakeSize;
   }
   
   void printCake(){
       System.out.println("-----------------------------");
       System.out.println("\t\t\tCake Menu");
       System.out.println("-----------------------------");
       System.out.println(name + " with available toppings:");
       for(int i = 0; i < topping.length; i++){
          System.out.println((i+1) + ") " + topping[i]);
      }
      System.out.print("\n");
      System.out.println("Price: ");
      System.out.println("[1] Small : RM" + getPriceSmall());
      System.out.println("[2] Medium: RM" + getPriceMedium());
      System.out.println("[3] Big   : RM" + getPriceBig());
      System.out.print("\n");
  }
       
  void printOrder(){
      double sizePrice = 0.0;
      System.out.println("Cake Order detail:");
      System.out.println("-------------------------------------------");
      System.out.print("Topping : " );
      for(int i = 0; i < topping_order.length; i++){
          System.out.print((i+1) + ") " + topping_order[i] + " ");
      }
      System.out.println("\nSize    : " + getSize(size));
      System.out.println("-------------------------------------------");
      System.out.println("Total Price: RM" + getTotalPrice(sizePrice, quantity, topping_order));
  }
}

   class BlackForest extends Cake{
      BlackForest(String name){
      super(name);
   }
   
   void setCake(String[] topping, double priceSmall, double priceMedium, double priceBig){
       this.topping = topping;
       this.price_small = priceSmall;
       this.price_medium = priceMedium;
       this.price_big = priceBig;
   }
}


   public class Lab5_E3_TestCake1{
      public static void main(String args[]){
        Cake c = new BlackForest("BlackForest");
        String[] topping = {"Chocolate", "Cherries", "Whipped Cream"};
        c.setCake(topping, 45.00, 65.00, 80.00);
        c.printCake();
       
        String[] order = {"Chocolate", "Cherries"};
        c.orderCake(order, 1, 2);
        c.printOrder();
     }
 }