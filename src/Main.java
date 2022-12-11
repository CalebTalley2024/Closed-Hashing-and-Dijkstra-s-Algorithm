

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


// Question 1 and 2
//        Hash.questions12();


// Question 4

        CompareAL compareAL = new CompareAL();
//        PriorityQueue<ArrayList<Object>> q = new PriorityQueue<ArrayList<Object>>(compareAL);
//        ArrayList<Object> lst = new ArrayList<>();
//        lst.add("K");
//        lst.add(3);
//        lst.add("K");
//        ArrayList<Object> lst1 = new ArrayList<>();
//        lst1.add("K");
//        lst1.add(19);
//        lst1.add("K");
//        ArrayList<Object> lst2 = new ArrayList<>();
//        lst2.add("K");
//        lst2.add(2);
//        lst2.add("R");
//        ArrayList<Object> lst3 = new ArrayList<>();
//        lst3.add("K");
//        lst3.add(1);
//        lst3.add("Q");
//        q.add(lst);
//        q.add(lst1);
//        q.add(lst2);
//        q.add(lst3);

//        System.out.println(q);

//        Dijkstra DK = new Dijkstra(2,3);
////        System.out.println(DK);
//
//        PriorityQueue<Vertex> Q = new PriorityQueue<>(compareAL);
//        Vertex aq = new Vertex('B',342,'\0');
//        Q.add(aq);
//        Q.add(new Vertex('A',0,'\0'));
//        Q.add(new Vertex('C',91,'\0'));
//
//        System.out.println(Q.poll().node);
//        Q.poll().printVertex();
//        Q.poll().printVertex();
        char s = 'A';

        ArrayList<Vertex> vertices = Dijkstra.DijkstraAlgorithm(Dijkstra.adjMatrix, Dijkstra.letterToNum(s));
        vertices.forEach((vertex -> vertex.printVertex()));
        System.out.println();




    }

}