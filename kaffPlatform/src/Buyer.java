public class Buyer extends Person{
 
 public boolean pay;
 
 public Buyer() {
  
 }
 public Buyer(String BuyerName, String IDnumber, int lvl, String phoneNum, String e_mail, Boolean pay) {
  
  super(BuyerName,IDnumber,lvl, phoneNum, e_mail);
  this.pay=pay;
 }
 public Boolean getPay() {
  
  return pay;
 }
 public void setPay(Boolean pay) {
  this.pay=pay;
 }
 
 @Override
 public String toString() {
  return super.toString()+ " | Pay: "+ pay;
 }
 
}