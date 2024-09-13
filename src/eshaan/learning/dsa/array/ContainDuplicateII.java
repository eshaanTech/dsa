package eshaan.learning.dsa.array;
import java.util.HashSet;
import java.util.Set;

public class ContainDuplicateII {
    public boolean containDuplicate(int[]nums, int k){
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            if(set.contains(i)){
                return true;
            }
            set.add(i);
            if(set.size()>i-k){
                set.remove(i);
            }
        }
        return false;
    }
}
