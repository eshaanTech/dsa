package eshaan.learning.dsa.String;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        int start=0;
        int end=s.length()-1;
        while(start<=end){
            if(isValid(s.charAt(start)) && isValid(s.charAt(end))){
                if(Character.toLowerCase(s.charAt(start)) == Character.toLowerCase(s.charAt(end))){
                    start++;
                    end--;
                }else{
                    return false;
                }
            }else if(!isValid(s.charAt(start))){
                start++;
            }else{
                end--;
            }
        }
        return true;


    }
    private boolean isValid(char c){
        return (Character.isLetterOrDigit(c));
    }
    public static void main(String [] args){
        String s = "0P";
        IsPalindrome ip = new IsPalindrome();
        System.out.println(ip.isPalindrome(s));

    }
}
