import java.util.*;

public class Controller {
	private View view;
	private static final int numberOfBooks = 1000000;

	public Controller(View view) {
		this.view = view;
	} 
	
	public void start(Option option) {
		if (option == Option.HASHMAP || option == Option.TREEMAP) {
			Map bookMap = MapHelper.getMap(option);		
		} else {
			Collection<Book> bookCollection = CollectionHelper.getCollection(option);
			processCollection(bookCollection);	
		}
	}

	private void processCollection(Collection<Book> collection) {
		CollectionHelper.addBooksToCollection(collection, numberOfBooks);
		CollectionHelper.removeDuplicatesTimedEvent(collection);	
		CollectionHelper.sortTimedEvent(collection);
		CollectionHelper.getRandomIndexTimedEvent(collection);
		CollectionHelper.searchTimedEvent(collection);
	}
}  

						

