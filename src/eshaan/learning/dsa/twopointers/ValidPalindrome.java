package eshaan.learning.dsa.twopointers;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        //replace all non alphanumeric chars from the string and convert them to lower case
        String normalizedString = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        System.out.println(normalizedString);
        //pointers
        int left=0;
        int right = normalizedString.length()-1;
        //Palindrome Check
        while(left<right){
            if(normalizedString.charAt(left)!=normalizedString.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static void main(String[] args){
        ValidPalindrome vp = new ValidPalindrome();
        System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
