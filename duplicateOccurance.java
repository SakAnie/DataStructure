import java.util.HashMap;
import java.util.Iterator;

public class duplicateOccurance {

	public static void main(String[] args) {

		// Find and Calculate duplicate Occurance of Each character in a String

		String s1 = "SakshiSinha";

		char[] c = s1.toCharArray();

		// Container to store Each character and its frequency
		HashMap<Character, Integer> hm = new HashMap<Character, Integer>();

		for (int i = 0; i < c.length; i++) {

			// if map has the character not present , then add the character to the map's
			// key and its frew as 1
			// if already present in map, then increase the frequncy of the character in the
			// map's value part
			if (!hm.containsKey(c[i])) {
				hm.put(c[i], 1);
			} else {
				hm.put(c[i], hm.get(c[i]) + 1);
			}

		}

		Iterator<Character> it = hm.keySet().iterator();
		while (it.hasNext()) {
			Character eachchar = it.next();
			if (hm.get(eachchar) > 1) {
				System.out.println("Frequcny of " + eachchar + " is " + hm.get(eachchar));
			}
		}

	}

}
