package util;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;


public class GraphUtil {
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
          return new int[0];
        }
    
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
    
    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray =  Json.parse(input).asArray();
        if (jsonArray.size() == 0) {
          return new int[0][0];
        }
    
        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
          JsonArray cols = jsonArray.get(i).asArray();
          arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }
}
