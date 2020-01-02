import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

public class Messages {
    public final Scanner myScanner = new Scanner(System.in);

    public final void printRulesException(){
        System.out.println("Stick the rules!");
    }

    public void printPresentWeight(int weight){
        System.out.println("The present weight is: " + weight + " grams!");
    }

    public void printCandyNumberMessageToEnter(){
        System.out.println("Enter candy number to add it into a present: ");
    }

    public void printCandyNumberExceptionToEnter(int allCandyCol){
        System.out.println("Enter candy number form 1 to " + allCandyCol);
    }
    public void printAllCandis(ArrayList<String> lollipopList, ArrayList<String> chocolateList){
        System.out.println("All Candies:");
        lollipopList.stream().map(str -> str.replaceAll(";", " : ")).forEach(System.out :: println);
        chocolateList.stream().map(str -> str.replaceAll(";", " : ")).forEach(System.out :: println);
    }

    public String askToAddNewCandy() {
        System.out.println("If you want to add new candy enter 'Y', if not 'N'");
        return myScanner.nextLine().toUpperCase();
    }

    public String askToSort(){
        System.out.println("If you want to sort your present with weight enter - 'W', with price - 'P': ");
        return myScanner.nextLine().toUpperCase();
    }

    public String askParameterWithWhatNeedToFindCandy(){
        System.out.println("If you want to find candy in present with weight enter - 'W', with price - 'P', with name - 'N': ");
        return myScanner.nextLine().toUpperCase();
    }

    public String askCandyNameToFind(){
        System.out.println("Enter candy name to find: ");
        return myScanner.nextLine().toUpperCase();
    }
    public int askCandyPriceToFind(){
        System.out.println("Enter candy price to find: ");
        int answer;
        while (true){
            try {
                answer = myScanner.nextInt();
                break;
            }catch (IllegalAccessError e){
                System.out.println("Wrong data type!");
            }
        }
        return answer;
    }
    public int askCandyWeightToFind(){
        System.out.println("Enter candy weight to find: ");
        int answer;
        while (true){
            try {
               answer = myScanner.nextInt();
               break;
            }catch (IllegalAccessError e){
                System.out.println("Wrong data type!");
            }
        }
        return answer;
    }

    public void printSortedPresent(TreeMap<String, Integer> treeMap) {
        System.out.println("\nYour Present: ");
        treeMap.forEach((a,b) -> System.out.print(a + " = " + b));
    }

    public void printFindedCandy(ArrayList<String> findCandy){
        System.out.println("We find your candy: " + findCandy);
    }

}
