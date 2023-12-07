package n2ex01;

import java.util.Optional;

// STRATEGY - Payment Strategy
// TASK - it will execute the callback after the task execution has finished

public abstract class Payment {
	
	final void executeWith(Callback callback) {
		Optional.ofNullable(callback).ifPresent(Callback::call);
		execute();
	}
	
	public abstract void execute();
	
}
