package ebc2Tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.List;

public class suki001 {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5, 6, 7 };
		int key = 8;
		// expected output: 1,7......2,6
		
		/* METHOD 1 -  BRuite Force O(n2)
		for (int i = 0; i < a.length; i++) {
//			for (int j = i + 1; j < a.length; j++) {
//
//				System.out.println("inside for");
//				if (a[i] + a[j] == key) {
//					System.out.println("inside ANSWER");
//					System.out.println("Answer" + i + " " + "is" + a[i] + " " + a[j] + ".....end");
//					break;
//				}
//			
//				System.out.println("Outside for");
//
//			}
//		}
  */
 
/* METHOD2 - O(n)*/

		// step1: insert every element of array into HASHTABLE O(n)

		Hashtable ht = new Hashtable();

		// while transfering values from array to HashTable, do the conditioning
		for (int i = 0; i < a.length; i++) {
			//we will store only those <K,V> in HashTable which is NOT present
			if (!ht.containsKey(a[i])) {
				//add karo
				ht.put(key-a[i], a[i]);

			}
			else {
				//print karo- if present then simply print them, THIS WILL SAVE THE DUPLICATION
				System.out.println(a[i]+","+ht.get(a[i]));
			}

		}

	}
}
