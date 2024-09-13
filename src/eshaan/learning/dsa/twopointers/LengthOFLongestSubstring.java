package eshaan.learning.dsa.twopointers;

import java.util.HashMap;
import java.util.Map;

public class LengthOFLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        int left = 0;
        int max = 0;
        for(int right=0; right<s.length();right++){
            char c = s.charAt(right);
            if(map.containsKey(c)){
                left = Math.max(left, map.get(c)+1);
            }
            map.put(c, right);
            max=Math.max(max, right-left+1);
        }
        return max;

    }
    public static void main(String[] args) {
        LengthOFLongestSubstring ls = new LengthOFLongestSubstring();
        String input = "abba";
        int result = ls.lengthOfLongestSubstring(input);
        System.out.println("Length of the longest substring without repeating characters: " + result);
    }

}
