import java.util.Iterator;
import java.util.LinkedHashMap;

public class SubsSrtingOfLargestLength {

	public static void main(String[] args) {
		// Find subsString of Largest Length within a GIVEN STRING
		String s = "abcdeffghijklmnopqrsss";

		char[] c = s.toCharArray();

		LinkedHashMap<Character, Integer> hm = new LinkedHashMap<Character, Integer>();
		LinkedHashMap<Character, Integer> max = new LinkedHashMap<Character, Integer>();

		for (int i = 0; i < c.length; i++) {

			if (!hm.containsKey(c[i])) {

				hm.put(c[i], 1);
				if (i == c.length - 1) {
					if (hm.size() > max.size()) {

						max.clear();
						max.putAll(hm);

					}

				}

			}

			else {
				// check the last hm size to the max size
				if (hm.size() > max.size()) {

					max.clear();
					max.putAll(hm);
					hm.clear();
					hm.put(c[i], 1);
				}

				else {

					// if max is greater size and duplicate found , then just reset hm
					hm.clear();
					hm.put(c[i], 1);
				}
			}
		}

		Iterator<Character> it = max.keySet().iterator();
		while (it.hasNext()) {
			char each = it.next();
			System.out.print(each);
		}

	}

}
