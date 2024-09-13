package eshaan.learning.dsa.slidingwindow;

import java.util.HashMap;
import java.util.Map;
/*
Approach:
    1-create a hashmap of target character and their frequencies, create requireCount variable that represnts number of match required
    2-point left pointer to 0 and right pointer to 0. Initialize the vairable minWinddowSize to Integer.MAX_VALUE,
    3-traverse thru the string s - one character at a time: while(right<s,length())
        -get the character s.charAt(right
        -check if the character exists in the targetStringMap
        -if no, increment right++
        -yes:
            -decrement required count
            -decrement the frequency from targetStringMap
            -check and do while requiredCount==0
                -calculate current window size = right-start_i+1
                -calculate minWindowSize = min(minWindowSize, currentWindowSize
                -set the start_i to demark start of new window
                -decreament windowSize by incrementing left++;
            -if required count>0
                -hold the left pointer and move the right pointer
 */

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Frequency map for t
        Map<Character, Integer> targetCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int need = t.length(); // Number of characters still needed to complete the window

        while (right < s.length()) {
            char cRight = s.charAt(right);
            right++;

            // If the character is in targetCount, we process it
            if (targetCount.containsKey(cRight)) {
                targetCount.put(cRight, targetCount.get(cRight) - 1);
                // Only reduce the need if the character count is non-negative
                if (targetCount.get(cRight) >= 0) {
                    need--;
                }
            }

            // When need == 0, we have a valid window that contains all characters in t
            while (need == 0) {
                // Update the minimum window length and start position
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                char cLeft = s.charAt(left);
                left++;

                // If the character is in targetCount, adjust the need and the count
                if (targetCount.containsKey(cLeft)) {
                    targetCount.put(cLeft, targetCount.get(cLeft) + 1);
                    // Only increase the need if the count goes positive
                    if (targetCount.get(cLeft) > 0) {
                        need++;
                    }
                }
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);

    }
    public static void main(String[] args) {
        MinimumWindowSubstring solution = new MinimumWindowSubstring();

        // Example 1
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println("Minimum window substring: " + solution.minWindow(s1, t1));
        // Output: "BANC"

        // Example 2
        String s2 = "a";
        String t2 = "a";
        System.out.println("Minimum window substring: " + solution.minWindow(s2, t2));
        // Output: "a"

        // Example 3
        String s3 = "a";
        String t3 = "aa";
        System.out.println("Minimum window substring: " + solution.minWindow(s3, t3));
        // Output: ""
    }
}
