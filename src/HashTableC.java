import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class HashTableC {

    // constructor
    ArrayList<HashTableObject> table;
    HashTableC(){
        this.table = new ArrayList<>();
    }


//    public static void questions12() throws FileNotFoundException {
//        ArrayList<ArrayList<Object>> WV = getWordsAndValues(Raven);
//        HashMap<Integer,ArrayList<Object>> HT = setHashMap(WV);
//        Hash.printHashMap(HT, 1000);
//
//    }
    // initHT: initialize HashTable based on size

    public void setHashTableC(String txtFile) throws FileNotFoundException {
        ArrayList<HashObject> HashObjects = Hashing.getWordsAndValues(txtFile);


    }
    public void initHT (int size){
        for(int i = 0; i<size; i++){
            // make an empty HO and put it inside the HashTable
            HashTableObject aHTO = new HashTableObject(i);
            this.table.add(aHTO);
        }
//        return table;
    }

    // helpers
    public void printHTable(){
        this.table.forEach(HTO -> System.out.println(HTO.key + " " + HTO.HO.word+" "+HTO.HO.value+ " ") );
    }



    // old functions

    public static HashMap<Integer,ArrayList<Object>> setHashTable(ArrayList<ArrayList<Object>> hashWordsValues){
        int m = 1000;
        HashMap<Integer,ArrayList<Object>> HT = new HashMap<>(m);
//        if (HashMap.size() >= table_size){
//            System.out.println("Table is full");
//            break;
//        }
        for(int i =0; i<hashWordsValues.size();i++){
            getKV(hashWordsValues.get(i),HT,0,m);
            // Make function for when an index is taken
        }
        System.out.println(HT.size());
        return HT;
    }

    public static void printHashMap(HashMap<Integer,ArrayList<Object>> HT, int maxSize){
        System.out.println("Hash Address | Hashed Word\t|\tHash Value of Word");
        for(int i = 0; i<maxSize;i++){
            int key = i;
            if(HT.get(key)!= null){
                String hashedWord = (String)HT.get(key).get(0);
                int hashValue = (int)HT.get(key).get(1);
                System.out.println(key +"\t|\t"+hashedWord+"\t\t\t\t|\t\t\t\t"+hashValue);
            }

        }

    }

    // getKV: get valid Key for hash value, casade down the hashmap if need. Also checks for duplicates
    public static void getKV(ArrayList<Object> hashWordsValue, HashMap<Integer,ArrayList<Object>> HT, int keyIncrement,int sizeHT){
        // first check to make sure that the value we are trying to put in is NOT a duplicate of something already in the HashMap
        if(!HT.containsValue(hashWordsValue)) {

            int i = keyIncrement;
            int m = sizeHT;
            String hashWord = (String) hashWordsValue.get(0);
            int hashValue = (int) hashWordsValue.get(1);
            // does circling back for us
            int newKey = (hashValue + i) % m;
            // if the HT already has something at your key, look for the next value
            if (HT.containsKey(newKey)) {
                i++;
                getKV(hashWordsValue, HT, i, m);
            }

            // make condition for if the table is full
            else {
                if(hashValue==0){
                    System.out.println("edolrfqweopiufrpioqwedopfuaoisefuopawuifepdaps");
                }
                if(hashWord != ""){ // gets rid of edge case errror

                    HT.put(newKey, hashWordsValue);
                }
            }
        }
    }




}
