package stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/the-stock-span-problem/
 * Input array of stock prices eg. P[] = {100,70,60,90,80}
 * Output : Array of stock price spans . Span of P[i] is the no. of days before this price was the highest price
 * Sample output: {1,1,1,3,1} 
 * @author sonaggarwal
 *
 */
public class StockSpanProblem {
	
	public int[] getStockSpans(int[] stockPrices) {
		int[] stockSpans = new int[stockPrices.length];
		stockSpans[0] = 1;
		//h(i) is such that the price is greater than on that day than the price on day i.
		//h(i) is basically an index location
		Stack<Integer> st= new Stack<>();
        st.push(0); 

		for (int i = 1; i < stockPrices.length; i++) {
			while(!st.isEmpty() && stockPrices[st.peek()] <= stockPrices[i]) {
				st.pop();
			}
			if(st.isEmpty()) {
				stockSpans[i] = i+1;
			} else {
				stockSpans[i] = i - st.peek();
			}
			st.push(i);
			
			
		}
		return stockSpans;
	}
	
	public static void main(String args[]) {
		StockSpanProblem obj = new StockSpanProblem();
        int price[] = {10, 4, 5, 90, 120, 80};
        int[] spans = obj.getStockSpans(price);
        System.out.println(Arrays.toString(spans));
        
	}
}
