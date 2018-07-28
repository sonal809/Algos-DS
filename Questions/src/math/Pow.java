package math;

public class Pow {
    public double myPow(double x, int n) {
        long N = n;
    	if ( N < 0) {
            x = 1/x;
            N = Math.abs(N);
        }
        if (n == 0) return 1.0;
        double y = 1;
        while( N > 0) {
            if( !(N % 2 == 0)) {
                y = y * x;
            }
            x *= x;
            N = N/2;
        }        
        return y;
    }
    
    public static void main(String args[]) {
    	Pow p = new Pow();
 //   	System.out.println(p.myPow(2.0, 4));
    	System.out.println(p.myPow(2.00000,-2147483648));
    	System.out.println(Integer.MAX_VALUE);
    }
}
