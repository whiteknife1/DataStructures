/**
 * Created by John Eberling on 11/10/16.
 */
public class LinkedListTester {
    public static void main(String[] args){
        GenericLinkedList<Integer> list = new GenericLinkedList();
        list.addAllThese(11, 12, 13, 14, 15, 16);
        list.showList();
        list.clone();
        list.showList();
        if(list.contains(12)) System.out.println("works");
        list.remove(12);
        if(!list.contains(12)) System.out.println("works");
        list.add(3, 12);
        if(list.contains(12)) System.out.println("works");
        System.out.println(list.find(12).getData());
        System.out.println(list.find(22));
        System.out.println(list.get(1));
        list.clear();
        list.showList();
    }
}
