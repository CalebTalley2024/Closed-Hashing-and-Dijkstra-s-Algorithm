

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
        PriorityQueue<ArrayList<Object>> q = new PriorityQueue<ArrayList<Object>>(compareAL);
        ArrayList<Object> lst = new ArrayList<>();
        lst.add(3);
        lst.add("K");
        ArrayList<Object> lst1 = new ArrayList<>();
        lst1.add(19);
        lst1.add("K");
        ArrayList<Object> lst2 = new ArrayList<>();
        lst2.add(2);
        lst2.add("R");

        ArrayList<Object> lst3 = new ArrayList<>();
        lst3.add(1);
        lst3.add("Q");
        q.add(lst);
        q.add(lst1);
        q.add(lst2);
        q.add(lst3);


        System.out.println(q);

    }

}