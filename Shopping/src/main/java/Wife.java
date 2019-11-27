import java.util.ArrayList;
import java.util.Scanner;

public class Wife {

    public static ArrayList wifeMain(){
        int listSize = inputListSize();
        return getProductListToBuy(listSize);
    }

    public static int inputListSize() {
        int listSize;
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.println("Enter list size: ");
                listSize = scanner.nextInt();
                break;
            }catch (TypeNotPresentException e) {
                System.out.println("Uxcepected type!");
            }
        }
        return listSize;
    }

    public static ArrayList getProductListToBuy(int listSize) {
        ArrayList<String> productListBuy = new ArrayList<>();
        for (int i=0; i<listSize;i++) {
            String product = inputProductName();
            productListBuy.add(product);
        }
        System.out.println(productListBuy);
        return productListBuy;
    }
    public static String inputProductName(){
        Scanner scanner2 = new Scanner(System.in);
        String productName;
        while (true){
            try {
                System.out.println("Enter product name: ");
                productName = scanner2.nextLine();
                break;
            }catch (TypeNotPresentException e) {
                System.out.println("Uxcepted type!");
            }
        }
        return productName;
    }

    public static void printAllProducts(ArrayList allProducts, ArrayList allPrices) {
        System.out.println("\nTotal list:");
        for (int i=0;i<allProducts.size()-1;i++) {
            System.out.println(allProducts.get(i) + " - " + allPrices.get(i));
        }
    }

    public static void printAllProductsCanBuy(ArrayList products, ArrayList price){
        System.out.println("\nBought:");
        for (int i=0; i<products.size();i++) {
            System.out.println(products.get(i) + " - " + price.get(i));
        }
    }

    public static void printAllProductsCanBuyPrice(int price){
        System.out.println("\nTotal price = " + price);
    }

}
