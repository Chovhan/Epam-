import java.util.ArrayList;

public class Main {

    public static final ArrayList<String> allCandis = new ArrayList<String>();
    public static Messages messages = new Messages();
    static ArrayList<ArrayList<String>> myPresent = new ArrayList<>();
    public static ArrayList<String> pathList = new FilePath().getPath();

    public static void main(String[] args) {
        ArrayList<String> lollipopCandisList = new Lollipop().getLollipop(pathList.get(0));
        ArrayList<String> chocolateCandisList = new ChocolateCandy().getChocolateCandy(pathList.get(1));

        allCandis.addAll(lollipopCandisList);
        allCandis.addAll(chocolateCandisList);

        messages.printAllCandis(lollipopCandisList, chocolateCandisList);

        callPresentCreation();
        callPresentSortFunction();
        callPresentFindFunction();
        callSerialize();
    }

    public static void callPresentSortFunction(){
        String answer = messages.askToSort();
        PresentSortFunctions presentSortFunctions = new PresentSortFunctions();
        while (true){
            if (answer.equals("W")){
                messages.printSortedPresent(presentSortFunctions.sortWithWeight(myPresent));
            } else if (answer.equals("P")){
                messages.printSortedPresent(presentSortFunctions.sortWithPrice(myPresent));
            } else {
                break;
            }
        }
    }

    public static void callPresentFindFunction(){
        PresentFindFunctions presentFindFunctions = new PresentFindFunctions();
        String answer = messages.askParameterWithWhatNeedToFindCandy();
        switch (answer) {
            case "N":
                presentFindFunctions.findCandyWithName(myPresent, messages.askCandyNameToFind());
                break;
            case "W":
                presentFindFunctions.findCandyWithWeight(myPresent, messages.askCandyWeightToFind());
                break;
            case "P":
                presentFindFunctions.findCandyWithPrice(myPresent, messages.askCandyPriceToFind());
                break;
        }
    }

    public static void callSerialize(){
        Serialize serialize = new Serialize();
        serialize.serializePresent(myPresent, pathList.get(2));
    }

    public static void callPresentCreation(){
        Present present = new Present();
        while (true){
            String answer = messages.askToAddNewCandy();
            if (answer.equals("Y")){
                present.createPresent(allCandis);
            } else if (answer.equals("N")){
                break;
            } else {
                messages.printRulesException();
            }
        }
        myPresent.addAll(present.splitText());
        messages.printPresentWeight(present.getPresentWeight(myPresent));
    }
}
