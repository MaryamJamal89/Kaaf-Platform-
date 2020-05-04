import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class KaffPlatform {
        
    static String main_menu = "\n*** Welcome to Kaff Platform System ***\n" + "1- User Subsystem\n"
			+ "2- Admin Subsystem\n" + "3- Exit \n" + "Your Choice: ";
	static String user_menu = "\n\t*** Welcome to User Sub-system ***\n" + "\t1- Add a book \n" + "\t2- Buy a book \n"
			+ "\t3- Borrow a book \n" + "\t4- Return a book \n" + "\t5- Display books \n"
			+ "\t6- Update your information \n" + "\t7- Exit/Change User \n" + "\tYour Choice: ";

	static String admin_menu = "\n\t*** Welcome to Admin Sub-system ***\n" + "\t1- Recieved money \n"
			+ "\t2- Remove a book \n" + "\t3- Display books owned by a user\n" + "\t4- Print balance \n"
			+ "\t5- Update book information \n" + "\t6- Display users \n" + "\t7- Exit \n" + "\tYour Choice: ";;
	static Scanner input = new Scanner(System.in);

	static ArrayList<Person> user = new ArrayList<>();
	static Shelve shelve = new Shelve();
	static double balance = 0;
	static int noOfUsers = 0;

	static Book book;
	static String name, userId, phone, email;
	static int userLvl;

	public static void main(String[] args) {
		int choice = 0;
		fillShelve();
		do {
			System.out.print(main_menu);
			choice = input.nextInt();
			switch (choice) {
			case 1:
				user_system();
				break;
			case 2:
				admin_system();
				break;
			case 3:
				break;
			default:
				System.out.print("Wrong Entry. Please enter a valid option.");
			}
		} while (choice != 3);
		System.out.println("Thank you for using our system, may the books be in your favor:)!");

	}

	static void user_system() {
		noOfUsers++;
		int currentOwner = -1;
		int currentBuyer = -1;
		int currentBorrower = -1;

		getUserInformation();

		boolean flagOwner = false;
		boolean flagBuyer = false;
		boolean flagBorrower = false;

		int choice;
		do {

			System.out.print(user_menu);
			choice = input.nextInt();
			switch (choice) {
			case 1: {
				// Add a book
				if (!flagOwner) {
					// checks if owner object is created for this person
					// before..
					for (int i = 0; i < getOwners(user).size(); i++)
						if (((getOwners(user)).get(i).getAcademicNum()).equals(userId))
							flagOwner = true;
				}

				if (!flagOwner) {
					// creates a new owner object for the user..
					System.out.println("Are you graduating this year? (y/n)");
					do {
						String g = input.next();
						if (g.equalsIgnoreCase("y")) {
							user.add(new Owner(name, userId, userLvl, phone, email, false, true, 0));
							currentOwner = (user.size()) - 1;
							break;
						} else if (g.equalsIgnoreCase("n")) {
							user.add(new Owner(name, userId, userLvl, phone, email, false, false, 0));
							currentOwner = (user.size()) - 1;
							break;
						} else
							System.out.print("Wrong entry. Please enter either y/n.");
					} while (true);
				}
				// get information for the book..
				System.out.println("Enter the following information:");
				System.out.println("Book Title:");
				String title = input.nextLine();
				title = input.nextLine();
				System.out.println("Course ID:");
				String id = input.nextLine();
				System.out.println("Book Level:");
				int lvl = input.nextInt();
				System.out.println("Book Price:");
				double prc = input.nextDouble();
				System.out.println("Book Status (Sale/Borrow):");
				String s = input.next();
				// create the book object then add in the shelve
				Book b = new Book(title, id, lvl, user.get(currentOwner), true, prc, s);
				if (shelve.addBook(b)) {
					{
						System.out.println("Book was added successfuly.");
						((Owner) user.get(currentOwner)).incrmntBookCount();
					}
					line();
				}
				break;
			}
			case 2: {
				// 2- buy book
				Book book = getTheBook();
				if (book != null) {
					System.out.println("The book price is: " + book.getPrice());
					// checks if the user is a buyer or create a buyer object
					// for him/her
					if (!flagBuyer)
						for (int i = 0; i < getBuyers(user).size(); i++)
							if (((getBuyers(user)).get(i).getAcademicNum()).equals(userId)) {
								flagBuyer = true;
								break;
							}

					if (!flagBuyer) {
						user.add(new Buyer(name, userId, userLvl, phone, email, true));
						currentBuyer = (user.size()) - 1;
					}
					// book is bought..
					book.setAvailability(false);
					System.out.print(book + "\nYou have bought this book.");
					// book.getOwner().setGotPaid(true); needs casting?
					balance += book.getPrice();
				}
				line();
				break;
			}
			case 3: {
				// 3- borrow book
				// checks if user is a borrower or create a borrower object..
				if (!flagBorrower) {
					for (int i = 0; i < getBorrowers(user).size(); i++)
						if (((getBorrowers(user)).get(i).getAcademicNum()).equals(userId))
							flagBorrower = true;
				}

				if (!flagBorrower) {
					user.add(new Borrower(name, userId, userLvl, phone, email, new Date()));
					currentOwner = (user.size()) - 1;
				}

				// ask which book he wants to borrow
				book = getTheBook();
				if (book != null) {
					if (book.getAvailability())
						System.out.println(book + " is avaiable to borrow.");
					else
						System.out.println(book + " is not avaiable..");
				}
			}
			case 4: {
				// 4- return a book, set returned state = true in borrower &&
				// avaiablity to true.
				book = getTheBook();
				if (book != null) {
					System.out.println("Thank you for returning the book.");
					book.setAvailability(true);

				}
				break;
			}
			case 5: {
				// Display books
				line();
				System.out.println("What do you want to do? \n" + "\t1- Display all books. \n"
						+ "\t2- Display books for sale. \n" + "\t3- Display books for borrowing. \n"
						+ "\t4- Display books by level. \n" + "\t5- Display books by title. \n");
				int c = input.nextInt();
				switch (c) {
				case 1:
					shelve.displayAllBooks();
					break;
				case 2:
					printList(shelve.getBooksForSale());
					break;
				case 3:
					printList(shelve.getBooksForBorrow());
					break;
				case 4:
					System.out.print("Choose the level from 1 to 10:");
					int level = input.nextInt();
					printList(shelve.getBooksByLevel(level));
					break;
				case 5:
					System.out.print("Enter the book title:");
					String title = input.nextLine();
					title = input.nextLine();
					printList(shelve.getBooksByName(title));
					break;
				default:
					line();
				}
				break;
			}
			case 6: {
				// Update your info
				System.out.println("Your current information are:\n" + "Name| " + name + " ID| " + userId + " Level| "
						+ userLvl + " Phone number| " + phone + " Email| " + email);

				System.out.print("What do you want to update:\n" + "\t1-Phone Number\n" + "\t2-Email\n" + "\t3-Level");
				int c = input.nextInt();

				switch (c) {
				case 1:
					System.out.println("Enter your new phone number:");
					phone = input.next();
					if (currentOwner != -1)
						user.get(currentOwner).setPhone(phone);
					if (currentBuyer != -1)
						user.get(currentOwner).setPhone(phone);
					if (currentBorrower != -1)
						user.get(currentOwner).setPhone(phone);
					break;
				case 2:
					System.out.println("Enter your new email address");
					email = input.next();
					if (currentOwner != -1)
						user.get(currentOwner).setEmail(email);
					if (currentBuyer != -1)
						user.get(currentOwner).setEmail(email);
					if (currentBorrower != -1)
						user.get(currentOwner).setEmail(email);
					break;
				case 3:
					System.out.println("Enter your new level");
					userLvl = input.nextInt();
					if (currentOwner != -1)
						user.get(currentOwner).setLevel(userLvl);
					if (currentBuyer != -1)
						user.get(currentOwner).setLevel(userLvl);
					if (currentBorrower != -1)
						user.get(currentOwner).setLevel(userLvl);
					break;
				default:
					System.out.print("Invalid entry.");
				}
				break;
			}
			case 7:
				break;

			default:
				System.out.println("Wrong entry. Please choose from the list provided :)!");
				line();
			}

		} while (choice != 7);

	}

	static void admin_system() {
int choice;
do {
    System.out.print(admin_menu);
    choice = input.nextInt();
    switch (choice) {
			case 1:
				// Received money

				System.out.print("Enter the owner ID:");
				String ownerId = input.next();
				boolean flag = false;

				for (int i = 0; i < getOwners(user).size(); i++)
					if (((getOwners(user)).get(i).getAcademicNum()).equals(ownerId)) {
						(getOwners(user)).get(i).setGotPaid(true);
						System.out.print(getOwners(user).get(i).getName() + " has received her money.");
						flag = true;
						break;
					}
				if (!flag) {
					System.out.print("Invalid Academic Number.");
				}

				break;
			case 2:
				// remove book
				Book book = getTheBook();
				if (book != null && shelve.removeBook(book))
					System.out.println("Book removed successfuly..");
				else
					System.out.println("Ops.. Some error maybe wrong bookID entered.");

				break;
			case 3:
				// display book owned by user
				System.out.println("Please enter user academic id number: ");
				String id = input.next();
				Person p;
				if (isIDInList(id)) {
					p = getUser(id);
					if (p instanceof Owner)
						printList(shelve.getBooksOwnedBy(p));
				} else
					System.out.println("Invalid ID number...:(");
				break;
			case 4:
				System.out.println("Current balance= " + balance);
				break;
        case 5:
        // update book info
            book = getTheBook();
            if (book != null) {
            // Book(String title, String courseID, int level, Person
            // owner, boolean
            // availability, double price, String status)
                System.out.println("Choose which information you would like to update:" + "\n\t1-Book Title"
                                    + "\n\t2-Book's level" + "\n\t3-Book's Owner" + "\n\t4-Book's availability"+ "\n\t5-Book's price"
                                    + "\n\tYour choice: ");
                choice = input.nextInt();
                switch (choice) {
                // change title
                    case 1:
                        System.out.println("The new title : ");
                        String title =input.nextLine();
                        title =input.nextLine();
                        book.setTitle(title);
                        break;
                // change level
                    case 2:
                        int lv;    
                        do{
                            System.out.println("The new level (choose from 1 to 10 levels): ");
                            lv = input.nextInt();
                            if ((lv <= 10)&&(lv >= 0)){
                                book.setLevel(lv);
                                break;}
                            else 
                                System.out.println("Ooops .. invalid level !!");
                            }while(true);
                        break;
                // change owner
                    case 3:
                        String yesORno;
                        do{
                            System.out.println("Is prevouse owner ? (yes/no)");
                            yesORno = input.next();
                            if((yesORno.equalsIgnoreCase("yes")) ||(yesORno.equalsIgnoreCase("no")) ){
                                if (yesORno.equalsIgnoreCase("yes")) {
                                    boolean isHeHere;
                                    do {
                                        System.out.println("Please enter user academic id number: ");
                                        String oid = input.next();
                                        isHeHere = isIDInList(oid);
                                        if (isHeHere) {
                                            book.setOwner(getUser(oid));
                                        }else {
                                            System.out.println("Oooops .. must ID is wrong !!");
                                                }
                                        } while (!isHeHere);
                                    break;
                                }
                                else if (yesORno.equalsIgnoreCase("no")) {
                                    getUserInformation();
                                    user.add(new Person(name, userId, userLvl, phone, email));
                                    book.setOwner(user.get(user.size() - 1));
                                    break;}}
                                else 
                                    System.out.println("Ooops .. invalid input !!");
                        }while(true);
                    break;
                // change Availability
                    case 4:
                        String available;
                        do{
                            System.out.println("IS it available ? (yes/no)");
                            available = input.next();
                            if((available.equalsIgnoreCase("yes")) ||(available.equalsIgnoreCase("no")) ){
                                if (available.equalsIgnoreCase("yes")) {
                                    book.setAvailability(true);
                                    break;
                                } else if (available.equalsIgnoreCase("no")) {
                                    book.setAvailability(false);
                                    break;
                                }}
                                else
                                    System.out.println("Ooops .. invalid input !!");
                            }while(true);
                        break;
                // change price
                    case 5:
                        System.out.println("The new price : ");
                        int prc = input.nextInt();
                        book.setPrice(prc);
                        break;
                        }
                System.out.println("The updated book's information: " + book);
                line();
                }
            break;
        case 6:
        // display users information
            System.out.print("Which users do you want to display?\n" + "\t1-Owners" + "\t2-Buyers" + "\t3-Borrowers"
                            + "\t4-All users");
            int c = input.nextInt();
            switch (c) {
                case 1:
                    for (Owner o : getOwners(user))
                        System.out.println(o);
                    break;
                case 2:
                    for (Buyer b : getBuyers(user))
                        System.out.println(b);
                    break;
                case 3:
                    for (Borrower w : getBorrowers(user))
                        System.out.println(w);
                    break;
                case 4:
                    for (Person per : user)
                        System.out.println(per);
                    break;
                default:
                    System.out.println("Invalid entry.");
                }
            line();
            break;
        case 7:
            line();
            break;
        default:
            line();
        }
    } while (choice != 7);
        }

	// takes academic number and return the owner object..
	private static Person getUser(String id) {
		for (int j = 0; j < user.size(); j++) {
			Person p = user.get(j);
			if (p.getAcademicNum().equals(id))
				return p;
		}
		return null;
	}

	static public ArrayList<Owner> getOwners(ArrayList<Person> user) {
		ArrayList<Owner> owner = new ArrayList<>();
		for (int i = 0; i < user.size(); i++)
			if (user.get(i) instanceof Owner)
				owner.add((Owner) user.get(i));

		return owner;
	}

	static public ArrayList<Buyer> getBuyers(ArrayList<Person> user) {
		ArrayList<Buyer> buyer = new ArrayList<>();
		for (int i = 0; i < user.size(); i++)
			if (user.get(i) instanceof Buyer)
				buyer.add((Buyer) user.get(i));

		return buyer;
	}

	static public ArrayList<Borrower> getBorrowers(ArrayList<Person> user) {
		ArrayList<Borrower> borrower = new ArrayList<>();
		for (int i = 0; i < user.size(); i++)
			if (user.get(i) instanceof Borrower)
				borrower.add((Borrower) user.get(i));

		return borrower;
	}

	// to add books before displaying the lists..
	static public void fillShelve() {
		// Book(String title, String courseID, int level, Person owner, boolean
		// availability, double price, String status)
		// Person(String name,String academicNum,int level, String phone,String
		// email){
		user.add(new Person("Admin", "11111", 0, "05050505", "admin@kaff.com"));
		user.add(new Person("Admin2", "11122", 0, "05050505", "admin@kaff.com"));
		shelve.addBook(new Book("Introduction to Computing", "CS101", 3, user.get(user.size()-1), true, 200, "Sale"));
		shelve.addBook(new Book("Network", "CIS315", 5, user.get(user.size()-1), true, 200, "Sale"));
		shelve.addBook(new Book("Logic and proof", "Math314", 7, user.get(user.size()-1), true, 0, "Borrow"));
		shelve.addBook(new Book("Operating Systems", "CS999", 9, user.get(user.size()-1), true, 0, "Borrow"));
		shelve.addBook(new Book("Discrete Mathematics", "Math313", 5, user.get(user.size()-1), true, 400, "Sale"));

	}

	static public void line() {
		System.out.println("_____________________________________________________");
	}

	// asks user for the book id and returns the book ..
	static public Book getTheBook() {
		Book book = null;
		do {
			System.out.println("Please enter the id of the book or / to go back:");
			String bookID = input.next();
			if (bookID.equals("/"))
				break;
			book = shelve.getBook(bookID);
			if (book == null)
				System.out.println("The book ID is not avaiable.");
		} while (book == null);
		return book;
	}

	private static void printList(ArrayList<Book> list) {
		for (Book b : list)
			System.out.println(b);
	}

	static public boolean isIDInList(String userID) {
		for (int j = 0; j < user.size(); j++)
			if (userID.equals(user.get(j).getAcademicNum()))
				return true;
		return false;
	}

	private static void getUserInformation() {
		System.out.println("Enter your following information:");
		System.out.println("Name: ");
		name = input.nextLine();
		name = input.nextLine();
		System.out.println("Academic Number: ");
		userId = input.nextLine();
		do {
			if (isIDInList(userId)) {
				System.out.println("The user with this ID is in list..Please enter another ID..");
				userId = input.nextLine();
			} else {
				break;
			}
		} while (true);
		System.out.println("Level: ");
		userLvl = input.nextInt();
		do {
			if (userLvl > 10 || userLvl < 0) {
				System.out.println("Must be between 1 and 10...Please enter a valid number..");
				userLvl = input.nextInt();
			} else {
				break;
			}
		} while (true);
		System.out.println("Phone Number: ");
		phone = input.nextLine();
		phone = input.nextLine();
		if (phone.length() < 0 || phone.length() < 10) {
			System.out.println("Invalid number..make sure to change it from menu.");
			phone = "0000000000";
		} else {
			for (int i = 0; i < phone.length(); i++) {
				if (!Character.isDigit(phone.charAt(i))) {
					System.out.println("Invalid number..make sure to change it from menu.");
					phone = "0000000000";
					break;
				}
			}
		}
		System.out.println("Email: ");
		email = input.next();
		do {
			if (email.contains("@") && email.contains(".")) {
				System.out.println("valid email..");
				break;
			} else {
				System.out.println("Please enter a valid email..");
				email = input.next();
			}
		} while (true);
	}

}