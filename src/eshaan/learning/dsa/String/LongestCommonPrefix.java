package eshaan.learning.dsa.String;

public class LongestCommonPrefix {
    /*
    Steps:
    get the first string from the array
    iterate until end of the string
    compare each character of the first string with characters on the same index of other strings
    if they dont match, return the substring(0, i) of the first string
     */
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length==0)
            return "";
        String firstString = strs[0];
        for(int i=0; i<firstString.length(); i++){
            char c = firstString.charAt(i);
            for(int j = 1; j<strs.length; j++){
                if(strs[j].length() == i || strs[j].charAt(i)!=c){
                    return firstString.substring(0, i);
                }
            }
        }
        return firstString;
    }
}
