public class Book {
	
	static public int noBooks=0;
	private String title;
	private String bookID;
	public String courseID;
	public int level;
	private Person owner;
	private Boolean availability;
	private double price;
	private String status;
	
	public Book()
	{
		noBooks++;
	}
	
	public Book(String title, String courseID, int level, Person owner, 
                boolean availability, double price, String status)
	{
		noBooks++;
		bookID=noBooks+courseID;
		this.title=title;
		this.courseID=courseID;
		this.level=level;
		this.owner=owner;
		this.availability=availability;
		this.price=price;
		this.status=status;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public void setBookID(String bookID) {
		this.bookID=bookID;
	}
	
	public void setOwner(Person owner) {
		this.owner=owner;
	}

	public void setAvailability(Boolean availability) {
		this.availability=availability;
	}
	
	public void setPrice(double price) {
		this.price=price;
	}
	
	public void setStatus(String status) {
		this.status=status;
	}

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public void setLevel(int level) {
        this.level = level;
    }
        
	
	public String getTitle()
	{
		return title;
	}
	
	public String getBookID()
	{
		return bookID;
	}
	
	public Person getOwner()
	{
		return owner;
	}
	
	public Boolean getAvailability()
	{
		return availability;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public String status()
	{
		return status;
	}
	
	@Override
	public String toString()
	{
		return ( "BookID: "+bookID+ " | Book Title: "+title+
				" | CourseID: "+courseID+" | Level: "+level+
				" | Owner Name: "+owner.getName()+" | Availability: "+availability );
	}
}
