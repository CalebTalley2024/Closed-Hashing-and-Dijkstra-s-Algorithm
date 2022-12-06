import java.util.ArrayList;

public class Graph {
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


    // flip (using diagonal (flip rows and columns index)) and look for the next non zero value
    // repeat till hit your goal node
    // need condition for if I dont reach the goal

    //    DIjkstra: returns path, length of the path, and now many nodes traveled for the path
    public static void dijkstra (int[][] adj, int start, int end, ArrayList<Integer> knownPath){
        // add the start node to the knownPaths
        knownPath.add(start);
        // implement scanner later///////
        int length = adjMatrix.length;
        // iterate through first row till you see a non zero value
        //i: column, j: row
        int i  = start;
            for(int j = start+1; j<length;j++){
                // end condition
                 if(j == end){
                     knownPath.add(end);

                     // end the loop
                     break;
                 }
                else if(adj[i][j] !=0){
                     // make i equal to j and transverse through the list again
                     i = j;
                     dijkstra(adj,i,end, knownPath);
                     

                }
                if(j == length-1){
                    // this is a dead end
                }
            }

        System.out.println(knownPath);
//        return knownPath;

    }
    public void pathFinder(int[][] adj, int start, int end,int column ){
        int length = adjMatrix.length;
        for(int j = 0; j<length;j++){
            // check to see if your node is the one you are looking for
            
        }
    }
    // skip if the number is a zero

}



