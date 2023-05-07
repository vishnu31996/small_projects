import java.util.HashSet;

public class Test {
	// A simple Java program to find sum of all
	// subsquares of size k x k

	// Size of given matrix

	// A simple function to find sum of all
	// sub-squares of size k x k in a given
	// square matrix of size n x n
	static int max = Integer.MIN_VALUE;

	static int printSumSimple(int mat[][], int k) {

		// k must be smaller than or equal to n
		int row = mat.length;
		int column = mat[0].length;

		// row number of first cell in current sub-square of
		// size k x k
		for (int i = 0; i < row - k + 1; i++) {

			// column of first cell in current sub-square of
			// size k x k
			for (int j = 0; j < column - k + 1; j++) {

				// Calculate and print sum of current
				// sub-square
				int sum = 0;

				for (int p = i; p < k + i; p++)
					for (int q = j; q < k + j; q++)
						sum += mat[p][q];

				if (sum > max)
					max = sum;
			}

		}
		HashSet<Integer> unique = new HashSet<Integer>();
		for (int i = 0; i < row - k + 1; i++) {

			// column of first cell in current sub-square of
			// size k x k
			for (int j = 0; j < column - k + 1; j++) {

				// Calculate and print sum of current
				// sub-square
				int sum = 0;

				for (int p = i; p < k + i; p++)
					for (int q = j; q < k + j; q++)
						sum += mat[p][q];

				if (sum == max) {
					for (int p = i; p < k + i; p++)
						for (int q = j; q < k + j; q++)
							unique.add(mat[p][q]);
				}

			}

		}
		int count=0;
		for(int a:unique) {
			count+=a;
		}
		return count;
	}

	// Driver Program to test above function
	public static void main(String arg[]) {
		int mat[][] = { { 1, 0, 1, 5, 6 }, { 3, 3, 0, 3, 3 }, { 2, 9, 2, 1, 2 }, { 0, 2, 4, 2, 0 } };
		int k = 2;

		System.out.println(printSumSimple(mat, k));
		
	}

	// This code is contributed by Aditya Kumar (adityakumar129)

}
