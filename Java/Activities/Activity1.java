package Activity;

public class Activity1 {
	public static void main(String[] args) {
		// Create the Car object
		Car object = new Car("Black", "Manual", 2024);
		
		// Use the object to call its functions
		object.displayCharacteristics();
		object.accelarate();
		object.brake();
	}
}