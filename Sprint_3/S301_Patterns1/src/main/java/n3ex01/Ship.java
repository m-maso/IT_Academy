package n3ex01;

public class Ship extends Vehicle {

	public Ship(String vehTtype, String model) {
		super(vehTtype, model);
	}

	@Override
	public void start() {
		if(this.speed <= 0) {
			this.speed += 5;
			System.out.println("The " + super.getModel() + " is going to leave the port at the speed of " + this.speed + "knots");
		} else {
			System.out.println("The engine of the " + super.getModel() + " is already started.");
		}
	}

	@Override
	public void speedUp() {
		if(this.speed >= 5) {
			this.speed +=20;
			System.out.println("The " + super.getModel() + " is sailing faster, at " + this.speed + "knots");		
		} else {
			System.out.println("You need to start the engine of the " + super.getModel() + " first.");
		}
	}

	@Override
	public void brake() {
		if(this.speed > 20) {
			this.speed -= 20;
			System.out.println("The " + super.getModel() + " is slowing down. It's sailing at the speed of " + this.speed + "knots");
		} else if(this.speed == 5) {
			this.speed = 0;
			System.out.println("The " + super.getModel() + " it just has dock at the port.");
		} else {
			System.out.println("Before braking, you need to start the engine of the " + super.getModel() + " first.");
		}
	}

}
