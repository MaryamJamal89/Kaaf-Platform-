public class Person {
    // data fields
    private String name = "";
    private String academicNum = "";
    private String phone = "";
    private String email = "";
    private int level = 0;
    
    // constructers
    Person(){
    }
    
    Person(String name,String academicNum,int level, String phone,String email){
    	this.name=name;
    	this.academicNum=academicNum;
    	this.phone=phone;
    	this.email=email;
    	this.level=level;
    }
    
    //getters
    public String getName() {
        return name;
    }

    public String getAcademicNum() {
        return academicNum;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getLevel() {
        return level;
    }

      
    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAcademicNum(String academicNum) {
        this.academicNum = academicNum;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    
    //to string
    @Override
    public String toString(){ 
        return " Name: "+name+" | Academic No: "+academicNum+" | Phone: "+phone+" | Email: "+email
            +" | Level: "+level;}   
    }
