
public class hcfFind {

	public static void main(String[] args) {


		int x = 24;
		int y = 48;
		/*
		 * 
		 * 24=1*2*2*3*2 48=1*2*2*3*2*2
		 * 
		 * 
		 * hcf: 24
		 */
		int hcf = 1;
        int temp = x;
		if (x < y) {
			for (int j = 2; j < temp; j++) {

				while(x % j == 0 && y % j == 0) {
					hcf = hcf * j;
					x=x/j;
					y=y/j;
				}

			}
		}
	 System.out.println(hcf);

	}
}
