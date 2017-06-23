import java.util.*;

public class Book implements Comparable<Book> {
	private String author;
	private String name;

	public String getAuthor() {
		return author;
	}

	public String getName() {
		return name;
	}

	private Book (String author, String name) {
		this.author = author;
		this.name = name;
	}

	public static Book generateBook() {
		String author = Author.getRandomAuthor().toString();
		String title = Title.getRandomTitle().toString();
		Book newBook = new Book(author, title);
		return newBook;
	}

	@Override 
	public String toString() {
		return (this.author+ ", " + this.name).replaceAll("_"," ");
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Book)) return false;
		Book book = (Book) object;
		return (this.author == book.author &&  this.name == book.name);
	}

	@Override
	public int hashCode() {
		return author.hashCode() + name.hashCode();
	}

	@Override
	public int compareTo(Book book) {
		return this.toString().compareTo(book.toString());
	}		 
}

