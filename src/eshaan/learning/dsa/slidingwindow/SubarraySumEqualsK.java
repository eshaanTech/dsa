package eshaan.learning.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        //create map to hold the frequency of prefix sum
        //iterate thry the elements on the array
        //check if prefix sum - k exists in the map, if it does add 1 to the count
        //add new prefix sume to the map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        frequencyMap.put(0, 1);
        int count =0;
        int prefixSum = 0;
        for(int num: nums){
            prefixSum+=num;
            if(frequencyMap.containsKey(prefixSum-k)){
                count+=frequencyMap.getOrDefault(prefixSum, 0)+1;
            }
            frequencyMap.put(prefixSum, frequencyMap.getOrDefault(prefixSum, 0)+1);
        }
        return count;

    }
}
