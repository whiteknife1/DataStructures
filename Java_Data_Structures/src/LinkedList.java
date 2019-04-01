/**
 * Created by John Eberling on 11/9/16.
 */
public class LinkedList {

    private Node head;
    private int size;

    public LinkedList(){
        head = null;
        size = 0;
    }

    public void addFirst(int data){
        if(head == null) head = new Node(data);
        else {
            Node current = new Node(data);
            current.setNext(head);
            head = current;
        }
        size++;
    }

    public void addLast(int data){
        if(head == null) head = new Node(data);
        else{
            Node current = head;
            while(current.next()!=null){
                current = current.next();
            }
            Node temp = new Node(data);
            current.setNext(temp);
        }
        size++;
    }

    public void showList(){
        Node current = head;
        while(current != null){
            System.out.printf("%d   ", current.getData());
            current = current.next();
        }
        System.out.println();
    }

    public int get(int pos){
        if(pos<0 || pos>= size) throw new IndexOutOfBoundsException();
        Node current = head;
        for(int i=0; i<pos; i++)
            current = current.next();
         return current.getData();
    }

    public void add(int pos, int data){
        if(pos<0 || pos>size) throw (new IllegalArgumentException("insert Position Out of Bounds."));
        Node temp = new Node(data);
        if(head == null && pos == 0) head = temp;
        else{
            Node current = head;
            if(pos == 0){
                temp.setNext(current);
                head = temp;
            }
            else{
                Node previous = current;
                current = current.next();
                for(int i=1; i<pos; i++){
                    previous = current;
                    current = current.next();
                }
                temp.setNext(current);
                previous.setNext(temp);
            }
        }
        size++;
    }

    public void clear(){
        head = null;
        size = 0;
    }

    public void addAll(int[] nums){
        for(int num: nums)
            addLast(num);
    }

    public LinkedList clone(){
        LinkedList linked = new LinkedList();
        Node current = head;
        while(current != null){
            linked.addLast(current.getData());
            current = current.next();
        }
        return linked;
    }

    public int getSize(){return size;}

    public boolean isEmpty(){return (size == 0);}

    public Node find(int target){
        Node current = head;
        while(current != null){
            if(current.getData() == target) return current;
            current = current.next();
        }
        return null;
    }

    public boolean contains(int target){
        Node current = head;
        while(current != null){
            if(current.getData()== target) return true;
            current = current.next();
        }
        return false;
    }

    public boolean remove(int target){
        if(head == null) return false;
        if(head.getData()==target){
            head = head.next();
            size--;
            return true;
        }
        Node previous = head;
        Node current = head.next();
        while(current != null && current.getData() != target){
            previous = current;
            current = current.next();
        }
        if(current == null) return false;
        previous.setNext(current.next());
        size--;
        return true;
    }

    public void addAllThese(int ... data){
        for(int num: data) addLast(num);
    }
}
