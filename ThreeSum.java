import java.util.HashSet;

public class ThreeSum {

	
	
	public static void main(String[] args) {
		int[] a= {1,2,3,4,5,6,7,8,4,9};
		int key=8;
		//Find all such set of 3 numbers in this array whose sum is equal to a given KEY: 6
		//a[i]+a[j]+a[k]=key
		//Find solution in O(n2)
		
		
		HashSet hs=new HashSet();
		for(int i=0;i<a.length;i++) {
			
			for(int j=i+1;j<a.length;j++) {
				
				//CORE LOGIC: IF THE HASHSET CONTAINS a[k] ( ie key-a[i]-a[j])=> then print the triplet
				if(hs.contains(key-a[i]-a[j])) {
					System.out.println("triplet is "+a[i]+" "+a[j]+" & "+(key-a[i]-a[j]));
				}
				hs.add(a[j]); //add the items to the HashSet
				
			}
		}
	}
}
