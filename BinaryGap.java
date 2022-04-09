import java.util.Scanner;

public class BinaryGap {
	
	public static void main(String[] args) {
		
		//Find the Maximum Gap of 0s between the consecutive 1s in the binary representation f a given Integer N
		
		//For Example:
		//input: 9 (Binary->1001 , O/p: 2
		//input2: 35(Binary-->100011,o/p:3
		//input3: 32(Binary-->100000.o/p:0
		//input4:529(Binary-->1000010001,o/p: 4
		
		Scanner s=new Scanner(System.in);
		System.out.println("Enter the Interger for which you want to find out the binary gap");
		int N=s.nextInt();
		
		String binary=Integer.toString(N, 2);
		System.out.println(binary+"is the binary of the Given Integer "+N);
		
		
		//Iterate over the Binary representation of the Given N 
		//By converting it into character Array
		char[] c=binary.toCharArray();
		
		int counter=0;
		int maxcounter=0;
		for(int i=0;i<c.length;i++) {
			if(c[i]=='0') {
				counter++;
			}
			else {
				//ie if c[i]=1
				if(counter>maxcounter) {
					maxcounter=counter;
					counter=0;//reset the currentcounter
				}
			}
		}
		System.out.println("Maximum Binary Gap for Given N is"+maxcounter);
	}

}
