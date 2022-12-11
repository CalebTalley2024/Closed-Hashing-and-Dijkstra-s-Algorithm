import java.util.ArrayList;
import java.util.Comparator;

 class CompareAL implements Comparator<ArrayList<Object>> {

     public int compare(ArrayList<Object> o1, ArrayList<Object> o2) {
         int bigger = -1;
         int o1Int = (Integer) o1.get(0);
         int o2Int = (Integer) o2.get(0);
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
