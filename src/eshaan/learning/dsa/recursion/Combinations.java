package eshaan.learning.dsa.recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    List<List<Integer>>result= new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        ArrayList<Integer> currResult = new ArrayList<>();
        solve(1, n, k, currResult);
        return result;
    }
    void solve(int start, int n, int k, ArrayList<Integer>currResult){
        if(k==0){
            result.add(new ArrayList<>(currResult));
            return;
        }
        if(start>n){
            return;
        }
        currResult.add(start);
        solve(start+1, n, k-1, currResult);
        currResult.remove(currResult.size()-1);
        solve(start+1, n, k, currResult);
    }

    public static void main(String[] args){
        Combinations c = new Combinations();
        List<List<Integer>> result = c.combine(4, 2);
        for(List r : result){
            System.out.println(r);
        }
    }
}
