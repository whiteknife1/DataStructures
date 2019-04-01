/**
 * Created by John Eberling on 11/9/16.
 */
public class IntegerList {

    private Integer[] list;
    private int size;

    public IntegerList(){
        size = 0;
        list = new Integer[2];
    }

    public void updateSize(){
        Integer[] list1 = new Integer[list.length*2+1];
        for(int i=0; i<list.length; i++){
            list1[i] = list[i];
        }
        list = list1;
    }

    public void add(Integer num){
        if(size == list.length) updateSize();
        list[size] = num;
        size++;
    }

    public void add(int pos, Integer num){
        if(pos<0 || pos>size)
            throw (new IndexOutOfBoundsException());
        size++;
        if(size == list.length)
            updateSize();
        int i=size;
        while(i>pos){
            list[i] = list[i-1];
            i--;
        }
        list[i] = num;
    }

    public Integer get(int pos){
        return list[pos];
    }

    public Integer remove(int pos){
        if(pos<0 || pos>size)
            throw (new IndexOutOfBoundsException());
        Integer temp = list[pos];
        int i=pos;
        while(i<size){
            list[i] = list[i+1];
            i++;
            if(i==size) list[i] = null;
        }
        size--;
        return temp;
    }

    public Integer set(int pos, Integer num){
        Integer temp = list[pos];
        list[pos] = num;
        return num;
    }

    public int size(){
        return size;
    }
}
