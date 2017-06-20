package patterns._1_creational._3_prototype;

import lafore.data_structures.hash_tables.hash_map.HashMap;

/**
 * @author LinnykOleh
 */
public class Registry {

	private HashMap<String, Item> items = new HashMap<>();

	public Registry(){
		loadItems();
	}

	public Item createItem(String type){
		try {
			return (Item) items.get(type).clone();
		}
		catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void loadItems(){
		final Movie movie = new Movie();
		movie.setTitle("Basic movie");
		movie.setPrice(24.99);
		movie.setRunTime(2);
		movie.setUrl("hello.movie");
		items.put("Movie", movie);

		final Book book = new Book();
		book.setNumberOfPages(355);
		book.setPrice(19.99);
		book.setTitle("Basic book");
		book.setUrl("hello.book");
		items.put("Book", book);
	}


}
