

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.Files.readString;

public class Main {


    public static void main(String[] args) throws IOException {


        File file = new File("EdgarAllanPoeBellsB2022groomed.txt");

        String currentPath = file.getAbsolutePath();
        System.out.println(currentPath);
        System.out.println(file.canRead());
        Scanner scan = new Scanner(file);

        while(scan.hasNext()){
            String word = scan.next();
            System.out.println(word);

        }
        scan.close();
//        System.out.println(file);





        // Question 4

//        int[][] adj = Graph.adjMatrix;
//        // test trying to get to D(9)
//        ArrayList<Integer> path = new ArrayList<>();
//        Graph.dijkstra(adj,0,9,path);


    }

}