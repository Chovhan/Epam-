import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Present {

    private static final Logger log = Logger.getLogger(FilePath.class);

    public static Messages messages = new Messages();

    public final Scanner myScanner = new Scanner(System.in);

    public final ArrayList<String> presentList = new ArrayList<>();

    public void createPresent(ArrayList<String> allCandis){
        log.info("Was start function to add candy to present");
        presentList.add(allCandis.get(getCandyNumberForPresent(allCandis) -1));
        System.out.println(presentList);
    }

    public int getCandyNumberForPresent(ArrayList<String> allCandis){
        log.info("Was start function to find candy in list");
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
        log.info("Was start function to split the text in list");
        ArrayList<ArrayList<String>> presentCandis = new ArrayList<>();
        for (String str : presentList){
            String[] smth = str.split(";");
            presentCandis.add(covertation(smth));
        }
        System.out.println(presentCandis);
        return presentCandis;
    }

    public ArrayList<String> covertation(String[] array){
        log.info("Was start function to convert array to ArrayList");
        return new ArrayList<>(Arrays.asList(array));
    }

    public int getPresentWeight(ArrayList<ArrayList<String>> presetCandis){
        log.info("Was start function to calculate present weight");
        int presentWeight = 0;
        for (ArrayList<String> array : presetCandis){
            presentWeight += Integer.parseInt(array.get(1));
        }
        return presentWeight;
    }

}
