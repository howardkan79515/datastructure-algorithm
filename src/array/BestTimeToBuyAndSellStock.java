package array;


public class BestTimeToBuyAndSellStock {
	
	public static void main(String[] args) {
		new BestTimeToBuyAndSellStock().maxProfit(new int[] {7,1,5,3,6,4});
		new BestTimeToBuyAndSellStock().maxProfit(new int[] {7,6,4,3,1});

	}
	
	public int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i = 0; i < prices.length; i++) {
			max = Math.max(prices[i] - min, max);
			min = Math.min(min, prices[i]);
		}
		return max;
    }
}
