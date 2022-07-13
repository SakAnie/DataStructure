package GeeksforGeeks;

public class KadainesAlgo {
	
	public static void main(String[] args) {
		
		
		/*
		 * 
		 * Find the max sum of the given array elements where all elements are distinct
		 * ie the subArray with MAX SUM 
		 * (please note: it can be the full array as well)
		 * 
		 * 
		 */
		
		int[] a= {-1,2,3,-7,-8,10,4};
		
		int maxsum=0;
		int currsum=0;
		for(int i=0;i<a.length;i++) {
			
			currsum+=a[i];
			if(currsum>maxsum) {
				maxsum=currsum;
			}
			
			if(currsum<0) {
				//ie it becomes neg due to presence of some neg value
				currsum=0; //reset the currsum
				
			}
		}
		
		System.out.println(maxsum);
	}

}
