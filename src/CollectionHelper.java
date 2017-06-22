import java.util.*;

public class CollectionHelper {

	public static Collection<Book> getCollection(Option option) {
		switch(option) {
			case ARRAYLIST:
				return new ArrayList<Book>();
			case LINKEDLIST:
				return new LinkedList<Book>();
			case ARRAYDEQUE:
				return new ArrayDeque<Book>();
			case HASHSET:
				return new HashSet<Book>();
			case TREESET:
				return new TreeSet<Book>();
			default:
				return null;
		}
	}

	public static Collection<Book> addBooksToCollection(Collection<Book> collection, int numberOfBooks) {
		Timer.start();
		for (int i = 0; i < numberOfBooks; i++) {
			Book book = Book.generateBook();
			collection.add(book);
		}
		Timer.end("Generating collection");
		return collection;
	}

	public static Collection<Book> sortCollection(Collection<Book> collection) {
		if (collection instanceof TreeSet) {
			View.print("A treeset is automatically sorted");
		} else { 
			Timer.start();
			List<Book> list = (collection instanceof List) ? (List<Book>) collection : new ArrayList<>(collection); 
			Collections.sort(list);
			if (collection instanceof ArrayDeque) collection = new ArrayDeque<Book>(list);  
			Timer.end("Sorting collection");
		}
		return collection;
	}
}

