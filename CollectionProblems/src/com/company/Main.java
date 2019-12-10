package com.company;

import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static String filePath = "ThreeGraph.txt";
    public static TreeMap<String, Integer> treeMap = new TreeMap<>();

    public static void main(String[] args) throws Exception {
        calculateThreeGraph(findThreeGraph(splitText(readFile().toString().toUpperCase())));
        printThreeGraphCol();
    }

    public static StringBuilder readFile()  throws Exception{
        FileReader fileReader = new FileReader(filePath);
        Scanner scanner = new Scanner(fileReader);
        StringBuilder q = new StringBuilder();
        while (scanner.hasNextLine()){
            q.append(scanner.nextLine());
        }
        fileReader.close();
        return q;
    }

    public static ArrayList<String> splitText(String q){
        String w = q.replaceAll("[^A-Za-zА-Яа-я0-9- ]", "");
        return new ArrayList<>(Arrays.asList(w.split(" ")));
    }

    public static ArrayList<String> findThreeGraph(ArrayList<String> allThreeGraphArray){
        ArrayList<String> array = new ArrayList<>();
//        allThreeGraphArray.stream().filter(q -> q.length() - 3 ).collect(Collectors.toList()).forEach(System.out::println);
        for (int j=0; j<allThreeGraphArray.size();j++){
            for (int i = 0; i <= allThreeGraphArray.get(j).length() - 3; i++) {
                array.add(allThreeGraphArray.get(j).substring(i, i + 3));
            }
        }
        return array;
    }

    public static void calculateThreeGraph(ArrayList<String> array){
//        array.stream().filter((arr) -> treeMap.containsKey(arr)).forEach(System.out::println);
        for (String str : array) {
            if (treeMap.containsKey(str)) {
                treeMap.put(str, Collections.frequency(array, str));
            }else {
                treeMap.put(str, Collections.frequency(array, str));
            }
        }
    }

    public static void printThreeGraphCol() {
        treeMap.forEach((a,b) -> System.out.println(a + "=" + b));
    }

}