import java.util.Arrays;

public class maxproductofthree {

	public static void main(String[] args) {

		// Find the max product of any triplet

		int[] A = { -4, -3, 1, 2, -2, 5, 6 };
		int array_size = A.length;

		Arrays.sort(A); //Master KEY*** soet before in such cases

		for (int a : A) {
			System.out.print(a);
		}

		int max_product = A[array_size - 1] * A[array_size - 2] * A[array_size - 3];
		System.out.println("\n" + max_product);

		// But here -4*-3*6 will be positive = 72>60 (max_product)

		int max_product_l = A[0] * A[1] * A[array_size - 1];

		if (max_product > max_product_l) {
			System.out.println(max_product);
		} else {
			System.out.println(max_product_l);
		}

	}
}