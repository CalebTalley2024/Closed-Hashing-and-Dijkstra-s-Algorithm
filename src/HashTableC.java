import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

public class HashTableC {

    // constructor
    ArrayList<HashObject> table;
    HashTableC(){
        this.table = new ArrayList<>();
    }

    public void question3() throws FileNotFoundException {
        int m = 1000;
        String txtFile = Hashing.Raven;
        this.initHT(m);
        this.setHashTableC(txtFile,m);

        getNumFilledAddresses();
    }
    public  void questions12() throws FileNotFoundException {
        // change these two values to work on test and actual text files
        int m = 1000;
        String txtFile = Hashing.Raven;
        this.initHT(m);
        this.setHashTableC(txtFile,m);
//        this.printHTable();



    }
    public void getLongestEmptyArea(){
        ArrayList<HashObject> HT = this.table;
        int m = HT.size();
        ArrayList<Area> areas = new ArrayList<>();
        // iterate though HT
        for (int i  = 0; i<m; i++){
            int aValue = HT.get(i).value;

            // nested for loop when you find a value of -1
            if(aValue == -1){
                Area anEmptyArea = new Area(i);
                int newCount = anEmptyArea.count;
                int newEnd = anEmptyArea.end;

                for(int j = i; j<m;j++){
                    if(j==m){
                        System.out.println("circled cluster");
                        for(int k = j%m; k<i;k++){
                            int areaValueCircled =   HT.get(k).value;
                            if(areaValueCircled != -1){
                                newCount++;

                            }
                            // once you reach the end of an empty area, add that area to your arrayList and set up the i index
                            else{
                                newEnd = k-1;
                                anEmptyArea.set(newCount,newEnd);
                                areas.add(anEmptyArea);
                                // at the end of an Circled Area, return one index above where you started to keep on track
                                i = j+1;
                                break;
                            }
//                            break;
                        }
                    }
                    else {


                        int areaValue = HT.get(j).value;
                        if (areaValue == -1) {
                            newCount++;

                        }
                        // once you reach the end of an empty area, add that area to your arrayList and set up the i index
                        else {
                            newEnd = j - 1;
                            anEmptyArea.set(newCount, newEnd);
                            areas.add(anEmptyArea);
                            // at the end of an Area, change the index so that we dont overlap
                            i = newEnd;
                            break;
                        }
                    }
                }
            }
        }
        Area maxArea = this.getLargestArea(areas);
        int runSize = maxArea.count;
        int maxStart = maxArea.start;
        int maxEnd = maxArea.end;
        System.out.println("The longest run of open cells is " + runSize + " entries long:");
        System.out.println("One of these runs:");
        System.out.printf("Position %d ",maxStart);
        System.out.printf("to position %d (inclusive)",maxEnd);

//        System.out.println(areas.size());
    }

    public void getFartestWord(){
        ArrayList<HashObject> HT = this.table;
        int m = HT.size();


    }

    public void getLongestCluster() {
        ArrayList<HashObject> HT = this.table;
        int m = HT.size();
        ArrayList<Area> areas = new ArrayList<>();
        // iterate though HT
        for (int i  = 0; i<m; i++){
            HashObject HO = HT.get(i);
            int aValue = HO.value;

            // nested for loop when you find a value of -1
            if(aValue != -1){
                Area aCluster = new Area(i);
                int newCount = aCluster.count;
                int newEnd = aCluster.end;
                for(int j = i; j<m+1;j++){
                    // if j reaches the end of the list, then use modulo and new index k to circle back the index 0
                    if(j==m){
                        System.out.println("circled cluster");
                        for(int k = j%m; k<i;k++){
                            int areaValueCircled =   HT.get(k).value;
                            if(areaValueCircled != -1){
                                newCount++;

                            }
                            // once you reach the end of an empty area, add that area to your arrayList and set up the i index
                            else{
                                newEnd = k-1;
                                aCluster.set(newCount,newEnd);
                                areas.add(aCluster);
                                // at the end of an Circled Area, return one index above where you started
                                i = j+1;
                                break;
                            }
//                            break;
                        }
                    }
                    else{
                        int areaValue =   HT.get(j).value;
                        if(areaValue != -1){
                            newCount++;

                        }
                        // once you reach the end of an empty area, add that area to your arrayList and set up the i index
                        else{
                            newEnd = j - 1;
                            aCluster.set(newCount,newEnd);
                            areas.add(aCluster);
                            // at the end of an Area, change the index so that we dont overlap
                            i = newEnd;
                            break;
                        }
                    }

                }
            }
//            System.out.println("j");
        }
        Area maxArea = this.getLargestArea(areas);
        int runSize = maxArea.count;
        int maxStart = maxArea.start;
        int maxEnd = maxArea.end;
        System.out.println("The longest cluster is " + runSize + " entries long:");
        System.out.println("One of these runs:");
        System.out.printf("Position %d ",maxStart);
        System.out.printf("to position %d (inclusive)",maxEnd);
    }
    //    }
    public Area getLargestArea(ArrayList<Area> areas){
        int size = areas.size();
        int largestA = 0;
        int largestAIndex = 0;
        for(int i = 0; i<size;i++){
            if(areas.get(i).count > largestA){
                largestAIndex = i;
                largestA = areas.get(i).count;
            }
        }
        Area largestArea = areas.get(largestAIndex);
        return largestArea;
    }
    public void getMostDistinctHashValue(){
        ArrayList<HashObject> HT = this.table;
        int m = HT.size();
        //mcVal: most common value

        // make array

        int[] hashValues = new int[m];
        //each entry is a counter for how many times the index number has appeared in the HT

        for(int i = 0; i<m;i++){
            int aHValue = HT.get(i).value;
            if(aHValue != -1){
                // each index is used to place amount of times a hashValue occurs
                hashValues[aHValue]++;
            }
        }
        int mcValCount = 0;
        int mcVal = -1;
        // check which number has the largest size
        for(int j = 0; j<hashValues.length;j++){
            if(hashValues[j]> mcValCount){
                mcValCount = hashValues[j];
                mcVal = j;
            }
        }
        System.out.println();
        System.out.println("The Most Common Hash Value " + mcVal +" occurs "+mcValCount);
        // return number and size/how many you have
//        return mcVal;
    }
    public int getNumFilledAddresses(){
        ArrayList<HashObject> HT = this.table;
        int m = HT.size();
        int counter = 0;
        for(int i =0; i< m; i++){
            HashObject aHO = HT.get(i);
            // if the value is not empty (-1), increase the counter
            if(aHO.value != -1){
                counter++;
            }
        }
        float alpha = (float) counter/m;
        System.out.println();
        System.out.println("There are " + counter +" distinct entries in the hash table.");
        System.out.println("This means that our load factor is " + alpha + " for our hash table");
        return counter;

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
    //  getValid Key: get valid Key for hash value, casade down the hashmap if need. Also checks for duplicates
    public static int getValidKey(HashObject HO, ArrayList<HashObject> HT, int keyIncrement,int sizeHT){
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
}
