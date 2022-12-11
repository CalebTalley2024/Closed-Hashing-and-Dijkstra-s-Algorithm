import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Vector;

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

    int a = 1;
    int b = 2;
   public Dijkstra(int a,int b){
      this.a = a;
       this.b = b;
    }
    // pseudo code

    // Priority queue methods needed
    /* update
     *update order
     *
     * */

    //Dijkstra: adjM: graph, s: source vertex
    public static ArrayList<Vertex> DijkstraAlgorithm(int[][] adjM, int s){
        CompareAL compareAL = new CompareAL();

        ArrayList<Vertex> vertices = new ArrayList<>();
        //V: All of our vertices
        ArrayList<Integer> V = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        //Vt: vertices transversed
        ArrayList<Integer> V_T = new ArrayList<>();

        // pQueue: our priority queue
        PriorityQueue<Vertex> Q = new PriorityQueue<>(compareAL);
        // for every vertex in V
        for(int i = 0; i<V.size(); i++){
            if(i == numToLetter(s)){
                //initallize priority of s with ds
                // make distance to source vertex = 0
                Vertex aVertex = new Vertex(numToLetter(i),0,'\0');
                vertices.add(aVertex);

                Q.add(aVertex);
            }
            else{
                // null character: \0
                Vertex aVertex = new Vertex(numToLetter(i),Integer.MAX_VALUE,'\0');
                vertices.add(aVertex);
                Q.add(aVertex);
            }
        }

        //delete the minimum priority vertex
        for(int i = 0; i<V.size();i++){

            // compared to slides...
            //y = u*
            //u = u
            //delete the minimum priority vertex
            Vertex poll = Q.poll();
            int y = letterToNum(poll.node);
            //du: distance of u
            int d_y = poll.d;
            // instead of making V_T queue, we remove the vertex from V
            V.remove((Object)y);
//            V_T.add(u);
            //for every vertex u in V − VT adjacent to u∗ do
            for( int u: V){
                // find the distance weight from y to u
                int d_u = getD(vertices,u);
                int w = adjM[y][u];
                if((d_y + w )<d_u){
                    d_u = d_y + w;
                    char p_u = numToLetter(u);
                    // update vertices
                    Vertex update = new Vertex(numToLetter(u),d_u,p_u);
                    updateVertices(vertices,update);
                }

            }
        }
        return vertices;
    }

    // getLetter: gets a number and returns the vertice name
    public static char numToLetter(int n){
        char s = '\0';
        switch(n){
            case 0:
                s = 'A';
                break;
            case 1:
                s = 'J';
                break;
            case 2:
                s = 'M';
                break;
            case 3:
                s = 'R';
                break;
            case 4:
                s = 'K';
                break;
            case 5:
                s = 'S';
                break;
            case 6:
                s = 'I';
                break;
            case 7:
                s = 'N';
                break;
            case 8:
                s = 'T';
                break;
            case 9:
                s = 'D';
                break;


        }
        return s;
    }
    public static int letterToNum(char s){
        int n = -1;
        switch(s){
            case 'A':
                n = 0 ;
                break;
            case 'J':
                n = 1;
                break;
            case 'M':
                n = 2 ;
                break;
            case 'R':
                n = 3;
                break;
            case 'K':
                n = 4;
                break;
            case 'S':
                n = 5;
                break;
            case 'I':
                n = 6;
                break;
            case 'N':
                n = 7;
                break;
            case 'T':
                n = 8;
                break;
            case 'D':
                n = 9;
                break;
        }
        return n;
    }


    // getD: get the current distance using the letter in number form
    public static int getD(ArrayList<Vertex> vertices, int s){
        char letter = numToLetter(s);
        int newD = 0;
        for (int i = 0; i< vertices.size();i++){
            if(letter == vertices.get(i).node){
                newD =  vertices.get(i).d;
            }
        }
        return newD;
    }

    public static void updateVertices(ArrayList<Vertex> vertices, Vertex updateVertex){
        for (int i = 0; i< vertices.size();i++){
            if(updateVertex.node == vertices.get(i).node){
                vertices.set(i,updateVertex);
            }
        }
    }

}
