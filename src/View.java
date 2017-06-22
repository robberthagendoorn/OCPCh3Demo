import java.util.*;
import java.io.Console;

public class View {
	
	public static void print(Object obj) {
		System.out.println(obj);
	}

	public static void displayBooks(Map<String, Book> map) {
		Collection<Book> books = map.values();
		displayBooks(books);
	}

	public static void displayBooks(Collection<Book> books) {
		for (Book book : books) {
			print(book);
		}
	}
}
