package eshaan.learning.dsa.String;

public class ValidAbbreviation {
    public static boolean isValidAbbreviation(String word, String abbr) {
        int i = 0;  // Pointer for word
        int j = 0;  // Pointer for abbr

        while (i < word.length() && j < abbr.length()) {
            if (Character.isDigit(abbr.charAt(j))) {
                // If the abbreviation starts with '0', it's invalid
                if (abbr.charAt(j) == '0') {
                    return false;
                }
                int num = 0;
                // Calculate the number from the abbreviation
                while (j < abbr.length() && Character.isDigit(abbr.charAt(j))) {
                    num = num * 10 + (abbr.charAt(j) - '0');
                    j++;
                }
                // Move the word pointer by the number
                i += num;
            } else {
                // Check if the current characters match
                if (i >= word.length() || word.charAt(i) != abbr.charAt(j)) {
                    return false;
                }
                i++;
                j++;
            }
        }

        // Both word and abbreviation should be fully traversed
        return i == word.length() && j == abbr.length();
    }

    public static void main(String[] args) {
        String word = "apple";
        String abbr = "a2e";

        boolean result = isValidAbbreviation(word, abbr);
        System.out.println("Is the abbreviation valid? " + result);
    }
}
