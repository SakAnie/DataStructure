import java.util.HashMap;
import java.util.Scanner;

public class CountOccurance {

	public static void main(String[] args) {

		// PROBLEM1: Count the occurance of each word in a given String
		// PROBLEM2: Count the occurance of each character in a given Word

		// SOLUTION FOR BOTH PROBLEMS ARE SIMILAR

		Scanner s = new Scanner(System.in);

		System.out.println("Enter the sentence for which you want to cpunt words frequency");

		String s1 = s.nextLine();

		System.out.println(s1);

		String[] words_array = s1.split(" "); // delimiter is <space> in a sentence to separate it into words

		// Declare a HashMap where Key stores each word and Value part stores the
		// frequency

		HashMap<String, Integer> hm = new HashMap<String, Integer>();

		int len = words_array.length; // to avoid using length function again and again in the loop

		for (int i = 0; i < len; i++) {

			if (!hm.containsKey(words_array[i])) {
				// hashMap does NOT contain the word already , then add to hashMap with
				// frequency 1, else just
				// Increase the count of the value part
				hm.put(words_array[i], 1);
			}

			else {
				hm.put(words_array[i], hm.get(words_array[i]) + 1); // increase frequency if already exists
			}

		}

		System.out.println(hm);

	}

}
