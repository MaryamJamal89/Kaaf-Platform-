public class Owner extends Person{
    
	private boolean gotPaid;
	private boolean graduating;
        private int bookCount;
  
   public Owner()
   {
   	
   }
   
   public Owner(String Name,String OwnerID, int level, String phone,String email,
           boolean gotPaid,boolean graduating,int bookCount)
   {
	super(Name,OwnerID,level,phone,email);

   	this.gotPaid=gotPaid;
   	this.graduating=graduating;
        this.bookCount=bookCount;
   	
  	
   }
	public boolean isGotPaid() {
    	return gotPaid;
	}
	public int getBookCount() {
    	return bookCount;
	}
	public void setGotPaid(boolean gotPaid) {
    	this.gotPaid = gotPaid;
	}
	public void setBookCount(int bookCount) {
    	this.bookCount = bookCount;
	}
	
	public boolean isGrad()
	{
		return graduating;
	}
	
	public void setGrad(boolean g)
	{
		graduating=g;
	}
	
	public void incrmntBookCount()
	{
    	bookCount++;
	}
	public void decrmntBookCount()
	{
     	bookCount--;
	}
	
	@Override
	public String toString()
	{
    	return (super.toString() +" | Got Paid: "+gotPaid+" | Graduating: "+
                graduating+" | NoOfBooks: "+bookCount);
	}
}
