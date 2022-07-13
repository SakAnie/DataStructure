package GeeksforGeeks;

public class findTriplets {

	
	public static void main(String[] args) {
		
		
		
		int[] a= {1,2,3,5,8,13,14};
		int n=a.length;
		int count=0;
		int i=0;
		int sum=0;
		int j=0;
		
		while(n>=3 && i<n-1) {
			
			for(j=j+1;j<n;j++) {
				sum=a[i]+a[j];
				for(int x:a) {
					if(sum==x) {
						count++;
					
						break;
					
					}
				}
			}
			
			i++;
			j=i;
		}
		System.out.println(count);
	}
}
