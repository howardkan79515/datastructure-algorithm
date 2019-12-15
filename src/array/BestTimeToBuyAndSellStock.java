package array;


public class BestTimeToBuyAndSellStock {
	
	public static void main(String[] args) {
		new BestTimeToBuyAndSellStock().maxProfit(new int[] {7,1,5,3,6,4});
		new BestTimeToBuyAndSellStock().maxProfit(new int[] {7,6,4,3,1});

	}
	
	public int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE;
		int result = 0;
		for(int i = 1 ; i < prices.length ; i++) {
			if(min > prices[i-1]) {
				min = prices[i-1];
			} 
			if(result < (prices[i] - min)) {
				result = (prices[i] - min);
			}
		}		
		return result;        
    }
}
