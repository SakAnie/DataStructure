import java.util.*;
import java.util.stream.Collectors;

public class Mycodility001 {

	public int solution(int[] A) {
		// write your code in Java SE 8
		

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
