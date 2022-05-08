import java.util.ArrayList;
import java.util.HashSet;

public class primenumbers {

	public static void main(String[] args) {
		ArrayList<Integer> arr = new ArrayList<Integer>();
		int flag;
		for (int i = 2; i < 100; i++) {
			flag = 0;
			for (int j = 2; j < i / 2; j++) {

				if (i % j == 0) {
					flag = 1;
					break;

				}
			}
			if (flag == 0) {
				arr.add(i);
			}
		}
		System.out.println(arr);

	}
}
