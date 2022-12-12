

import javax.lang.model.element.ModuleElement;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.sql.SQLOutput;
import java.util.*;

import static java.nio.file.Files.readString;

public class Main {


    public static void main(String[] args) throws IOException {

        int[] hashValues = new int[10];
        hashValues[2] = 3;
//        System.out.println(Arrays.toString(hashValues));
// Question 1 and 2
        HashTableC HT = new HashTableC();
        HT.questions12();
//        HT.getNumFilledAddresses();
//        HT.getMostDistinctHashValue();
//        HT.getLongestEmptyArea();
//        HT.getLongestCluster();


// Question 3

// Question 4

//        Dijkstra.question4();
    }

}