import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Hashing {

    public static String Poe = "EdgarAllanPoeBellsB2022groomed.txt";
    public static String Raven = "RavenD2020.txt";
    public static List<String> txtToArrayList (String name ) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("/path/to/file.txt"));
        return lines;
    }

    public static ArrayList<HashObject> getWordsAndValues(String txtFile) throws FileNotFoundException {
        ArrayList<String> words = getHashedWords(txtFile);
        ArrayList<Integer> vals = getHashValues(words);
        // WV: words and values
        ArrayList<HashObject> WV = new ArrayList<>();
        for(int i = 0; i<words.size();i++){
            //HO: hash object
            HashObject HO = new HashObject(words.get(i),vals.get(i));
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

    // helpers
    public static boolean isValidChar(char c){
        boolean bool = false;
//        if(
//                (c >= 'a' && c <= 'z') ||
//                        (c >= 'A' && c <= 'Z') ||
//                        (c == '-') || (c == '\'' )){
//            bool = true;
//        }
        // this if statement only applies to RAVEN
        if(
                (c >= 'a' && c <= 'z') ||
                        (c >= 'A' && c <= 'Z') || (c == '\'' )){
            bool = true;
        }
        return bool;
    }

    // get rid of all characters that are not (A-Z,a-z,-, or ')
    public static String cleanString(String word){
        // get rid of all characters that are not (A-Z,a-z,-, or ')
        char[] wordCharArr = word.toCharArray();
        ArrayList<Character> validCharArr = new ArrayList<>();
        for(char aChar:wordCharArr){
            if(isValidChar(aChar)){
                validCharArr.add(aChar);
            }
        }
//        String newWord = validCharArr.toString();
        String newWord = validCharArr.stream().map(Object::toString).collect(Collectors.joining());
        return newWord;
    }

    // ord: gets ASCII value of character by casting a char to an int
    public static int ord(char c){
        return (int) c;

    }
    public static int getHashValue(String wordString){
        char []word = wordString.toCharArray();
        int s = word.length;
        int C = 123;
        int testM = 1000;
        int m = 293;
        int h = 0;

        for(int i = 0; i< s;i++){
            char ci = word[i];
            h = (h*C+ord(ci))%m;
        }
        return h; // change this later
    }


}
