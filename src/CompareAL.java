import java.util.ArrayList;
import java.util.Comparator;

 class CompareAL implements Comparator<Vertex> {

     public int compare(Vertex o1, Vertex o2) {
         int bigger = -1;
         int o1Int =  o1.d;
         int o2Int =  o2.d;
         if(o1Int > o2Int){
//             bigger = o1Int;
             return 1;
         }

         else if(o2Int > o1Int){
//             bigger = o2Int;
             return -1;
         }
         return 0;
     }
 }
