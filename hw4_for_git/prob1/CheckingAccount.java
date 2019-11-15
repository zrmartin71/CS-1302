package prob1;

public class CheckingAccount {
	protected double balance;
	protected int id;
	protected boolean isLowBalance;
	protected int numWithdrawals;
	
	public CheckingAccount(int id, double bal) {
		this.id= id;
		this.balance= bal;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public int getId() {
		return id;
	}
	
	public void deposit(double amt) {
		balance += amt;
	}
	
	public int getNumWithdrawals() {
		return numWithdrawals;
	}
	
	public boolean isLowBalance() {
		if(balance < 100) {
			return true;
		}
		
		return false;
	}
	
	public void withdraw(double amt) {
		balance -= amt;
		numWithdrawals++;
		
		if(balance < 100) {
			isLowBalance= true;
		}
		
		if(balance < 0 && numWithdrawals > 0) {
			balance-= 20;
		}
		
		if(balance > 0 && numWithdrawals >= 4) {
			balance -= 2;
		}
		
		if(balance < 0 && numWithdrawals >= 4) {
			balance-= 2;
		}
	}
	
	public void endOfMonth() {
		numWithdrawals= 0;
		
		if(balance >= 100) {
			isLowBalance= false;
		}
		
		if(isLowBalance == true) {
			balance -= 10;
			if(balance < 0) {
				balance-= 20;
			}
		}
		
	}
	
	public String toString(){
		return String.format("CA: Id= %d, Balance= $%,.2f, isLowBalance=%b, Num withdrawals=%d", id, balance, isLowBalance, numWithdrawals);
	}

}
