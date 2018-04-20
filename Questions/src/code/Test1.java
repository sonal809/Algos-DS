package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1 {
	  public static void main(String[] args) {

		    

		    int[] input = { 29, 78, 8, 0, 57, 9, 100 };		    

		    rearrange(input);
		    System.out.println(Arrays.toString(input));
		    int[] input2 = {29, 78, 8, 0, 57, 9, 100, 0 , 1,2,3};
		    rearrange(input2);
		    System.out.println(Arrays.toString(input2));


	

		  }
	  	public static int[] pivotIndex (int[] input) {
	  		int pivot = 0;
	  		List<Integer> pivotIndexes = new ArrayList<Integer>();
	  		for( int i = 0 ; i < input.length; i++) {
	  			if(input[i] == pivot) {
	  				 pivotIndexes.add(i);
	  			}
	  		}
	  		int[] indexes = new int[pivotIndexes.size()];
	  		int i = 0;
	  		for(Integer index: pivotIndexes) {
	  			indexes[i] = index;
	  			i++;
	  		}
	  		return indexes;
	  	}
		  

		  public static void rearrange(int[] input) {

		    int[] pivotIndex  = pivotIndex(input);
		    int start = 0;
		    for (int i = 0; i< pivotIndex.length; i++) {
		    	reverse(input,start, pivotIndex[i] -1 );
		    	start = pivotIndex[i] +1;
		    }
		    reverse(input, start,input.length-1 );

		  }  

		  private static void reverse(int[] input, int first, int last) {
			  	int i = first;
			  	int j = last;
			  	if(first >= input.length -1) {
			  		return;
			  	}
			  	while ( i < j) {
			  		int temp = input[j];
			  		input[j] = input[i];
			  		input[i] = temp;
			  		i++;
			  		j--;
			  	}
			  
		  }
}
