import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class txtToList {
    public static List<String> txtToArrayList (String name ) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("/path/to/file.txt"));
        return lines;
    }


    public txtToList() throws IOException {

    }
}
