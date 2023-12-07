package n1ex01;

// OBSERVABLE / SUBJECT
public interface Observable {

	void subscribe(Brokerage observer);
	void unsubscribe(Brokerage observer);
	void notifyObservers();
}
