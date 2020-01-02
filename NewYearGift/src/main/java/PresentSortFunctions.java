import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.TreeMap;

public class PresentSortFunctions {
    private static final Logger log = Logger.getLogger(FilePath.class);

    public TreeMap<String, Integer> sortWithWeight(ArrayList<ArrayList<String>> myPresent){
        log.info("Was start sort function for weight");
        TreeMap<String, Integer> forWeightSort = new TreeMap<>();
        for (ArrayList<String> arrayList : myPresent){
            forWeightSort.put(arrayList.get(0), Integer.parseInt(arrayList.get(1)));
        }
        return forWeightSort;
    }

    public TreeMap<String, Integer> sortWithPrice(ArrayList<ArrayList<String>> myPresent){
        log.info("Was start sort function for price");
        TreeMap<String, Integer> forPriceSort = new TreeMap<>();
        for (ArrayList<String> arrayList : myPresent){
            forPriceSort.put(arrayList.get(0), Integer.parseInt(arrayList.get(2)));
        }
        return forPriceSort;
    }

}
