
public class DigitCounter {

	public static void main(String[] args) {
		// Find the total occurance of digit 6 in betwen 0 to 1000 range .

		int count = 0;

		for (int i = 0; i < 1000; i++) {
			int n = i;// make copy into another variable to mnaipulate

			while (n != 0) {

				if (n % 10 == 7) {
					count++;
				}

				n = n / 10;
			}
		}
		
		System.out.println(count);
	}
	

}
