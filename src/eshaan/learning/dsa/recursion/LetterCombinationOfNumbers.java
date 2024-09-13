package eshaan.learning.dsa.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationOfNumbers {
    private static final Map<Character, String>map = new HashMap<>();
    static {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits==null || digits.length()==0)
            return result;
        backtrack(digits, result, 0, new StringBuilder());
        return result;
    }
    //ex: 23
    private void backtrack(String digits, List<String> result, int index, StringBuilder currentString){
        if(index==digits.length()){
            result.add(currentString.toString());
            return;
        }
        //get the letters of current digit from the map
        String letters = map.get(digits.charAt(index));
        //iterate thru the letters
        for(char letter : letters.toCharArray()){
            //add the letter to current String
            currentString.append(letter);
            backtrack(digits, result, index+1, currentString);
            currentString.deleteCharAt(currentString.length()-1);
        }
    }
    public static void main(String[] args) {
        LetterCombinationOfNumbers solution = new LetterCombinationOfNumbers();
        String input = "23";
        List<String> combinations = solution.letterCombinations(input);
        System.out.println(combinations);
    }


}
