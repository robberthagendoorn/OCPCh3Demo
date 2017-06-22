import java.util.*;

public class MapHelper {
	public static Map getMap(Option option) {
		if (option == Option.HASHMAP) {
			return new HashMap<String, Book>();
		} else {
			return new TreeMap<String, Book>();
		}
	}
}
