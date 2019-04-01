/**
 * Created by John Eberling on 11/9/16.
 */
public class Node {
   private int data;
    private Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }

    public Node next(){
        return this.next;
    }

    public int getData(){
        return this.data;
    }

    public void setNext(Node next){
        this.next=next;
    }

    public void setData(int data){
        this.data = data;
    }
}


