import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Present {

    public static Messages messages = new Messages();

    public final Scanner myScanner = new Scanner(System.in);

    public final ArrayList<String> presentList = new ArrayList<>();

    public void createPresent(ArrayList<String> allCandis){
        presentList.add(allCandis.get(getCandyNumberForPresent(allCandis) -1));
        System.out.println(presentList);
    }

    public int getCandyNumberForPresent(ArrayList<String> allCandis){
        messages.printCandyNumberMessageToEnter();
        while (true){
            int candyNumber = myScanner.nextInt();
            if (candyNumber > allCandis.size()){
                messages.printCandyNumberExceptionToEnter(allCandis.size());
            } else {
                return candyNumber;
            }
        }
    }

    public ArrayList<ArrayList<String>> splitText(){
        ArrayList<ArrayList<String>> presentCandis = new ArrayList<>();
        for (String str : presentList){
            String[] smth = str.split(";");
            presentCandis.add(covertation(smth));
        }
        System.out.println(presentCandis);
        return presentCandis;
    }

    public ArrayList<String> covertation(String[] array){
        return new ArrayList<>(Arrays.asList(array));
    }

    public int getPresentWeight(ArrayList<ArrayList<String>> presetCandis){
        int presentWeight = 0;
        for (ArrayList<String> array : presetCandis){
            presentWeight += Integer.parseInt(array.get(1));
        }
        return presentWeight;
    }

}
