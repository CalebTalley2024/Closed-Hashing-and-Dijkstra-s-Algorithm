

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.readString;

public class Main {


    public static void main(String[] args) throws IOException {


// Question 1
        ArrayList<String> words = Hash.getHashedWords(Hash.Poe);
//        ArrayList<String> uniqueWords= Hash.discardDuplicates(words);
        ArrayList<Integer> vals = Hash.getHashValues(words);
        ArrayList<ArrayList<Object>> WV = Hash.getWordsAndValues(Hash.Poe);
        Hashtable<Integer,ArrayList<Object>> HT = Hash.setHashTable(WV);
        Hash.printHashTable(HT, 293);
//        System.out.println(WV);
//        System.out.println(words.size()==vals.size());
//        System.out.println(vals);
//        System.out.println(Hash.setHashTable(vals));

//        Hashtable<Integer,Integer> HS = new Hashtable<>(3);
//        HS.put(0,0);
//        HS.put(1,1);
//        HS.put(2,2);
//        System.out.println(HS);
//        System.out.println(HS.containsKey(3));
//        System.out.println(HS.containsKey(1));
//        Hash.getKV(2,HS,0,293);
//        System.out.println(HS);
        // Question 4

//        int[][] adj = Graph.adjMatrix;
//        // test trying to get to D(9)
//        ArrayList<Integer> path = new ArrayList<>();
//        Graph.dijkstra(adj,0,2,path,0, new ArrayList<Integer>());


    }

}