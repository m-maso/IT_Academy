package n3ex01;


public abstract class Vehicle implements Vehicles {

	private String vehTtype;
	protected String model;
	protected int speed;
	
	
	public Vehicle(String vehTtype, String model) {
		this.vehTtype = vehTtype;
		this.model = model;
		this.speed = 0;
	}	
	
	
	public String getVehTtype() {
		return vehTtype;
	}
	public String getModel() {
		return model;
	}
	public int getSpeed() {
		return speed;
	}
	
	public void setVehTtype(String vehTtype) {
		this.vehTtype = vehTtype;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}

	
	public abstract void start();
	public abstract void speedUp();
	public abstract void brake();

	@Override
	public String toString() {
		return "Vehicle: " + this.vehTtype + ", Model: " + this.model;
	}
}
