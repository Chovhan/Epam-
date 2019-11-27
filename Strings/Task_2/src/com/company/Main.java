package com.company;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String myString = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has " +
                "been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley " +
                "of type and scrambled it to make a type specimen book. It has survived not only five centuries, but " +
                "also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the " +
                "1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with " +
                "desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";
        printText(myString);

        String toFind = inputStringToFind();

        myString = replaceSymbolsFromText(convertTextToLowerCase(myString));
        ArrayList arrayWithWords = convertTextToWordsArray(myString);

        HashMap hashMap = initHashMap();
        ValueComporator comporator = initValueComporator(hashMap);
        addToHashMap(arrayWithWords, hashMap, toFind);
        workWithTreeMap(comporator, hashMap, arrayWithWords);

    }
    public static String replaceSymbolsFromText(String str) {
        str = str.replaceAll("[^A-Za-zА-Яа-я0-9- ]", "");
        return str;
    }

    public static ArrayList convertTextToWordsArray(String str) {
        String[] array = str.split(" ");
        ArrayList arrayWithWords =  new ArrayList(Arrays.asList(array));
        return arrayWithWords;
    }

    public static String convertTextToLowerCase(String str) {
        return str.toLowerCase();
    }

    public static void printText (String str) {
        System.out.println(str);
    }
    public static HashMap initHashMap () {
        HashMap<String, Integer> hashMap = new HashMap<String, Integer>();
        return hashMap;
    }

    public static ValueComporator initValueComporator(HashMap hashMap){
        ValueComporator comporator = new ValueComporator(hashMap);
        return comporator;
    }

    public static HashMap addToHashMap(ArrayList arrayWithWords, HashMap hashMap, String toFind) {
        String names;
        for (int i=0; i<arrayWithWords.size();i++) {
            names = arrayWithWords.get(i).toString();
            if (hashMap.containsKey(names)) {
                hashMap.put(names, Collections.frequency(Arrays.asList(names.split("")), toFind));
            }else {
                hashMap.put(names, Collections.frequency(Arrays.asList(names.split("")), toFind));
            }
        }
        return hashMap;
    }

    public static void workWithTreeMap(Comparator comporator, HashMap hashMap, ArrayList arrayWithWords) {
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>(comporator);

        treeMap.putAll(hashMap);
        System.out.println("\nResult:");
        for (Map.Entry i : treeMap.entrySet()) {
            printResult(i.getKey().toString(), i.getValue().toString());
        }
    }

    public static void printResult(String q, String w) {
        System.out.println(q + " : " + w);
    }

    public static String inputStringToFind() {
        String toFind;
        Scanner scanner = new Scanner(System.in);
        while (true){
            try {
                System.out.println("\nEnter letter to find: ");
                toFind = scanner.nextLine().toLowerCase();
                break;
            }catch (TypeNotPresentException e) {
                System.out.println("Unexpected type!");
            }
        }
        return toFind;
    }
}
