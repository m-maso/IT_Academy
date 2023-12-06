package n3ex01;

import java.util.ArrayList;
import java.util.List;

import n3ex01.ConcreteCommands.BrakeCommand;
import n3ex01.ConcreteCommands.SpeedUpCommand;
import n3ex01.ConcreteCommands.StartCommand;

// CLIENT

public class App {

	public static void main(String[] args) {
		
		
		List<Vehicle> parking = new ArrayList<Vehicle>();
		
		// Vehicles' instances
		parking.add(new Car("Car","Honda Civic"));
		parking.add(new Bike("Bike","Mountain bike"));
		parking.add(new Plane("Plane", "Airbus A380"));
		parking.add(new Ship("Ship","Cruise ship"));
		
		
		// Invoker class instance
		Invoker invoker = new Invoker();
		
		// Car
		System.out.println("\nCar example: ");
		invoker.takeCommand(new StartCommand(parking.get(0)));
		invoker.takeCommand(new SpeedUpCommand(parking.get(0)));
		invoker.takeCommand(new SpeedUpCommand(parking.get(0)));
		invoker.takeCommand(new BrakeCommand(parking.get(0)));
		invoker.takeCommand(new BrakeCommand(parking.get(0)));
		invoker.takeCommand(new BrakeCommand(parking.get(0)));
		invoker.takeCommand(new BrakeCommand(parking.get(0)));
		invoker.executeCommand();
		
		// Bike
		System.out.println("\nBike example: ");
		invoker.takeCommand(new BrakeCommand(parking.get(1)));
		invoker.takeCommand(new StartCommand(parking.get(1)));
		invoker.takeCommand(new SpeedUpCommand(parking.get(1)));
		invoker.takeCommand(new SpeedUpCommand(parking.get(1)));
		invoker.takeCommand(new BrakeCommand(parking.get(1)));
		invoker.takeCommand(new BrakeCommand(parking.get(1)));
		invoker.takeCommand(new BrakeCommand(parking.get(1)));
		invoker.executeCommand();
		
		// Plane
		System.out.println("\nPlane example: ");
		invoker.takeCommand(new StartCommand(parking.get(2)));
		invoker.takeCommand(new SpeedUpCommand(parking.get(2)));
		invoker.takeCommand(new SpeedUpCommand(parking.get(2)));
		invoker.takeCommand(new SpeedUpCommand(parking.get(2)));
		invoker.takeCommand(new SpeedUpCommand(parking.get(2)));
		invoker.takeCommand(new BrakeCommand(parking.get(2)));
		invoker.takeCommand(new BrakeCommand(parking.get(2)));
		invoker.takeCommand(new BrakeCommand(parking.get(2)));
		invoker.takeCommand(new BrakeCommand(parking.get(2)));
		invoker.takeCommand(new BrakeCommand(parking.get(2)));
		invoker.executeCommand();
		
		//Ship
		System.out.println("\nShip example:");
		invoker.takeCommand(new BrakeCommand(parking.get(3)));
		invoker.takeCommand(new StartCommand(parking.get(3)));
		invoker.takeCommand(new SpeedUpCommand(parking.get(3)));
		invoker.takeCommand(new SpeedUpCommand(parking.get(3)));
		invoker.takeCommand(new BrakeCommand(parking.get(3)));
		invoker.takeCommand(new BrakeCommand(parking.get(3)));
		invoker.takeCommand(new BrakeCommand(parking.get(3)));
		invoker.executeCommand();
		
		// Ship
		System.out.println("\nShip example(2) Another way:");
		anotherWay();
	}
	public static void anotherWay(){		// Ship
		Vehicle ship = new Ship("Ship", "Boat");
		
		// Commands
		Command startCom = new StartCommand(ship);
		Command speedupcom = new SpeedUpCommand(ship);
		Command brakeCom = new BrakeCommand(ship);
		
		// Invoker class instance
		Invoker shipInvkr = new Invoker();
		
		// Take command and Execute command
		shipInvkr.takeCommand(startCom);
		shipInvkr.takeCommand(speedupcom);
		shipInvkr.takeCommand(speedupcom);
		shipInvkr.takeCommand(speedupcom);
		shipInvkr.takeCommand(brakeCom);
		shipInvkr.takeCommand(brakeCom);
		shipInvkr.takeCommand(brakeCom);
		shipInvkr.takeCommand(brakeCom);
		shipInvkr.takeCommand(brakeCom);
		shipInvkr.executeCommand();
	}
}
