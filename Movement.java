
// this class represnts  single movement that consisting of account number and sum 

public class Movement {
	private int accNum;
	private int sum;
	
	// Movement constructor
	public Movement(int accNum, int sum) {
		super();
		this.accNum = accNum;
		this.sum = sum;
	}
	// get account number
	public int getAccNum() {
		return accNum;
	}
	// get sum 
	public int getSum() {
		return sum;
	}
	// set account number
	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}
	// set sum 
	public void setSum(int sum) {
		this.sum = sum;
	}
	
	
	
}
