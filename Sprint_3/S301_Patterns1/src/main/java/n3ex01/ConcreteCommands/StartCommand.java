package n3ex01.ConcreteCommands;

import n3ex01.Command;
import n3ex01.Vehicle;

public class StartCommand implements Command {

	private Vehicle vehicle;
	
	
	public StartCommand(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
	@Override
	public void execute() {
		vehicle.start();
	}

}
