package cs113;

import java.util.Scanner;

public class TestBooks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);

	        System.out.print("Number of java books in your library: ");
	        int numBooks = scanner.nextInt();
	        scanner.nextLine(); // consume the newline character

	        int totalNumPages = 0;
	        Book biggestBook = null;

	        for (int i = 0; i < numBooks; i++) {
	            System.out.print("Enter book title: ");
	            String title = scanner.nextLine();

	            System.out.print("Enter number of pages: ");
	            int pages = scanner.nextInt();
	            scanner.nextLine(); // consume the newline character

	            Book book = new Book(pages, title);
	            totalNumPages += pages;

	            if (biggestBook == null || book.compareTo(biggestBook) > 0) {
	                biggestBook = book;
	            }
	        }

	        double avgNumPages = (double) totalNumPages / numBooks;

	        System.out.println("Average number of pages: " + avgNumPages);
	        System.out.println("Biggest book -> " + biggestBook);
	        
	}

}
