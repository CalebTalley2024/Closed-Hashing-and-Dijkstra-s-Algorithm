import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Hash {

    public static String Poe = "EdgarAllanPoeBellsB2022groomed.txt";
    public static Hashtable<Integer,ArrayList<Object>> setHashTable(ArrayList<ArrayList<Object>> hashWordsValues){
        int m = 293;
//        List<Integer> hashValuesND = discardDuplicates(hashValues);
        Hashtable<Integer,ArrayList<Object>> HT = new Hashtable<>(m);
//        if (hashtable.size() >= table_size){
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

    public static void printHashTable(Hashtable<Integer,ArrayList<Object>> HT, int maxSize){
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
    public static void getKV(ArrayList<Object> hashWordsValue, Hashtable<Integer,ArrayList<Object>> HT, int keyIncrement,int sizeHT){
        // first check to make sure that the value we are trying to put in is NOT a duplicate of something already in the HashTable
        if(!HT.containsValue(hashWordsValue)) {

            int i = keyIncrement;
            int m = sizeHT;
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
                HT.put(newKey, hashWordsValue);
            }
        }

    }

    public static ArrayList<ArrayList<Object>> getWordsAndValues(String txtFile) throws FileNotFoundException {
        ArrayList<String> words = getHashedWords(txtFile);
        ArrayList<Integer> vals = Hash.getHashValues(words);
        // WV: words and values
        ArrayList<ArrayList<Object>> WV = new ArrayList<>();
        for(int i = 0; i<words.size();i++){
            //HO: hash object
            ArrayList<Object> HO = new ArrayList<>();
            HO.add(words.get(i));
            HO.add(vals.get(i));
            WV.add(HO);
        }
        return WV;
    }
    public static ArrayList<String> getHashedWords(String txtFile) throws FileNotFoundException {
        // in: our original txt file as a list of strings
        ArrayList<String> in = new ArrayList<>();
        File file = new File(txtFile);
        Scanner scan = new Scanner(file);
        while(scan.hasNext()){
            String word = scan.next();
            in.add(word);
//            System.out.println(word);

        }
        scan.close();

        // out: filtered txt file as a list of strings
        ArrayList<String> out = new ArrayList<>();

        in.forEach((word)-> out.add(cleanString(word)));
        return out;
    }

    public static ArrayList<Integer> getHashValues(ArrayList<String> words){
        ArrayList<Integer> hashValues = new ArrayList<>();
        words.forEach((word) -> hashValues.add(getHashValue(word)));
        return hashValues;

    }
    // gets the hash value of a function
    public static int getHashValue(String wordString){
        char []word = wordString.toCharArray();
        int s = word.length;
        int C = 123;
        int m = 293;
        int h = 0;

        for(int i = 0; i< s;i++){
            char ci = word[i];
            h = (h*C+ord(ci))%m;
        }
        return h; // change this later
    }

    // helpers
    public static boolean isValidChar(char c){
        boolean bool = false;
        if(
                (c >= 'a' && c <= 'z') ||
                        (c >= 'A' && c <= 'Z') ||
                        (c == '-') || (c == '\'' )){
            bool = true;
        }
        return bool;
    }
    public static String cleanString(String word){
        // get rid of all characters that are not (A-Z,a-z,-, or ')
        char[] wordCharArr = word.toCharArray();
        ArrayList<Character> validCharArr = new ArrayList<>();
        for(char aChar:wordCharArr){
            if(isValidChar(aChar)){
                validCharArr.add(aChar);
            }
        }
        String newWord = validCharArr.stream().map(Object::toString).collect(Collectors.joining());
        return newWord;
    }

    // ord: gets ASCII value of character by casting a char to an int
    public static int ord(char c){
        return (int) c;

    }


// we cant use this function since it runs on O(n) complexity
//    public static ArrayList<String> discardDuplicates( ArrayList<String> hashNames){
//        List<String> noDups = hashNames.stream().distinct().collect(Collectors.toList());
//        ArrayList<String> out = new ArrayList<>();
//        noDups.forEach((word)-> out.add(word));
//        return out;
//    }




}
