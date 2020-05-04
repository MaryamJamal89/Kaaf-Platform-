import java.util.ArrayList;

public class Shelve {
	

	ArrayList<Book> booksForBorrow;
	ArrayList<Book> booksForSale;
	public static int totalNumberOfBooks;
	
	public Shelve(){
		booksForBorrow = new ArrayList<Book>();
		booksForSale = new ArrayList<Book>();
	}
	/*if book not in the lists, (we do not want repeated books)
	 *check the status and add to the ArrayList according to book type
	 *return true if added. 
	 */
	public boolean addBook(Book b){
		if (!isBookInShelve(b)){
			if(b.status().equalsIgnoreCase("borrow"))
					booksForBorrow.add(b);
			else if (b.status().equalsIgnoreCase("Sale"))
					booksForSale.add(b);
			return true;
		}
		return false;			
	}
	//remove the book from the list
	public boolean removeBook(Book b){
		if (isBookInShelve(b)){
			if(b.status().equalsIgnoreCase("borrow"))
					{booksForBorrow.remove(b);
					return true;
					}
			else if (b.status().equalsIgnoreCase("Sale"))
					{booksForSale.remove(b);
					return true;
					}
		}
		return false;
	}
	/* 
	 * checks the books price, 
	 *if zero, then look in the borrow list, 
	 *if more than zero, look in the sale list. 
	 *then return true if found, false otherwise. 
	 * */
	
	public boolean isBookInShelve(Book b){
		return booksForBorrow.contains(b) || booksForSale.contains(b);
	}
	//Look for books owned by this person and return array list of the books
	public ArrayList<Book> getBooksOwnedBy(Person p){
	
		ArrayList<Book> pb = new ArrayList<Book>();
		for(int j = 0; j < booksForBorrow.size(); j++){
			if (booksForBorrow.get(j).getOwner() == p)
				pb.add(booksForBorrow.get(j));
		}
		for(int j = 0; j < booksForSale.size(); j++){
			if (booksForSale.get(j).getOwner() == p)
				pb.add(booksForSale.get(j));
		}
		return pb;
	}
	
	//getters..
	public ArrayList<Book> getBooksForBorrow(){
		return booksForBorrow;
	}
	public ArrayList<Book> getBooksForSale(){
		return booksForSale;
	}
	/*
	 * Check the price, if zero then look in the borrowing list
	 * otherwise look in the sale list,
	 * return null if not found
	 */
	public Book getBook(String bookID){
	
			//look in booksForBorrow
			for(int i = 0; i < booksForBorrow.size(); i++){
				if(bookID.equalsIgnoreCase(booksForBorrow.get(i).getBookID()))
					return booksForBorrow.get(i);
			}
			for(int i = 0; i < booksForSale.size(); i++){
				if(bookID.equalsIgnoreCase(booksForSale.get(i).getBookID()))
					return booksForSale.get(i);
		
		}
		return null;
	}
	//returns an array list of all books in the level
	public ArrayList<Book> getBooksByLevel(int level){
		ArrayList<Book> lb = new ArrayList<Book>();
		for(int j = 0; j < booksForBorrow.size(); j++){
			if(booksForBorrow.get(j).level == level)
				lb.add(booksForBorrow.get(j));
		}
		for(int j = 0; j < booksForSale.size(); j++){
			if(booksForSale.get(j).level == level)
				lb.add(booksForSale.get(j));
		}
		return lb;
	}
	//returns an array list of all books of the passed name
	public ArrayList<Book> getBooksByName(String name){
		ArrayList<Book> books = new ArrayList<Book>();
		for(int j = 0; j < booksForBorrow.size(); j++){
			if(booksForBorrow.get(j).getTitle().equals(name))
				books.add(booksForBorrow.get(j));
		}
		for(int j = 0; j < booksForSale.size(); j++){
			if(booksForSale.get(j).getTitle().equals(name))
				books.add(booksForSale.get(j));
		}
		return books;
	}
	
	//display all books
	public void displayAllBooks(){
		System.out.println("The list of all books in the Shelve: ");
		for(int j = 0; j < booksForBorrow.size(); j++)
			System.out.println(booksForBorrow.get(j));
		for(int j = 0; j < booksForSale.size(); j++){
			System.out.println(booksForSale.get(j));
		}
	}
	
}
