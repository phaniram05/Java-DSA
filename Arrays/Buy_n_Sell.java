package Arrays;


 // Time Complexity: O(N) Aux.Space: O(1) 

public class Buy_n_Sell {
    public static void main(String[] args) {
        int[] stocks1 = new int[]{7,6,4,3,1};
        int[] stocks2 = new int[]{3, 5, 1, 7, 4, 9, 3};
        System.out.println("Max profit BnS1: "+Buy_n_Sell_1(stocks1));
        int[] test = {7,1,5,3,6,4};
        System.out.println("Max profit BnS 2: "+Buy_n_Sell_2(test));
    }

    // Buy and Sell 1
/*  
 *      Input: prices = [7,1,5,3,6,4]
        Output: 5
        Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
        Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * 
 *  
 *      Input: prices = [7,6,4,3,1]
        Output: 0
        Explanation: In this case, no transactions are done and the max profit = 0.
 * 
 */
    public static int Buy_n_Sell_1(int[] stocks){           
        int minSoFar = stocks[0];
        int maxProfit = 0;
        
        for(int i=0; i < stocks.length;i++){
            minSoFar = Math.min(minSoFar, stocks[i]); 
            maxProfit = Math.max(maxProfit, stocks[i] - minSoFar);       
        }
        return maxProfit;
    }

    // Buy and Sell 2
    /*  
     *  Input: prices = [7,1,5,3,6,4]
        Output: 7
        Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
        Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
        Total profit is 4 + 3 = 7.
     * 
     *  Input: prices = [1,2,3,4,5]
        Output: 4
        Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
        Total profit is 4.
     * 
     *  Input: prices = [7,6,4,3,1]
        Output: 0
        Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.
 
     */
    public static int Buy_n_Sell_2(int[] prices){

        int maxProfit = 0;
        for(int i=1; i < prices.length; i++){
            if(prices[i] > prices[i-1]){
                maxProfit += prices[i] - prices[i-1];
            }
        }
        return maxProfit;
    }













}