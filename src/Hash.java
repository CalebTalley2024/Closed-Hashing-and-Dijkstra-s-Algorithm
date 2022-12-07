import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Hash {

    public static ArrayList<String> getText() throws FileNotFoundException {
        ArrayList<String> out = new ArrayList<>();
        File file = new File("EdgarAllanPoeBellsB2022groomed.txt");
        Scanner scan = new Scanner(file);
        while(scan.hasNext()){
            String word = scan.next();
            out.add(word);
//            System.out.println(word);

        }
        scan.close();
        return out;
    }

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
    public static String cleanTxt(String word){
        // get rid of all characters that are not (A-Z,a-z,-, or ')
        // commands from java api for regex
        // get rid of any characters that are NOT..... upper/lower case letter, - or '
//        word = word.replaceAll("( [^\\p{Alpha}]| [\\p{Digit}])","");
//        word = word.replaceAll("[^\\p{Alpha}]","");

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



}
