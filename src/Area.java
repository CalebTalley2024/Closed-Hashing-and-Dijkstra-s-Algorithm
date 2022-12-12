public class Area {
    int count;
    int start;
    int end;
    Area(int start){
        this.count = 0;
        this.start = start;
        this.end = -1;}

    public void set(int newCount, int end){
        this.count = newCount;
        this.end = end;
    }
}
