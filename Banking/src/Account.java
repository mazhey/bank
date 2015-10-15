import java.util.ArrayList;
//import java.util.Date;
//import java.util.Map;
//import java.util.TreeMap;



public class Account {
	private String accountNum;
	private String accountName;
	private double balance;
	private ArrayList<Transcation> transaction = new ArrayList<Transcation>(); 
	
	public Account(String accountNum,String accountName,double balance){
		this.setAccountName(accountName);
		this.setAccountNum(accountNum);
		this.setBalance(balance);
	}
	public String getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	public void addTranscation(Transcation transcation){
		transaction.add(transcation);
	}
     
	
	
	public void sortTransactions(){
		int i,j;
		for (i=0; i<transaction.size()-1; i++){
			for (j=i; j < transaction.size(); j++){
				if (transaction.get(i).getDate().getTime() > transaction.get(j).getDate().getTime()){
					Transcation temp = transaction.get(i);
					transaction.add(i,transaction.get(j));
					transaction.add(j,temp);
				}
					
			}
		}
	}
	
	
	public double calculateNewBalance(){
		double newBalance = this.getBalance();
		this.sortTransactions();
		for (int i=0; i<transaction.size(); i++){
			newBalance -= transaction.get(i).getAmount();
			if (newBalance < 0){
				newBalance -= 35;
			}
			
		}
		this.setBalance(newBalance);
		return newBalance;
	}
	
	public String getAccountTransaction(){
		String strAccount="";
		strAccount += this.accountNum + "\n";
		strAccount += this.accountName + "\n";
		strAccount += this.balance + "\n";
		for (int i=0; i<transaction.size(); i++){
			strAccount += transaction.get(i).history();
		}
		return strAccount;
	}
	
	
/*
	
    public TreeMap<Long, Double > sort(){
    	long differenceMS;
    
    	TreeMap<Long,Double> tempTransaction = new TreeMap<Long,Double>();
    	
    	for (int i=0; i<transaction.size(); i++){
    	differenceMS = transaction.get(i).compareTo();
    
    	tempTransaction.put(differenceMS, transaction.get(i).getAmount());
    	
 
    	}
    	return tempTransaction;
    	
	}
    
  public double calculate(){
	  TreeMap<Long, Double > transaction1 = new TreeMap<Long, Double >();
	  transaction1 = this.sort();
	  double newBalance = this.getBalance();
	  for (int i = 0; i<transaction1.size(); i++ ){
		
		  newBalance = newBalance -  transaction1.get(i);
		  if (newBalance < 0 ){
			  newBalance = newBalance - 35.0;
		  }
		  
	  }
	  this.setBalance(newBalance);
	  return   newBalance;
  }
*/
 
}
