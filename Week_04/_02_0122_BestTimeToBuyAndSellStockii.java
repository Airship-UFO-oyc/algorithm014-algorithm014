package homework._04week;

/**
 * 122. 买卖股票的最佳时机 II
 * ----------------------------
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * ------------
 * 示例 1:
 * 输入: [7,1,5,3,6,4]
 * 输出: 7
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
 * -----------------
 * 示例 2:
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 *      注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 *      因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * ---------
 * 提示：
 * 1 <= prices.length <= 3 * 10 ^ 4
 * 0 <= prices[i] <= 10 ^ 4
 * --------------------------------------
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * ------------------------------------------------------------------------------------------
 */
public class _02_0122_BestTimeToBuyAndSellStockii {


    //[1]暴力O(N)：1>升序起点买入（即降序低谷），升序顶点卖。
    public int maxProfit1(int[] prices) {
        int buy = 0;//买入索引
        int sell = 0;//卖出索引
        int earn = 0;
        for (int i = 0; i < prices.length; i++) {
            if (i + 1 < prices.length && prices[i] < prices[i + 1]) {
                buy = i;
            } else {
                continue;
            }
            while (i + 1 < prices.length && prices[i] < prices[i + 1]) {
                i++;
            }
            if (i < prices.length) {
                sell = i;
            } else {
                sell = i - 1;
            }
            earn += prices[sell] - prices[buy];
        }
        return earn;
    }

    //[2]贪心法：O(N)，只加正数。
    public int maxProfit(int[] prices) {
        int earn = 0, profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            profit = prices[i + 1] - prices[i];
            if (profit > 0) earn += profit;
        }
        return earn;
    }

    public static void main(String args[]) {
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        int[] prices2 = {1, 2, 3, 4, 5};
        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println(new _02_0122_BestTimeToBuyAndSellStockii().maxProfit(prices1));
        System.out.println(new _02_0122_BestTimeToBuyAndSellStockii().maxProfit(prices2));
        System.out.println(new _02_0122_BestTimeToBuyAndSellStockii().maxProfit(prices3));
    }

}

