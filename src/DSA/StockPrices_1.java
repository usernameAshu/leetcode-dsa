package DSA;

public class StockPrices_1 {

  public static void main(String[] args) {
    int[] prices = {1,6,4,9,1};
    System.out.println(maxProfit(prices));
  }

  /**
   * Approach: https://www.youtube.com/watch?v=1pkOgXD63yU
   * Two pointer approach, where buy pointer will stay at low point,
   * At positive profit, we will store the max profit
   * At negative profit, we will move buy to sell index
   * sell pointer will increase throughout.
   *
   * @param prices
   * @return
   */
  static int maxProfit(int[] prices) {
    int L = prices.length;
    int b = 0, s = 1, maxProfit = 0;

    while(s < L) {
      if(prices[b] < prices[s]) {
        //profit booked
        maxProfit = Math.max(prices[s] - prices[b] , maxProfit);
      } else {
        b = s;
      }
      s++;
    }

    return maxProfit;
  }
}
