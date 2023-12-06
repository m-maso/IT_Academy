package n3ex01;

public class Bike extends Vehicle {

	public Bike(String vehTtype, String model) {
		super(vehTtype, model);
	}

	@Override
	public void start() {
		if(this.speed <= 0) {
			this.speed += 5;
			System.out.println("The " + super.getModel() + " has start up. You're pedalling at " + this.speed + "km/h");
		} else {
			System.out.println("You're already pedalling your" + super.getModel());
		}
	}

	@Override
	public void speedUp() {
		if(this.speed >= 5) {
			this.speed +=10;
		System.out.println("The " + super.getModel() + " is speeding up. You're pedalling at " + this.speed + "km/h");		
		} else {
			System.out.println("You need to start pedalling your " + super.getModel() + " first.");
		}
	}

	@Override
	public void brake() {
		if(this.speed > 10) {
			this.speed -= 10;
			System.out.println("The " + super.getModel() + " is putting on the brakes. You're pedalling at " + this.speed + "km/h");
		} else if(this.speed == 5) {
			this.speed = 0;
			System.out.println("The " + super.getModel() + " it just has stopped.");
		} else {
			System.out.println("Before put on the brakes, you need to start pedaling your " + super.getModel());
		}
	}

}
