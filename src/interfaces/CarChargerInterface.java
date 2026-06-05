package interfaces;

public interface CarChargerInterface {

	// POWER
	double PWR = 3.2d;
	
	void getProvider();
	
	default void getWatt() {
		System.out.println("getting watt numbers");
	}
	
}
