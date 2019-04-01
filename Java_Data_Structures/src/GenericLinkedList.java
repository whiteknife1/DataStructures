/**
 * Created by John Eberling on 11/14/16.
 */
public class GenericLinkedList<E> {
    private Node1 head;
    private int size;

    public GenericLinkedList(){
        head = null;
        size = 0;
    }

    public void addFirst(E data){
        if(head == null) head = new Node1(data);
        else {
            Node1 current = new Node1(data);
            current.setNext(head);
            head = current;
        }
        size++;
    }

    public void addLast(E data){
        if(head == null) head = new Node1(data);
        else{
            Node1 current = head;
            while(current.next()!=null){
                current = current.next();
            }
            Node1 temp = new Node1(data);
            current.setNext(temp);
        }
        size++;
    }

    public void showList(){
        Node1 current = head;
        while(current != null){
            System.out.printf("%s   ", (E)current.getData());
            current = current.next();
        }
        System.out.println();
    }

    public E get(int pos){
        if(pos<0 || pos>= size) throw new IndexOutOfBoundsException();
        Node1 current = head;
        for(int i=0; i<pos; i++)
            current = current.next();
        return (E) current.getData();
    }

    public void add(int pos, E data){
        if(pos<0 || pos>size) throw (new IllegalArgumentException("insert Position Out of Bounds."));
        Node1 temp = new Node1(data);
        if(head == null && pos == 0) head = temp;
        else{
            Node1 current = head;
            if(pos == 0){
                temp.setNext(current);
                head = temp;
            }
            else{
                Node1 previous = current;
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

    public void addAll(E[] nums){
        for(E num: nums)
            addLast(num);
    }

    public GenericLinkedList clone(){
        GenericLinkedList linked = new GenericLinkedList();
        Node1 current = head;
        while(current != null){
            linked.addLast(current.getData());
            current = current.next();
        }
        return linked;
    }

    public int getSize(){return size;}

    public boolean isEmpty(){return (size == 0);}

    public Node1 find(E target){
        Node1 current = head;
        while(current != null){
            if(current.getData() == target) return current;
            current = current.next();
        }
        return null;
    }

    public boolean contains(E target){
        Node1 current = head;
        while(current != null){
            if(current.getData()== target) return true;
            current = current.next();
        }
        return false;
    }

    public boolean remove(E target){
        if(head == null) return false;
        if(head.getData()==target){
            head = head.next();
            size--;
            return true;
        }
        Node1 previous = head;
        Node1 current = head.next();
        while(current != null && current.getData() != target){
            previous = current;
            current = current.next();
        }
        if(current == null) return false;
        previous.setNext(current.next());
        size--;
        return true;
    }

    public void addAllThese(E ... data){
        for(E num: data) addLast(num);
    }
}

class Node1 <E> {
    private E data;
    private Node1 next;

    public Node1(E data){
        this.data = data;
        this.next = null;
    }

    public Node1 next(){
        return this.next;
    }

    public E getData(){
        return this.data;
    }

    public void setNext(Node1 next){
        this.next=next;
    }

    public void setData(E data){
        this.data = data;
    }
}

