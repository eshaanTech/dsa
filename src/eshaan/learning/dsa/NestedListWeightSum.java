package eshaan.learning.dsa;

import java.util.List;

interface NestedInteger {
    // Returns true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();
    // Returns the single integer that this NestedInteger holds, if it holds a single integer.
    // Returns null if this NestedInteger holds a nested list.
    public Integer getInteger();
    // Returns the nested list that this NestedInteger holds, if it holds a nested list.
    // Returns null if this NestedInteger holds a single integer.
    public List<NestedInteger> getList();
}
public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList==null){
            return 0;
        }
        return depthSum(nestedList, 1);
    }
    private int depthSum(List <NestedInteger> nestedList, int depth){
        int sum=0;
        for(NestedInteger ni : nestedList){
            if(ni.isInteger()){
                sum+=ni.getInteger() * depth;
            }else{
                sum += depthSum(ni.getList(), depth+1);
            }
        }
        return sum;

    }
}
