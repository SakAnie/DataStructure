
public class forgjump {

	public static void main(String[] args) {
		int count = 0;
		int x = 120;
		int D = 30;
		int y = 110;
		int curr = x;

		if (x < y) {
			while (curr < y) {
				curr = curr + D;
				count++;
			}
		} else {
			System.out.println("Frog is already there");
		}

		System.out.println(count + "jumps");

		/*
		 * Method2: For O(1) use direct maths formulas; 2 LINER SOLUTION
		 * 
		 * Distance=y-x; 
		 * int jumps= (int) Math.ceil(Distance/(double)D);
		 */

	}
}
