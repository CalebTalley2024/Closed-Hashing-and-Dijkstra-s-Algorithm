import java.util.*;
import java.lang.Object;

public class Dijkstra {
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
    public static CompareAL compareAL = new CompareAL();

    public static void question4(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter valid starting node:");
        System.out.println(" Choices: A, R, T, S, K, J, I, or D...... ");
        char start = scan.next().charAt(0);
        System.out.println();
        System.out.println("Enter valid ending node");
        System.out.println(" Choices: A, R, T, S, K, J, I, or D...... ");
        char end = scan.next().charAt(0);


        ArrayList<Vertex> vertices = DijkstraAlgorithm(start);
//        vertices.forEach(vertex -> vertex.printVertex());
        LinkedList<Character> sequence = new LinkedList<>();
        sequence = getSequence(vertices,end,sequence);
        int lengthPath = getLengthPath(vertices,end);

        System.out.println("Your starting node: "+ start + "  ");
        System.out.println("Your ending node: "+ end);
        System.out.println();
        System.out.println("Below is your most optimal path from "+start +" to " + end);
        System.out.println(sequence);
        System.out.println("The length of the path is "+ lengthPath);

    }
    /* input: node we are trying to find, vertices
     * iterate thorough list to get right vertice
     * recursive call until the vertice is null
     * */
    // getSequence: takes in vertices, start node "s" and end node "e"
    // returns the sequence for going from s to e
    public static LinkedList<Character> getSequence(ArrayList<Vertex> vertices, char node, LinkedList<Character> sequence){
        // Terminating condition break to the return if you have a null Node value
        int size = vertices.size();
        if(node != '\0'){
            sequence.addFirst(node);
            int n = letterToNum(node);
//            Vertex vEnd;
            char newPNode = '1';
            // get the vertex for our end node
            for(int i = 0; i<size; i++){
                // find the Vertex with the end node
                if(vertices.get(i).node == node){

                    newPNode = vertices.get(i).pNode;
                    // recursive call that goes till we find a pNode with  a null value
                    getSequence(vertices,newPNode,sequence);
                }


        }

        }
//        System.out.println(sequence);
        return sequence;

    }


    public static int getLengthPath(ArrayList<Vertex> vertices, char end){
        int length = 0;
        for(int i = 0; i< vertices.size();i++){
            Vertex aVertex = vertices.get(i);
//            System.out.println(aVertex.d);
            if(aVertex.node == end){
                length = aVertex.d;
            }
        }
        return length;
    }
    //Dijkstra: adjM: graph, s: source vertex
    public static ArrayList<Vertex> DijkstraAlgorithm(char start){
        int s = letterToNum(start);
        int[][] adjM = adjMatrix;
        ArrayList<Vertex> vertices = new ArrayList<>();
        //V: All of our vertices
        ArrayList<Integer> V = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));
        //Vt: vertices transversed
        ArrayList<Integer> V_T = new ArrayList<>();

        // pQueue: our priority queue
        PriorityQueue<Vertex> Q = new PriorityQueue<>(compareAL);
        // for every vertex in V
        for(int i = 0; i<V.size(); i++){
            if(i == s){ // this is for  our source vertex
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
        int vSize = V.size();
        for(int i = 0; i<vSize;i++){

            // compared to slides...
            //y = u*
            //u = u
            //delete the minimum priority vertex
            Vertex poll = Q.poll();
            char letter = poll.node;
            int y = letterToNum(poll.node);
            //du: distance of u
            int d_y = poll.d;
            // instead of making V_T queue, we remove the vertex from V
            V.remove((Object)y);
//            V_T.add(u);
            //for every vertex u in V − VT adjacent to u∗ do
            for( int u: V){
                // find the distance weight from y to u
                if(adjM[y][u] != 0){
                    int d_u = getCurrentD(vertices,u);
                    int w = adjM[y][u];
                    if((d_y + w )<d_u){
                        d_u = d_y + w;
                        char p_u = numToLetter(y);
                        // update vertices
                        Vertex updates = new Vertex(numToLetter(u),d_u,p_u);
                        updateVertices(vertices,updates);
                        Q = updateQ(vertices,Q);
                    }
                }


            }
        }
//        vertices.forEach((vertex -> vertex.printVertex()));
        return vertices;
    }

    // getLetter: gets a number and returns the vertex's name
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
    public static int getCurrentD(ArrayList<Vertex> vertices, int s){
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
        // updating the vertices
        for (int i = 0; i< vertices.size();i++){
            if(updateVertex.node == vertices.get(i).node){
                vertices.set(i,updateVertex);
            }
        }
        // updating the queue

    }
    public static PriorityQueue<Vertex> updateQ(ArrayList<Vertex> vertices, PriorityQueue<Vertex> Q){
        /// figure out how tio make a clone of a queue
        PriorityQueue<Vertex> oldQ = new PriorityQueue<>(Q);
        // make arrayList from our old Queue
        ArrayList<Vertex> qAL = new ArrayList<>(oldQ);
//        System.out.println(qAL);

        for (int i = 0; i<qAL.size();i++){
            for(int j = 0; j<vertices.size(); j++){
                if(qAL.get(i).node == vertices.get(j).node){
                    qAL.set(i,vertices.get(j));
                }
            }
        }
        // update Q
        PriorityQueue<Vertex> newQ = new PriorityQueue<>(compareAL);
        qAL.forEach(vertex -> newQ.add(vertex));
        return newQ;

    }

}
