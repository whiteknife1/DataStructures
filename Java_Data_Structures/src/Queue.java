import com.sun.corba.se.spi.orbutil.threadpool.NoSuchWorkQueueException;

/**
 * Created by john_eberling on 1/11/17.
 */
public class Queue<E>{
    private E[] data;
    private int size;
    private int front;
    private int back;

    public Queue(E[] data){
        size = 0;
        this.data = data;
        front = 0;
        back = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size==0;
    }

    public E peek() throws Exception{
       if(isEmpty()){
           throw new Exception("Queue is empty.");
       }
       else {
           int temp = front;
           front++;
           return data[temp];
       }
    }

    public E dequeue() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is empty");
        }
        else {
            int temp = front;
            front++;
            size--;
            return data[temp];
        }
    }
    public void enqueue(E obj){
        if(back>0 && back == data.length){
            resize();
        }
        data[back] = obj;
        size++;
        back++;
    }

    public void resize(){
        E[] temp = (E[]) new Object[data.length*2];
        int pos = 0;
        for(int i=front; i<back; i++){
            temp[pos] = data[i];
            pos++;
        }
        front = 0;
        back = pos;
        data = temp;
    }

    public void show(){
        System.out.print("[");
        for(int i = front; i< back; i++){
            System.out.printf("%-4s", data[i]);
        }
        System.out.printf("]/n");
    }
}
