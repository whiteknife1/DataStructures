import java.util.EmptyStackException;
/**
 * Created by John Eberling on 11/15/16.
 */
public class MyStack <E>{
    private E[] data;
    private int size;

    public MyStack(){

        data = (E[]) new Object[5];
        size = 0;
    }

    private void resize(){
        E[] temp = (E[])new Object[2*size+1];
        for(int i=0; i<size; i++)
           temp[i] = data[i];
        data = temp;
    }

    public void push(E e){
        if(size == data.length) {
            resize();
        }
        data[size] = e;
        size++;
    }

    public E peek(){
        if(size == 0) throw new EmptyStackException();
        else return data[size-1];
    }

    public E pop(){
        if(size==0) throw new EmptyStackException();
        size--;
        return data[size-1];
    }

    public boolean isEmpty(){
        if(size == 0) return true;
        return false;
    }

    public int getSize(){
        return size;
    }
}
