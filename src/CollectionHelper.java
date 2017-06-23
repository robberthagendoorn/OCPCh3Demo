import java.util.function.*;
import java.util.stream.*;
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
		startTimedEvent(collection, a -> generateBooks(a));
		return collection;
	}

	public static void sortTimedEvent(Collection<Book> collection) {
		if (collection instanceof Set) return;
		startTimedEvent(collection, a -> sortCollection(a)); 
	}
	
	public static void removeDuplicatesTimedEvent(Collection<Book> collection) {
		if (collection instanceof Set) return;
		startTimedEvent(collection, a -> removeDuplicates(a));
	}	
	
	public static void getRandomIndexTimedEvent(Collection<Book> collection) {
		startTimedEvent(collection, a -> getRandomIndex(a));
	}

	public static void searchTimedEvent(Collection<Book> collection) {
		startTimedEvent(collection, a -> search(a));
	}

	private static void startTimedEvent(Collection<Book> collection, Consumer<Collection<Book>> C) {
		long startTime = System.currentTimeMillis();
		C.accept(collection);
		long time = System.currentTimeMillis() - startTime;
		View.print(time);
	}

	private static void generateBooks(Collection<Book> collection) {
		View.print("Generating books in:");
		Stream.generate(Book::generateBook).limit(100000).forEach(collection::add);
	}

	private static void sortCollection(Collection<Book> collection) {
		View.print("Sorting collection in:"); 
		collection.stream().sorted().collect(Collectors.toList());
	}

	private static void removeDuplicates(Collection<Book> collection) {
		View.print("Removing duplicates in:");
		collection.stream().distinct().collect(Collectors.toList());
	}

	private static void getRandomIndex(Collection<Book> collection) {
		int it = 100000;
		Random rand = new Random();
		View.print("Getting random indexes in:");
		if (collection instanceof List) {
			List<Book> list = (List<Book>) collection;
			IntStream.generate(() -> rand.nextInt(list.size())).limit(it).forEach(list::get);
		} else {
			for (int i = 0; i < it; i++) {
				int r = rand.nextInt(collection.size());
				collection.stream().skip(r).findFirst(); 
			}
		}
	}

	private static void search(Collection<Book> collection) {
		View.print("Searching random books in:");
		int it = 100000;
		for (int i = 0; i < it; i++) { 
			Book book = Book.generateBook();
			collection.stream().filter(a -> a.equals(book)).findFirst();
		}
	}	
}


	

