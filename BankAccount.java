
// this class represnts bank account that consisting of account number and remainder
public class BankAccount {
	private int accountNum;
	private int remainder;

	final int NUMOFDIGITS = 4;
	
	// BankAccount constructor
	public BankAccount(int accountNum, int remainder ){
		this.accountNum = accountNum;
		this.remainder = remainder;
	}
	// get remainder
	public int getRemainder() {
		return remainder;
	}
	// get Account number
	public int getAccountNum() {
		return accountNum;
	}
	
	// this function allows making deposits and withdrawals
	public void transaction(int sum) {
		if(sum >= 0)
			deposits(sum);
		else
			withdrawals(sum);
	}
	// deposits money
	private synchronized void deposits(int sum) {
		remainder += sum; 
		notifyAll();
		System.out.println( "Account" + accountNum + " after transaction "+ sum + ", remainder = " + remainder);
	}
	// withdrawals money
	private synchronized void  withdrawals(int sum) {
		while(remainder + sum < 0) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		remainder += sum; 
		System.out.println("Account" + accountNum + " after transaction "+ sum + ", remainder = " + remainder );
	}
}
