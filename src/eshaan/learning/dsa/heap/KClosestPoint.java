package eshaan.learning.dsa.heap;

import java.util.PriorityQueue;

public class KClosestPoint {
    public int[][] kClosest(int[][] points, int k) {
        if(points==null){
            return null;
        }
        //define max heap
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(distanceSquared(b), distanceSquared(a)));
        for(int[] point: points){
            heap.add(point);
            if(heap.size()>k){
                heap.poll();
            }
        }
        //extract the k-closests point from the heap
        int[][] result = new int[k][2];
        for(int i=0; i<k; i++){
            result[i]=heap.poll();
        }
        return result;

    }
    int distanceSquared(int[] point){
        return((point[0]*point[1])+(point[1]*point[1]));
    }
}
