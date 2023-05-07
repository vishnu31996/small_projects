import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionHandelling {

	public static void main(String args[]) {

		// System.out.println("Enter");
		Scanner sc = new Scanner(System.in);
		int a = 0;
		while (a == 0) {
			try {

				System.out.println("Enter");
				a = sc.nextInt();

			} catch (InputMismatchException e) {
				System.out.println("Enter number only");

			}
		}
		System.out.println(a);
	}
}
