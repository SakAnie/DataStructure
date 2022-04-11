import java.util.*;
import java.util.stream.Collectors;

public class Mycodility001 {

	public int solution(int[] A) {
		// that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

//For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

//Given A = [1, 2, 3], the function should return 4.

//Given A = [−1, −3], the function should return 1.

//Write an efficient algorithm for the following assumptions:

//N is an integer within the range [1..100,000];
//each element of array A is an integer within the range [−1,000,000..1,000,000].

		

		HashSet<Integer> hs = new HashSet<Integer>();

		// create unique elements reference list from 1 to n+1
		for (int i = 1; i <= A.length + 1; i++) {
			hs.add(i);
		}

		//remove all items of hs ref which is present in A
		for (int x : A) {

			hs.remove(x);

		}
		
		return hs.iterator().next(); //first element from the remaining

	}

	public static void main(String[] args) {

		int[] A = { -1, -2,0};

		Mycodility001 s = new Mycodility001();

		int result = s.solution(A);

		System.out.println(result);

	}
}
