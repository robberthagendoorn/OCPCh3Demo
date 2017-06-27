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

	public static Collection<Book> addBooksToCollection(Collection<Book> collection) {
		startTimedEvent(collection, a -> generateBooks(a));
		return collection;
	}

	public static void sortAndDistinctTimedEvent(Collection<Book> collection) {
		if (collection instanceof Set) return;
		startTimedEvent(collection, a -> sortAndDistinctCollection(a)); 
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

	private static void sortAndDistinctCollection(Collection<Book> collection) {
		View.print("Sorting collection and getting distinct in:"); 
		collection.stream().sorted().distinct().collect(Collectors.toList());
	}

	private static void getRandomIndex(Collection<Book> collection) {
		int count = 100000;
		Random rand = new Random();
		View.print("Getting random indexes in:");
		if (collection instanceof List) {
			List<Book> list = (List<Book>) collection;
			IntStream.generate(() -> rand.nextInt(list.size()))
			         .limit(count)
					 .forEach(list::get);
		} else {
			IntStream.generate(() -> rand.nextInt(collection.size()))
					 .limit(count)
					 .forEach(a -> findIndex(collection, a));
		}
	}

	private static void findIndex(Collection<Book> collection, int index) {
		collection.stream().skip(index).findFirst(); 
	}

	private static void search(Collection<Book> collection) {
		View.print("Searching random books in:");
		int count = 100000;
		Stream.generate(() -> Book.generateBook())
			  .limit(count)
			  .forEach( a -> findBook(collection, a));
	}

	private static void findBook(Collection<Book> collection, Book book) {
		collection.stream().filter(a -> a.equals(book)).findFirst();
	}	
}


	

