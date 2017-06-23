import java.util.*;

public class Controller {
	private View view;

	public Controller(View view) {
		this.view = view;
	} 
	
	public void start(Option option) {
		Collection<Book> bookCollection = CollectionHelper.getCollection(option);
		processCollection(bookCollection);	
	}

	private void processCollection(Collection<Book> collection) {
		CollectionHelper.addBooksToCollection(collection);
		CollectionHelper.sortAndDistinctTimedEvent(collection);
		CollectionHelper.getRandomIndexTimedEvent(collection);
		CollectionHelper.searchTimedEvent(collection);
	}
}  

						

