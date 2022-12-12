import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class HashTableC {

    // constructor
    ArrayList<HashObject> table;
    HashTableC(){
        this.table = new ArrayList<>();
    }


    public  void questions12() throws FileNotFoundException {
        // change these two values to work on test and actual text files
        int m = 1000;
        String txtFile = Hashing.Raven;
        this.initHT(m);
        this.setHashTableC(txtFile,m);
        this.printHTable();



    }
    // initHT: initialize HashTable based on size
    public void initHT (int size){
        for(int i = 0; i<size; i++){
            // make an empty HO and put it inside the HashTable
            HashObject aHO = new HashObject();
            this.table.add(aHO);
        }
//        return table;
    }
    public void setHashTableC(String txtFile, int m) throws FileNotFoundException {
        ArrayList<HashObject> HT = this.table;

        ArrayList<HashObject> HashObjects = Hashing.getWordsAndValues(txtFile);
        int hosSize = HashObjects.size();
        for(int i = 0; i< hosSize;i++){
            HashObject aHO = HashObjects.get(i);
            int newKey = getValidKey(aHO,HT,0,m);
            // if there is not a duplicate, add the HashObject to the ArrayList
            if(newKey != -1){
                HT.set(newKey,aHO);
            }

        }
    }
    public static int getValidKey(HashObject HO, ArrayList<HashObject> HT, int keyIncrement,int sizeHT){
        // first check to  in O(1) time
        /**
         *
         *
         *
         *
         *
         *
         */
        int ans = -1;
        int i = keyIncrement;
        int m = sizeHT;
        String word = HO.word;
        int value =  HO.value;
        if(value == 13){
//            System.out.println("Debug Test :)");
        }
        // does circling back for us
        int newKey = (value + i) % m;

        // make sure that the word we are trying to put in is NOT a duplicate of something already in the HashMap
        if(HT.get(newKey).word.equals(word)){
            newKey = -1;
        }
            // if the HT already has something at your key, look for the next value
       else if (HT.get(newKey).value != -1) {
            i++;
            newKey = getValidKey(HO, HT, i, m);
        }

        // make condition for if the table is full
        return newKey;

    }

    // helpers
    public void printHTable(){
        int size = this.table.size();
        ArrayList<HashObject> HT = this.table;
        for(int i = 0; i<size; i++){
            HashObject aHO = HT.get(i);
            System.out.println( i + " " + aHO.word+" "+ aHO.value+ " ");
        }
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


}
