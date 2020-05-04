import java.util.Date;

class Borrower extends Person{
    
     	private boolean reternedState;
     	private Date retrnDate;
        
    	public Borrower() {
    	}
    	public Borrower(String n,String id,int level,String phone,String email, Date retrnDate) {
        	super(n,id,level,phone,email);
        	this.retrnDate = retrnDate;
    	}
        
    	public boolean isReternedState() {
        	return reternedState;
    	}
    	public Date getRetrnDate() {
        	return retrnDate;
    	}
        
        
    	public void setReternedState(boolean reternedState) {
        	this.reternedState = reternedState;
    	}
    	public void setRetrnDate(Date retrnDate) {
        	this.retrnDate = retrnDate;
    	}
        
    	@Override
    	public String toString() {
        	return super.toString()+ " | Reterned State: " + reternedState +
                        " | Return Date: " + retrnDate ;
    	}


}
