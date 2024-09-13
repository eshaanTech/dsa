package eshaan.learning.dsa.String;

public class MultiplyString {
    public String multiply(String num1, String num2) {
        // Edge case: if either number is zero, the result is zero
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int len1 = num1.length();
        int len2 = num2.length();
        // Result array to store the multiplication results
        int[] result = new int[len1 + len2];

        // Reverse iterate both strings and multiply each digit
        for (int i = len1 - 1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';  // Convert character to digit
            for (int j = len2 - 1; j >= 0; j--) {
                int digit2 = num2.charAt(j) - '0';  // Convert character to digit

                // Multiply the digits and add to the current position
                int sum = digit1 * digit2 + result[i + j + 1];

                // Set the current digit
                result[i + j + 1] = sum % 10;

                // Add the carry to the next left position
                result[i + j] += sum / 10;
            }
        }

        // Convert the result array to a string, skipping leading zeros
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (!(sb.length() == 0 && num == 0)) {  // Skip leading zeros
                sb.append(num);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyString solution = new MultiplyString();
        String num1 = "123";
        String num2 = "456";
        System.out.println(solution.multiply(num1, num2));  // Output: "56088"
    }
}
