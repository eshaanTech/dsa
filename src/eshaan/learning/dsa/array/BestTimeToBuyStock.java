package eshaan.learning.dsa.array;
/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 */
public class BestTimeToBuyStock {
    public int maxProfit(int[] prices) {
        //base case - do we need to check for the empty array?
        //we need to at least iterate thru all items at least once since we are trying to optimized the profit
        //we need to keep track max profit for each element
        //lowest prices is also important since that will help calculating the profit
        //Input: prices = [7,1,5,3,6,4]
        //Output: 5
        //-6, 4, 2, 6, 3
        //left = 0, 1, 1, 1, 1
        //right = 1, 2, 3, 4, 5
        int maxProfit = Integer.MIN_VALUE;
        int left = 0;
        for(int right = 1; right< prices.length; right++){
            int currentProfit = Math.max(prices[right]-prices[left], 0);
            maxProfit = Math.max(maxProfit, currentProfit);
            if(prices[right]<prices[left]){
                left = right;
            }
        }
        return maxProfit;
    }
}
