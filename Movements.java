// this class represnts movements 
public class Movements {
	private Movement []arr;
	private int current = 0;
	// Movements constructor
	public Movements(Movement []a) {
		arr = a;
	}
	
	// this function returns the next movement 
	public synchronized Movement allocateMov() {
		if(current >= arr.length) {
			return null;
		}
		return arr[current++];
	}
	
}
