package eshaan.learning.dsa.String;
/*
-compute LPS Array - LPS = longest prefix which is also suffix
-initialize variables
    -two pointer to traverse text and pattern
-travers the text to match pattern while i<textLength
    -if character match implement both pointers
    -if the entire pattern is matched return the starting index of j
    -if mismatch occurs after j matches, use the lps array to avoid redundant comparisons
        -jump back to previous index of LPS array
        -if j is at the beginning of the pattern, move it to next index
-if no match found return -1
*/
public class KMPAlgorithm {
    public int kmp(String text, String pattern){
        int[] lps = computeLPS(pattern);
        int textLength = text.length();
        int patternLength = pattern.length();
        int i=0;
        int j=0;
        while(i<textLength){
            if(pattern.charAt(j)==text.charAt(i)){
                i++;
                j++;
            }
            if(j==patternLength){
                return i-j;
            }else if(i<textLength && pattern.charAt(j)!=text.charAt(i)){
                if(j!=0){
                    j=lps[j-1];
                }else{
                    i++;
                }
            }
        }
        return -1;
    }
    private int[] computeLPS(String pattern){
        int n = pattern.length();
        int[] lps = new int[n];
        int len = 0; //length of previous longest prefix
        int i=1; //start checking from the second index, first index will be 0;
        while(i<n){
            if(pattern.charAt(i)==pattern.charAt(len)){
                len++;//increament length
                lps[i]=len;//store the length of matching prefix to lps
                i++;
            }else{
                if(len!=0){//if there is no match check the previous prefix
                    len=lps[len-1];//use the lps value to avoid redundant check
                }else{//else there is no match, set the lps[i] to 0
                    lps[i]=0;//and move to the next character
                }
            }
        }
        return lps;
    }
}
