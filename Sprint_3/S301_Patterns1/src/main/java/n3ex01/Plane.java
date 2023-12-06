package n3ex01;

public class Plane extends Vehicle {

	public Plane(String vehTtype, String model) {
		super(vehTtype, model);
	}

	@Override
	public void start() {
		if(this.speed <= 0) {
			this.speed += 25;
			System.out.println("The " + super.getModel() + " is going towards the runway at the speed of " + this.speed + "knots");
		} else {
			System.out.println("The engine of the " + super.getModel() + " is already started.");
		}
	}

	@Override
	public void speedUp() {
		if(this.speed >= 25) {
			this.speed +=100;
			System.out.println("The " + super.getModel() + " is cruising faster at " + this.speed + "knots");	
		} else {
			System.out.println("You need to start the engine of the " + super.getModel() + " first.");
		}
	}

	@Override
	public void brake() {
		if(this.speed > 100) {
			this.speed -= 100;
			System.out.println("The " + super.getModel() + " is slowing down. It's cruising at " + this.speed + "knots");
		} else if(this.speed == 25) {
			this.speed = 0;
			System.out.println("The " + super.getModel() + " it just has landed.");
		} else {
			System.out.println("Before braking, you need to start the engine of the " + super.getModel() + " first.");
		}
	}

}
