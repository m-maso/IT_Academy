package n1ex01;

// OBSERVER

public abstract class Brokerage {

	// Subject
	protected Broker subject;
	
	public Broker getSubject() {
		return subject;
	}

	// Method to set Subject
	public void setSubject(Broker subject) {
		this.subject = subject;
	}

	// Method used by Subject to notify them of any updates
	public abstract void update();
}
