package eshaan.learning.dsa.slidingwindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*
Input: s = "abcabcbb"
s = "aa" "aab"
Output: 3
Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        HashMap<Character, Integer> idxMap = new HashMap<>();
        int maxLength = 0;
        int n = s.length();
        int l=0;
        for(int i=0;  i<n; i++){
            char c = s.charAt(i);
            if(idxMap.containsKey(c)){
                int idx = idxMap.get(c);
                maxLength = Math.max(maxLength, i-idx+1);
                l=i+1;
                idxMap.remove(c);
            }else{
                idxMap.put(c, i);
            }

        }
        return maxLength;
    }

    public int lengthOfLongestSubstringBruteForce(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        Set<Character>set = new HashSet<>();
        int left = 0, right =0;
        int maxLength=0;
        while(right<s.length()){
            if(!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                maxLength = Math.max(maxLength, set.size());
                right++;
            }else{
                set.remove(s.charAt(left));
                left++;
            }
        }

        return maxLength;
    }
    public static void main (String [] args){
        String s = "bbbbb";
        LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
        int maxCount = ls.lengthOfLongestSubstringBruteForce(s);
        System.out.println(maxCount);

    }
}
