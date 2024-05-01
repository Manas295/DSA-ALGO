package org.dsa.arrays;

public class BestTimeToBuyNSellForMaxProfit {
    /*
    Given an array prices[] of length N, representing the prices of the stocks on different days, the task is to find the maximum profit possible for buying and selling the stocks on different days using transactions where at most one transaction is allowed.

    Note: Stock must be bought before being sold.

    Examples:

        Input: prices[] = {7, 1, 5, 3, 6, 4]
        Output: 5
    Explanation:
        The lowest price of the stock is on the 2nd day, i.e. price = 1. Starting from the 2nd day, the highest price of the stock is witnessed on the 5th day, i.e. price = 6.
        Therefore, maximum possible profit = 6 – 1 = 5.

        Input: prices[] = {7, 6, 4, 3, 1}
        Output: 0
    Explanation: Since the array is in decreasing order, no possible way exists to solve the problem.

     */
    public static void main(String[] args) {
        int prices[] = {1, 5, 3, 8, 12};
        int n = prices.length;
        int max_profit = 0;
        for(int i=1; i< n ; i++){
            //Understand it like if prices[i] is greater than i-1 that means we can sell it hence calculate profit
            //else we will ignore means prices are low  i.e, it's not the time to sell
            if(prices[i] > prices[i-1]){
                max_profit+=(prices[i] - prices[i-1]);
            }
        }
        System.out.println("Max Profit "+max_profit);
    }
}
