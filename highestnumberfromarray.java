package GeeksforGeeks;

import java.util.Arrays;
import java.util.Collections;

public class highestnumberfromarray {
	public static void main(String[] args) {

		int[] arr = { 9, 7, 8, 0, 5, 28, 22 ,11};

		//Step1: CONVERT INT[] TO STRING[]
		String[] s = new String[arr.length];
		for (int i = 0; i < arr.length; i++) {

			s[i] = String.valueOf(arr[i]);

		}

		//Step2: DESC SORT
		// 28,22,9,8,7,0 - desc sort
		// Lambda expression to sort the array in desc order
		// Arrays.sort(s,(a,b)->(b+a).compareTo(a+b));
		Arrays.sort(s, Collections.reverseOrder());

		//Step3: CONCATENATE USING SB
		//Concatenate all the s[i] into a Single string via StringBuilder
		StringBuilder sb = new StringBuilder();
		for (String str : s) {
			sb.append(str);
		}
		
		
		//STEP4: Result String CONVERT SB TO S
		String result = sb.toString();// stringBuilder to String
		System.out.println("........");
		System.out.println(result.startsWith("0") ? "0" : result);

	}

}
