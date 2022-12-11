public class Vertex {

    char node;
    int  d;
    //penultimate vertex
    char pNode;
//    boolean transversed;

    public Vertex(char node, int d,char pNode){
        this.node = node;
        this.d = d;
        this.pNode = pNode;
//        this.transversed = transversed;

    }
    // Vertex for Queue
    public Vertex(char node, int d){
        this.node = node;
        this.d = d;
    }

    public void  printVertex(){
        System.out.println("[" + this.node+", "+this.d+", "+this.pNode + "]");
        //", "+ this.transversed+
    }

}
