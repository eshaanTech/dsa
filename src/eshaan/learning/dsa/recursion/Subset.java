package eshaan.learning.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;

    }
    private void backtrack(int[] nums, int index, List<Integer>currentSet, List<List<Integer>>result){
        result.add(new ArrayList<>(currentSet));
        for(int i=index; i< nums.length; i++){
            currentSet.add(nums[i]);
            backtrack(nums, i, currentSet, result);
            currentSet.remove(currentSet.size()-i);

        }

    }
    public static void main(String[] args){
        Subset c = new Subset();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = c.subsets(nums);
        for(List r : result){
            System.out.println(r);
        }
    }

}
