import java.util.ArrayList;

public class Dijkstra {

    int infinity = Integer.MAX_VALUE;
    int size = 10;
    public static int[][] adjMatrix = {
            {0, 53, 10, 12, 0, 0, 0, 0, 0, 0},
            {53, 0, 33, 0, 2, 0, 101, 0, 0, 0},
            {10, 33, 0, 9, 30, 18, 0, 0, 0, 0},
            {12, 0, 9, 0, 0, 17, 0, 0, 6, 0},
            {0, 2, 30, 0, 0, 14, 123, 122, 0, 0},
            {0, 0, 18, 17, 14, 0, 0, 137, 7, 0},
            {0, 101, 0, 0, 123, 0, 0, 8, 0, 71},
            {0, 0, 0, 0, 122, 137, 8, 0, 145, 66},
            {0, 0, 0, 6, 0, 7, 0, 145, 0, 212},
            {0, 0, 0, 0, 0, 0, 71, 66, 212, 0},
    };
    // pseudo code

    // Priority queue methods needed
    /* update
     *update order
     *
     * */
    // getLetter: gets a number and returns the vertice name
    public String getLetter(int n){
        String s = "";
        switch(n){
            case 0:
                s = "A";
            break;
            case 1:
                s = "J";
                break;
            case 2:
                s = "M";
                break;
            case 3:
                s = "R";
                break;
            case 4:
                s = "K";
                break;
            case 5:
                s = "S";
                break;
            case 6:
                s = "I";
                break;
            case 7:
                s = "N";
                break;
            case 8:
                s = "T";
                break;
            case 9:
                s = "D";
                break;


        }
        return s;
    }
//    Dijkstra(int[][], int s){
//
//        ArrayList<ArrayList<Object>> q = new ArrayList<ArrayList<Object>>();
//        for ()
//    }
}
