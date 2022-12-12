public class HashObject {
//    int key;
    String word;
    int value;

    // empty HashObject constructor
    HashObject(){
//        this.key = key;
        this.word = "";
        this.value = -1;
    }

    // filled object
    HashObject(String word, int value){
//        this.key = key;
        this.word = word;
        this.value = value;
    }
}
