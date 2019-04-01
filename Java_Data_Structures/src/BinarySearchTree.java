
/**
 * Created by John Eberling on 2/6/17.
 */
public class BinarySearchTree {
    private Node2 root;

    public BinarySearchTree(){

    }

    public void add(int key){
        if(root == null)
            root = new Node2(key);
    }
}

class Node2{
    int key;
    Node2 left;
    Node2 right;

    public Node2(){
        left = null;
        right = null;
    }

    public Node2(int key){
        this.key = key;
    }

}
