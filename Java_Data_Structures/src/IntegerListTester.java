/**
 * Created by John Eberling on 11/9/16.
 */

public class IntegerListTester{

    public static void main(String[] args){
        IntegerList list = new IntegerList();
        for(int i=0; i<10; i++){
            list.add(i);
        }
        showList(list);
        list.add(3, 55);
        showList(list);
        list.add(11, 23);
        showList(list);
        list.add(0, 34);
        showList(list);
        Integer remove = list.remove(2);
        showList(list);
        list.remove(0);
        showList(list);
        Integer a=list.remove(list.size()-1);
        showList(list);
        Integer b=list.set(4, 15);
        showList(list);
        System.out.println(a);
        System.out.println(b);

    }

    public static void showList(IntegerList list){
        for(int i=0; i<list.size(); i++){
           System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
}