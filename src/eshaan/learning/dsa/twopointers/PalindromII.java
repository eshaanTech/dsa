package eshaan.learning.dsa.twopointers;

public class PalindromII {
    private static boolean checkValidPalindrom(String s, int left, int right){
        while(left<right){
            if(s.charAt(left)!=s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static boolean validPalindrome(String s){
        int left =0;
        int right = s.length()-1;
        while(left<right){
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }else if(s.charAt(left)!=s.charAt(right)){
                return (checkValidPalindrom(s, left+1, right) || checkValidPalindrom(s, left, right-1));
            }
        }
        return true;
    }
    public static void main (String []args){
        System.out.println(validPalindrome("abca"));
    }

}

