package n3ex01;

import java.util.ArrayList;
import java.util.List;

// INVOKER - responsibility: start the requests

public class Invoker {

	private List<Command> commandsList = new ArrayList<Command>();
	
	public void takeCommand(Command command) {
		commandsList.add(command);
	}
	
	public void executeCommand() {
		for(Command command : commandsList) {
			command.execute();
		}
		commandsList.clear();
	}
}
