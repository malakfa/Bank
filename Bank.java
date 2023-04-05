import java.util.Random;

public class Bank {
	final static int NUMOFACC = 5;
	final static int NUMOFMOV = 10;

	public static void main(String[] args) {
		BankAccount[] bankAcc = initAcc();
		Movement[] mov = initMov();
		Movements m = new Movements(mov);
		/*Sometimes it gets stuck and this makes sense because the selection of transactions is done randomly, 
		 * and it is possible that all the operations are trying to attract money, 
		 * so all the processes will wait for a process that will save money and there will be no such process*/

		/* For the values ​​in the comment the program will not crash*/ 
		/*BankAccount[] bankAcc = new BankAccount[2];
		bankAcc[0]=new BankAccount(0,0);
		bankAcc[1]=new BankAccount(1,0);

		Movement[] mov = new Movement[5];
		mov[0] = new Movement(0,300);
		mov[1] = new Movement(0,-400);
		mov[2] = new Movement(0,600);
		mov[3] = new Movement(0,-600);
		mov[4] = new Movement(0,700);
		Movements m = new Movements(mov);*/

		BankTeller t1 = new BankTeller(m,bankAcc);
		BankTeller t2 = new BankTeller(m,bankAcc);
		BankTeller t3 = new BankTeller(m,bankAcc);
		BankTeller t4 = new BankTeller(m,bankAcc);
		BankTeller t5 = new BankTeller(m,bankAcc);
		BankTeller t6 = new BankTeller(m,bankAcc);
		BankTeller t7 = new BankTeller(m,bankAcc);
		BankTeller t8 = new BankTeller(m,bankAcc);
		BankTeller t9 = new BankTeller(m,bankAcc);
		BankTeller t10 = new BankTeller(m,bankAcc);

		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();

	}

	// initialize BankAccount array 
	private static BankAccount[] initAcc( ) {

		BankAccount[] bankAcc = new BankAccount[NUMOFACC];
		for(int i = 0 ; i < bankAcc.length ; i++) {
			bankAcc[i] = new BankAccount(i,0);
		}
		return bankAcc;
	}

	// initialize the movements in randomly way
	private static Movement[] initMov() {
		Movement[] m = new Movement[NUMOFMOV];
		Random rnd = new Random();
		for(int i = 0 ; i < NUMOFMOV ; i++) {
			int n1 = rnd.nextInt(1000);
			int n2 = -1 * n1;
			int temp;
			int option = rnd.nextInt(2);
			if(option == 0) {
				temp = n1;
			}
			else {
				temp = n2;
			}
			m[i] = new Movement(rnd.nextInt(5),temp);

		}
		return m;
	} 
}
