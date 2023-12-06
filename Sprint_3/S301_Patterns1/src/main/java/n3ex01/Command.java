package n3ex01;

// COMMAND - declares an unique method to execute the command

@FunctionalInterface
public interface Command {
	void execute();
}
