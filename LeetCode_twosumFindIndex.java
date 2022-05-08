import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;

public class twosumFindIndex {

	public static void main(String[] args) {

		int[] A = { 2, 3, 4, 5, 6, 7, 8, 9, 1 };
		int low = -1;
		int high = -1;
		int key_sum = 10;
		int curr_sum = 0;
		int size = A.length;

		LinkedHashMap<Integer, Integer> hm = new LinkedHashMap<Integer, Integer>();
		// in Key part store the ARRAY value and the value part , store the Array INDEX

		for (int i = 0; i < size; i++) {

			hm.put(A[i], i);

			if (hm.containsKey(key_sum - A[i])&& A[i]!=key_sum-A[i]){
				
				//assuming array does not contain duplicates
				System.out.println("indexes are" + hm.get(A[i]) + "and" + hm.get(key_sum - A[i]));
			}

		}

	}

}
