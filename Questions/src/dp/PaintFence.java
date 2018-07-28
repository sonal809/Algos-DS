package dp;

import org.junit.Assert;
import org.junit.Test;

public class PaintFence {
    public int numWays(int n, int k) {
     int prevDiff = k;
     int prevSame = 0;
     int newDiff = k;
     int newSame = 0;
     for (int i = 2; i <= n ; i++) {
    	 newDiff = (prevDiff + prevSame)* (k-1);
    	 newSame = prevDiff;
    	 prevDiff = newDiff;
    	 prevSame = newSame;
     }
     return newDiff+newSame;
    }
    
    
    @Test
    public void test1() {
    	PaintFence pf = new PaintFence();
    	Assert.assertEquals(6, pf.numWays(3, 2));
    	Assert.assertEquals(24, pf.numWays(3, 3));

    }
}
