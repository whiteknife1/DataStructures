import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by John Eberling on 1/13/17.
 */
public class SupermarketLineSimulator3 {
    private static Queue<Customer> line = new LinkedList<Customer>();
    private static int wait;

    public static void main(String[] args){
        final int TRIAL = 10000;
        int tempMaxWait, tempMaxLength;
        double tempAvgWait, avgWait = 0, avgMaxLength = 0, avgMaxWait = 0;
        Customer person;
        for(int k=0; k<TRIAL; k++){
            line = new LinkedList<>();
            wait = 0;
            tempMaxWait = 0;
            tempMaxLength = 0;
            tempAvgWait = 0;
            person = new Customer(wait);
            line.add(person);
            wait = person.getServiceTime();
            person.setEndTime(person.getStartTime() + person.getServiceTime());
            person = new Customer(0);
            for (int i = 1; i <= 720; i++) {
                if (wait > 0) {
                    wait--;
                }
                if (i == person.getStartTime()) {
                    //System.out.printf("Time: %d New customer arrived.%n", i);
                    line.add(person);
                    person.setEndTime(i + person.getServiceTime() + wait);
                    wait = wait + person.getServiceTime();
                    if (wait > tempMaxWait) {
                        tempMaxWait = wait;
                    }
                    person = new Customer(i);
                }

                if (!line.isEmpty() && i >= line.peek().getEndTime()) {
                    //System.out.printf("Time: %d Service complete. ", i);
                    line.remove();
                    /*if (line.size() > 0) {
                        System.out.printf("Next customer service ends at %d.%n", line.peek().getEndTime());
                    } else {
                        System.out.printf("Waiting for next customer to arrive.%n");
                    }*/
                }

                if (line.size() > tempMaxLength) {
                    tempMaxLength = line.size();
                }
                tempAvgWait += wait;
            }
            tempAvgWait /= 720;
            avgMaxWait += tempMaxWait;
            avgMaxLength += tempMaxLength;
            avgWait += tempAvgWait;
        }

        avgMaxWait /= TRIAL;
        avgMaxLength /= TRIAL;
        avgWait /= TRIAL;
        System.out.printf("%nThe average maximum line length was %.4f%n", avgMaxLength);
        System.out.printf("The average longest wait time for one customer was %.4f minutes%n", avgMaxWait);
        System.out.printf("The average wait time was %.4f minutes.%n", avgWait);
    }
}

class Customer{
    private int serviceTime;
    private int startTime;
    private int endTime;
    private Random rand = new Random();

    public Customer(int start){
        serviceTime = rand.nextInt(4)+1;
        startTime = start+rand.nextInt(4)+1;
    }

    public int getServiceTime(){
        return serviceTime;
    }

    public int getStartTime(){
        return startTime;
    }

    public void setEndTime(int end){ endTime = end; }

    public int getEndTime(){ return endTime; }
}