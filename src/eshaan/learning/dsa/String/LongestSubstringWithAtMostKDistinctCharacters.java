package eshaan.learning.dsa.String;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s==null || s.length()==0 || k==0)
            return 0;

        int start=0;
        int maxLength=0;
        int n=s.length();
        Map<Character, Integer> map = new HashMap<>();
        for(int end=0; end<n; end++){
            char endChar = s.charAt(end);
            int freq = map.getOrDefault(endChar, 0);
            map.put(s.charAt(end), freq+1);
            //get the size of the map
            while(map.size()>k){
                //shring the window
                char startChar = s.charAt(start);
                map.put(startChar, map.get(startChar)-1);//decrese the frequency count
                if(map.get(startChar)==0){
                    map.remove(startChar);
                }
                start++;
            }
            //update max length
            maxLength = Math.max(maxLength, end-start+1);
        }
        return maxLength;
    }
    public static void main(String[] args) {
        LongestSubstringWithAtMostKDistinctCharacters solution = new LongestSubstringWithAtMostKDistinctCharacters();
        String str = "aabce";
        int k = 2;
        System.out.println(solution.lengthOfLongestSubstringKDistinct(str, k));  // Output: "56088"
    }
}
