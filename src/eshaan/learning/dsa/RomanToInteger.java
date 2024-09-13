package eshaan.learning.dsa;
import java.util.HashMap;
import java.util.Map;
public class RomanToInteger {
    private static Map<Character, Integer> map = new HashMap<Character, Integer>();
    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }
    public int romanToInt(String s) {
        int total=0;
        int n=s.length()-1;
        int prevValue=0;
        for(int i=n; i>=0; i--){
            char currecntChar = s.charAt(i);
            int currNumber = map.get(currecntChar);
            //if curr less than prev, subtract, if equal or greater add
            if(currNumber<prevValue){
                total=total-currNumber;
            }else{
                total=total+currNumber;
            }
            prevValue = currNumber;
        }
        return total;
    }
}
