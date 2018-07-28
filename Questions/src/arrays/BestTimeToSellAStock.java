package arrays;


import org.junit.Assert;
import org.junit.Test;

public class BestTimeToSellAStock {
    public int maxProfit(int[] prices) {
        int maxDiff = 0;
        if ( prices == null || prices.length < 2) return maxDiff;
        int min = prices[0];
        for (int i = 1; i < prices.length ; i++) {
        	if (prices[i] < min) min = prices[i];
        	if ((prices[i] - min) > maxDiff) maxDiff = prices[i] - min;
        }
        return maxDiff;
    }
    
    @Test
    public void test() {
    	BestTimeToSellAStock obj = new BestTimeToSellAStock();
    	int[] arr = {7,1,5,3,6,4};
    	Assert.assertEquals(5, obj.maxProfit(arr));
    }
    
    
}
