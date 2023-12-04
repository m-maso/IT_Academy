package n3ex01;

import java.util.ArrayList;

import n3ex01.Exceptions.FreeSeatException;
import n3ex01.Exceptions.TakenSeatException;


public class SeatManagement {
	
	//attrib
	private ArrayList<Seat> seats;
	
	//constr
	public SeatManagement() {
		this.seats = new ArrayList<Seat>();
	}
	
	//getter
	public ArrayList<Seat> getSeats(){
		return this.seats;
	}
	
	//methods
	public void addSeat(Seat actualSeat) throws TakenSeatException {
		int seatIndex = findSeat(actualSeat.getRowNum(), actualSeat.getSeatNum());
		if(seatIndex  == -1) {
			seats.add(actualSeat);
			System.out.println("Seat added successfully\n");
		} else {
			throw new TakenSeatException("This seat is already taken\n");
		}	
	}
	
	public void delSeat(int actualRow, int actualSeat) throws FreeSeatException {
		int seatIndex = findSeat(actualRow, actualSeat);
		if(seatIndex == -1) {
			throw new FreeSeatException("This seat is alredy free, we can delete it\n");
		} else {
			seats.remove(seatIndex);
			System.out.println("Seat has been deleted successfully\n");
		}
	}
	
	public int findSeat(int actualRow, int actualSeat) {
		boolean found = false;
		int i = 0;
		int seatInd = -1;

		while(i < seats.size() && !found) {
			if((actualRow == seats.get(i).getRowNum()) && (actualSeat == seats.get(i).getSeatNum()) ) {
				seatInd = i;
				found = true;	
			} 
			i++;
		}
		return seatInd;
		
	}
	
}
