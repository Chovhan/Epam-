import java.util.ArrayList;
import java.util.TreeMap;

public class PresentSortFunctions {

    public TreeMap<String, Integer> sortWithWeight(ArrayList<ArrayList<String>> myPresent){
        TreeMap<String, Integer> forWeightSort = new TreeMap<>();
        for (ArrayList<String> arrayList : myPresent){
            forWeightSort.put(arrayList.get(0), Integer.parseInt(arrayList.get(1)));
        }
        return forWeightSort;
    }

    public TreeMap<String, Integer> sortWithPrice(ArrayList<ArrayList<String>> myPresent){
        TreeMap<String, Integer> forPriceSort = new TreeMap<>();
        for (ArrayList<String> arrayList : myPresent){
            forPriceSort.put(arrayList.get(0), Integer.parseInt(arrayList.get(2)));
        }
        return forPriceSort;
    }

}
