package n3ex01;

import java.util.Scanner;

import n3ex01.Exceptions.FreeSeatException;
import n3ex01.Exceptions.IncorCustNameException;
import n3ex01.Exceptions.IncorRowException;
import n3ex01.Exceptions.IncorSeatException;
import n3ex01.Exceptions.TakenSeatException;

public class Cinema {
	static Scanner sc = new Scanner(System.in);
	
	// Attrib
	private int cRowsN;
	private int cSeatsXRowN;
	private SeatManagement seatMngm;
	
	// Constr
	public Cinema() {
		this.seatMngm = new SeatManagement();
		askStartingData();
	}
	
	// Setters
	public void setcRowsN(int cRowsN) {
		this.cRowsN = cRowsN;
	}
	public void setCSeatsXRowN(int cSeatsXRowN) {
		this.cSeatsXRowN = cSeatsXRowN;
	}

	
	//methods
	public void askStartingData() {
		System.out.println("CREATING CINEMA APP\n"
				+ "Cinema created successfully. Enter the first data of the cinema");
		System.out.println("Write the number of rows:");
		this.cRowsN = sc.nextInt();
//		this.setcRowsN(sc.nextInt());
		System.out.println("Write the number of seats per row:");
		this.cSeatsXRowN = sc.nextInt();
//		this.setCSeatsXRowN(sc.nextInt());
	}
	
	// Start
	public void start() {
		int option;
		
		do {
			option = menu();
			switch(option) {
				case 0: 
					System.out.println("You're leaving the app");
					break;
				case 1:
					showSeats();
					break;
				case 2:
					showCustSeats();
					break;
				case 3:
					seatBooking();
					break;
				case 4:
					cancelSeatBooking();
					break;
				case 5:
					cancelCustBooking();
					break;
				default:
					System.out.println("Error! Write a correct number between 0 and 5, please");
					break;
				}
			
		} while(option != 0);
	}
	
	// Menu
	public int menu() {
		int option;
		
		System.out.println("CINEMA BOOKING APP\n"
				+ "1.- Show all the booked seats\n"
				+ "2.- Show all the booked seats of the customer\n"
				+ "3.- Book a seat\n"
				+ "4.- Cancel a seat booking\n"
				+ "5.- Cancel all bookings of the customer\n"
				+ "0.- Leave app\n");
		option = sc.nextInt();
		sc.nextLine();
		
		return option;
	}
	
	// Methods of the menu options	
	/* 1.- Show all the booked seats */
	public void showSeats() {
		if(!seatMngm.getSeats().isEmpty()) {
			System.out.println("Here the list with the booked seats: ");
			for(Seat seat : seatMngm.getSeats()) {
				System.out.println(seat.toString());
			}
		} else {
			System.out.println("No booked seats in the cinema yet\n");
		}
	}
	
	/* 2.- Show all the booked seats of the customer */
	public void showCustSeats(){
		if(!seatMngm.getSeats().isEmpty()) {
			String custName;
			try {
				custName = enterCust();

				for(int i = 0; i < seatMngm.getSeats().size(); i++) {
					if(custName.equalsIgnoreCase(seatMngm.getSeats().get(i).getCustomer())){
						System.out.println(seatMngm.getSeats().get(i).toString());
					} 
				}
			} catch (IncorCustNameException e) {
				System.err.println(e.getMessage());
			}
		} else {
			System.out.println("No booked seats in the cinema yet\n");
		}
		
	}
	
	/* 3.- Book a seat */
	public void seatBooking()  {
		try {
			String custName = enterCust();
			int rowNum = enterRow();
			int seatNum = enterSeat();
			
	
			Seat seat = new Seat(rowNum, seatNum, custName);
			seatMngm.addSeat(seat);
		
		} catch(IncorRowException | IncorSeatException | IncorCustNameException | TakenSeatException e) {
			System.err.println(e.getMessage());
		}
	}
	
	/* 4.- Cancel a seat booking */
	public void cancelSeatBooking(){
		if(!seatMngm.getSeats().isEmpty()) {
			try {
				int rowNum = enterRow();
				int seatNum = enterSeat();
				
				seatMngm.delSeat(rowNum, seatNum);
			} catch(IncorRowException | IncorSeatException | FreeSeatException e) {
				System.err.println(e.getMessage());
			}
		} else {
			System.out.println("No booked seats in the cinema yet\n");
		}
	}
	
	/* 5.- Cancel all bookings of the customer */ 
	public void cancelCustBooking() {
		if(!seatMngm.getSeats().isEmpty()) {
	
			try {
				String custName = enterCust();
				
				for(int i = 0; i < seatMngm.getSeats().size(); i++) {
					if(custName.equalsIgnoreCase(seatMngm.getSeats().get(i).getCustomer())){
						seatMngm.getSeats().clear();
					}
				}
				System.out.println(custName + "booked seats have been deleted successfully\n");
				
			} catch (IncorCustNameException e) {
				System.err.println(e.getMessage());
			}
		} else {
			System.out.println("No booked seats in the cinema yet\n");
		}
	}
	
	// ENTER DATA METHODS
	//Enter customer
	public String enterCust() throws IncorCustNameException {
		String custName = "";
		System.out.println("Write the customer's name:");
		custName = sc.nextLine();
		for(int i =0; i < custName.length(); i++) {
			if(Character.isDigit(custName.charAt(i))) {
				throw new IncorCustNameException("The name of the customer can't contain any number\n");
			}
		}
		return custName;
	}
	
	// Enter row
	public int enterRow() throws IncorRowException {
		System.out.println("Write the number of the row:");
		int rowNumber = sc.nextInt();
		if((rowNumber < 1) && (rowNumber > this.cRowsN)) {
			throw new IncorRowException("This row number is incorrect\n");
		} 
		return rowNumber;
	}
	// Enter Seat
	public int enterSeat() throws IncorSeatException {
		System.out.println("Write the number of the seat:");
		int seatNumber = sc.nextInt();
		if((seatNumber < 1) && (seatNumber > this.cSeatsXRowN)) {
			throw new IncorSeatException("This seat number is incorrect\n");
		} 
		return seatNumber;
	}
	
	
}
