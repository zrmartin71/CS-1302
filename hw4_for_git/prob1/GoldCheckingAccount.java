package prob1;

public class GoldCheckingAccount extends CheckingAccount{
	
	public GoldCheckingAccount(int id, double balance) {
		super(id,balance);
	}
		
	@Override
	public void withdraw(double amt) {
		balance -= amt;
		numWithdrawals++;
		
		if(balance < 1000) {
			isLowBalance= true;
		}
		
		if(balance < 0 && numWithdrawals > 0) {
			balance-= 20;
		}
		
		if(balance > 1000 && numWithdrawals >= 4) {
			balance -= 2;
		}
		
		if(balance < 1000 && numWithdrawals >= 4) {
			balance-= 2;
		}
	}
	
	@Override
	public void endOfMonth() {
		double interest= balance * 0.01;
		numWithdrawals= 0;
		
		if(balance >= 1000) {
			isLowBalance= false;
			balance += interest;
		}
		
		if(isLowBalance == true) {
			balance -= 10;
			if(balance < 1000) {
				balance-= 25;
			}
		}
		
	}
	
	public String toString(){
		return String.format("GCA: Id= %d, Balance= $%,.2f, isLowBalance=%b, Num withdrawals=%d", id, balance, isLowBalance, numWithdrawals);
	}
}
