package n3ex01;

public class Car extends Vehicle {

	public Car(String vehTtype, String model) {
		super(vehTtype, model);
	}

	@Override
	public void start() {
		if(this.speed <= 0) {
			this.speed += 15;
			System.out.println("The " + super.getModel() + " has start up. It's driving at " + this.speed + "km/h");
		} else {
			System.out.println("The engine of the " + super.getModel() + " is already started.");
		}
	}

	@Override
	public void speedUp() {
		if(this.speed >= 15) {
			this.speed +=20;
			System.out.println("The " + super.getModel() + " is speeding up. It's driving at " + this.speed + "km/h");
		} else {
			System.out.println("You need to start the engine of the " + super.getModel() + " first.");
		}
	}

	@Override
	public void brake() {
		if(this.speed > 20) {
			this.speed -= 20;
			System.out.println("The " + super.getModel() + " is slowing down. It's driving at " + this.speed + "km/h");
		} else if(this.speed == 15) {
			this.speed = 0;
			System.out.println("The " + super.getModel() + " it just has stopped.");
		} else {
			System.out.println("Before braking, you need to start the engine of the " + super.getModel() + " first.");
		}
	}

}
