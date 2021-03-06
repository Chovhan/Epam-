import org.apache.log4j.Logger;

import java.util.ArrayList;

public class PresentFindFunctions {
    private static final Logger log = Logger.getLogger(FilePath.class);

    public ArrayList<String> findCandyWithName(ArrayList<ArrayList<String>> myPresent, String name){
        log.info("Start find function with name");
        ArrayList<String> findCandy = null;
        for (ArrayList<String> arrayList : myPresent){
            if (arrayList.get(0).equals(name)){
                findCandy = arrayList;
                Main.messages.printFindedCandy(findCandy);
            }
        }
        return findCandy;
    }
    public ArrayList<String> findCandyWithWeight(ArrayList<ArrayList<String>> myPresent, int weight){
        log.info("Start find function with weight");
        ArrayList<String> findCandy = null;
        for (ArrayList<String> arrayList : myPresent){
            System.out.println(arrayList);
            if (Integer.parseInt(arrayList.get(1)) == weight){
                findCandy = arrayList;
                Main.messages.printFindedCandy(findCandy);
            }
        }
        return findCandy;
    }
    public ArrayList<String> findCandyWithPrice(ArrayList<ArrayList<String>> myPresent, int price){
        log.info("Start find function with price");
        ArrayList<String> findCandy = null;
        for (ArrayList<String> arrayList : myPresent){
            if (Integer.parseInt(arrayList.get(2)) == price){
                findCandy = arrayList;
                Main.messages.printFindedCandy(findCandy);
            }
        }
        return findCandy;
    }
}
