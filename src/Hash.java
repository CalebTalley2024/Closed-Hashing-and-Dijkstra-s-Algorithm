import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Hash {

    public static Hashtable<Integer,Integer> setHashTable(List<Integer> uniqueHashValues){
        int sizeHashTable = 293;
        float loadFactor = 0.5f;
//        List<Integer> hashValuesND = discardDuplicates(hashValues);
        Hashtable<Integer,Integer> hashTable = new Hashtable<>(sizeHashTable,loadFactor);
        for(int i =0; i<sizeHashTable;i++){
            hashTable.put(i,uniqueHashValues.get(i));

        }
        return hashTable;
    }

    public static ArrayList<String> getHashedWords() throws FileNotFoundException {
        // in: our original txt file as a list of strings
        ArrayList<String> in = new ArrayList<>();
        File file = new File("EdgarAllanPoeBellsB2022groomed.txt");
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

    public static ArrayList<String> discardDuplicates( ArrayList<String> hashNames){
        List<String> noDups = hashNames.stream().distinct().collect(Collectors.toList());
        ArrayList<String> out = new ArrayList<>();
        noDups.forEach((word)-> out.add(word));
        return out;
    }




}
