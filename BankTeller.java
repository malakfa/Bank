import java.util.Random;

// this class represnts a bank teller
public class BankTeller extends Thread{

	private BankAccount []accounts;
	private Movements m;
	final int TIME = 100;
	// BankTeller constructor
	public BankTeller(Movements m ,BankAccount []accounts ){
		this.m = m;
		this.accounts =accounts;
		
	}
	
	@Override
	public void run() {
		super.run();
		Random rnd = new Random();
		
		Movement mov = m.allocateMov();
		while(mov != null) {
			for(int i = 0 ; i < accounts.length ; i++) {
				if(mov.getAccNum() == accounts[i].getAccountNum()) {
					accounts[i].transaction(mov.getSum());
					break;
				}
			}
			try {
				sleep(rnd.nextInt(TIME));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			mov = m.allocateMov();
			
		}
		
	}
}
