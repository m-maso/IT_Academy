package n3ex01;

public class Seat {
	//attrib
	private int rowNum;
	private int seatNum;
	private String customer;
	
	//constr
	public Seat(int rowNum, int seatNum, String customer) {
		this.rowNum = rowNum;
		this.seatNum = seatNum;
		this.customer = customer;
	}
	
	//getters
	public int getRowNum() {
		return this.rowNum;
	}
	public int getSeatNum() {
		return this.seatNum;
	}
	public String getCustomer() {
		return this.customer;
	}
	
	//methods
	public boolean equals(Seat seat) {
		boolean equals = false;
		if((this.rowNum == seat.getRowNum()) && (this.seatNum == seat.getSeatNum())) {
			equals = true;
		}
		return equals;
	}
	
	@Override
	public String toString() {
		return "Row: " + this.rowNum + ", Seat: " + this.seatNum + ", Customer: " + this.customer;
	}
	
}
