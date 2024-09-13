package eshaan.learning.dsa.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutation {
    List<List<Integer>> result=new ArrayList<>();
    int n=0;
    Set<Integer> set = new HashSet<>();
    public List<List<Integer>> permute(int[] nums) {
        n=nums.length;
        backtrack(nums, new ArrayList());
        return result;
    }
    private void backtrack(int[] nums, ArrayList<Integer>currentSet){
        if(currentSet.size()==nums.length){
            result.add(new ArrayList(currentSet));
        }
        for(int i=0; i<n; i++){
            if(set.contains(nums[i]))
                continue;
            currentSet.add(nums[i]);
            set.add(nums[i]);
            backtrack(nums, currentSet);
            currentSet.remove(currentSet.size()-1);
            set.remove(nums[i]);
        }

    }
    public static void main(String[] args){
        Permutation c = new Permutation();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = c.permute(nums);
        for(List r : result){
            System.out.println(r);
        }
    }
}
