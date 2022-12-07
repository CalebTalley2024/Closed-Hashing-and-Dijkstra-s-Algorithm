

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.nio.file.Files.readString;

public class Main {


    public static void main(String[] args) throws IOException {


// Question 1
        ArrayList<String> words = Hash.getHashedWords();
        ArrayList<String> uniqueWords= Hash.discardDuplicates(words);
        ArrayList<Integer> vals = Hash.getHashValues(uniqueWords);
        System.out.println(vals.size());
        System.out.println(Hash.setHashTable(vals));


        // Question 4

//        int[][] adj = Graph.adjMatrix;
//        // test trying to get to D(9)
//        ArrayList<Integer> path = new ArrayList<>();
//        Graph.dijkstra(adj,0,9,path);


    }

}