package n3ex01.ConcreteCommands;

import n3ex01.Command;
import n3ex01.Vehicle;

public class SpeedUpCommand implements Command {

	private Vehicle vehicle;
	
	
	public SpeedUpCommand(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
	@Override
	public void execute() {
		vehicle.speedUp();
	}

}
