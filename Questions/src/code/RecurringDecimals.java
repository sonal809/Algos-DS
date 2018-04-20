package code;

import java.util.HashMap;
import java.util.Map;

public class RecurringDecimals {
    	public String fractionToDecimal(int numerator, int denominator) {
            if (numerator == 0) {
                return "0";
            }
            StringBuilder res = new StringBuilder();
            // "+" or "-"
            res.append(((numerator > 0) ^ (denominator > 0)) ? "-" : "");
            //long num = Math.abs((long)numerator);
            //long den = Math.abs((long)denominator);
            int remainder = numerator % denominator;
            // integral part
            res.append(numerator / denominator);
            
            if (remainder == 0) {
                return res.toString();
            }
            
            // fractional part
            res.append(".");
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            map.put(remainder, res.length());
            while (remainder != 0) {
            	remainder *= 10;
            	int num = remainder;
                res.append(remainder / denominator);
                remainder = num/ denominator;
                if (map.containsKey(remainder)) {
                    int index = map.get(remainder);
                    res.insert(index, "(");
                    res.append(")");
                    break;
                }
                else {
                    map.put(num, res.length());
                }
            }
            return res.toString();
    }
    
    public static void main(String args[]) {
    	RecurringDecimals obj = new RecurringDecimals();
    	obj.fractionToDecimal(1, 2);
    }
}
