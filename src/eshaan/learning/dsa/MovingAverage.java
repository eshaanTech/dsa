package eshaan.learning.dsa;

import java.util.ArrayDeque;
import java.util.Deque;

public class MovingAverage {
    int count = 0;
    int size = 0;
    int windowSum = 0;
    Deque<Integer>deque = new ArrayDeque<Integer>();
    public MovingAverage(int size) {
        this.size =  size;
    }
    public double next(int val) {
        count++;
        deque.add(val);
        //check the size of the queue, and pop if the size is smaller then the count
        int tail=0;
        if(count>size){
            tail = deque.poll();
        }
        windowSum = windowSum - tail + val;
        return (windowSum*1.0)/Math.min(count, size);

    }
}
