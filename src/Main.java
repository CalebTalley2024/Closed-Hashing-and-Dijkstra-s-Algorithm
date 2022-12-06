

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws FileNotFoundException {


//        File file = new File("EdgarAllanPoeBellsB2022groomed.txt");
//        System.out.println(file.canRead());
//        Scanner scan = new Scanner(file);
//        System.out.println(scan.nextLine());

        // Question 4

        int[][] adj = Graph.adjMatrix;
        // test trying to get to D(9)
        ArrayList<Integer> path = new ArrayList<>();
        Graph.dijkstra(adj,0,9,path);


    }

}