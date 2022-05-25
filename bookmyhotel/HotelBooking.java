package bookmyhotel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


abstract class RoomType {
	List<Integer> roomIds = new ArrayList<Integer>();
	int total;
	//int total_booked; //No. of available rooms = total - total_booked
	Date checkinDate;
	Date checkoutDate;
	PAYMENT_STATUS status;
	//String image_url;
	
	abstract public boolean BookRoom(Date checkin, Date checkout);
	
	abstract public boolean GetRoomAvailibility(Date checkin, Date checkout);
	
	abstract public void GetRoomDetails();
	
}

enum PAYMENT_STATUS {PAID, PENDING}

// BASIC ROOM TYPE
class Basic extends RoomType{

	String Description;
	String CancellationPolicy;
	int cost_per_day;
	int capacity;

	Map<Date, Integer> Basic_Map = new HashMap<Date, Integer>(); //stores availability of rooms 
	
	// initialize room type
	Basic() throws ParseException{
		this.Description = "This is basic room Description";
		this.CancellationPolicy = " this is basic room CancellationPolicy";
		this.cost_per_day = 500;
		this.capacity = 3;
		this.total = 2;
		
		// Initialize Calender-map to store room availability. {Date: Max_rooms}
		int MAX_Days = 30; 
		
		LocalDate startDate = LocalDate.parse("2022-06-01");

		for(int i=0; i < MAX_Days; i++) {
			LocalDate newD = startDate.plusDays(i);
			Date d = new SimpleDateFormat("yyyy-MM-dd").parse(newD.toString());
			Basic_Map.put(d,total);
		}
		
	}
	

	public boolean BookRoom(Date checkin, Date checkout) {
		HelperFunctions hp = new HelperFunctions();
		
		if(GetRoomAvailibility(checkin, checkout) == true) {
			//add new bookingID to list
			int newid = roomIds.size() + 1;
			roomIds.add(newid);
			
			//update Map, decrement count of available rooms in the date range
			int duration = hp.getDuration(checkin, checkout);
			int currentRooms = 0;
			
			for(int i=0; i < duration; i++){
				Date nextDate = hp.addDays(checkin, i);
				currentRooms = Basic_Map.get(nextDate);
				Basic_Map.put(nextDate, currentRooms-1);
			}
			
			//Basic_Map.forEach((key, value) -> System.out.println(key + ":" + value)); // print map
			
			return true;
		}
		else
			return false;
	}
	
	public boolean GetRoomAvailibility(Date checkin, Date checkout) {
		//check for date range, by iterating through the map for the duration
		
		HelperFunctions hp = new HelperFunctions();
		
		int duration = hp.getDuration(checkin, checkout);
		
		for(int i=0; i < duration; i++){
			Date nextDate = hp.addDays(checkin, i);
			
			if(Basic_Map.get(nextDate)==0)
				return false;
		}
		return true;	
	}
	
	public void GetRoomDetails() {
		System.out.println("Basic Room Details");
		System.out.println("cost : $" + this.cost_per_day + " capcity: " + this.capacity);
	}
}

//DELUX ROOMTYPE
class Delux extends RoomType{

	String Description;
	String CancellationPolicy;
	int cost_per_day;
	int capacity;

	Map<Date, Integer> Delux_Map = new HashMap<Date, Integer>(); //stores availability of rooms 
	
	// initialize room type
	Delux() throws ParseException{
		this.Description = "This is delux room Description";
		this.CancellationPolicy = " this is delux room CancellationPolicy";
		this.cost_per_day = 1000;
		this.capacity = 5;
		this.total = 3;
		
		// Initialize Calender-map to store room availability. {Date: Max_rooms}
		int MAX_Days = 30; 
		
		LocalDate startDate = LocalDate.parse("2022-06-01");

		for(int i=0; i < MAX_Days; i++) {
			LocalDate newD = startDate.plusDays(i);
			Date d = new SimpleDateFormat("yyyy-MM-dd").parse(newD.toString());
			Delux_Map.put(d,total);
		}
		
	}
	

	public boolean BookRoom(Date checkin, Date checkout) {
		HelperFunctions hp = new HelperFunctions();
		
		if(GetRoomAvailibility(checkin, checkout) == true) {
			//add new bookingID to list
			int newid = roomIds.size() + 1;
			roomIds.add(newid);
			
			//update Map, decrement count of available rooms in the date range
			int duration = hp.getDuration(checkin, checkout);
			int currentRooms = 0;
			
			for(int i=0; i < duration; i++){
				Date nextDate = hp.addDays(checkin, i);
				currentRooms = Delux_Map.get(nextDate);
				Delux_Map.put(nextDate, currentRooms-1);
			}
			
			//Basic_Map.forEach((key, value) -> System.out.println(key + ":" + value)); // print map
			
			return true;
		}
		else
			return false;
	}
	
	public boolean GetRoomAvailibility(Date checkin, Date checkout) {
		//check for date range, by iterating through the map for the duration
		
		HelperFunctions hp = new HelperFunctions();
		
		int duration = hp.getDuration(checkin, checkout);
		
		for(int i=0; i < duration; i++){
			Date nextDate = hp.addDays(checkin, i);
			
			if(Delux_Map.get(nextDate)==0)
				return false;
		}
		return true;	
	}
	
	public void GetRoomDetails() {
		System.out.println("Delux Room Details");
		System.out.println("cost : $" + cost_per_day + " capcity: " + capacity);
	}
}


//SUIT ROOMTYPE
class Suit extends RoomType{

	String Description;
	String CancellationPolicy;
	int cost_per_day;
	int capacity;

	Map<Date, Integer> Suit_Map = new HashMap<Date, Integer>(); //stores availability of rooms 
	
	// initialize room type
	Suit() throws ParseException{
		this.Description = "This is suit room Description";
		this.CancellationPolicy = " this is suit room CancellationPolicy";
		this.cost_per_day = 5000;
		this.capacity = 6;
		this.total = 1;
		
		// Initialize Calender-map to store room availability. {Date: Max_rooms}
		int MAX_Days = 30; 
		
		LocalDate startDate = LocalDate.parse("2022-06-01");

		for(int i=0; i < MAX_Days; i++) {
			LocalDate newD = startDate.plusDays(i);
			Date d = new SimpleDateFormat("yyyy-MM-dd").parse(newD.toString());
			Suit_Map.put(d,total);
		}
		
	}
	

	public boolean BookRoom(Date checkin, Date checkout) {
		HelperFunctions hp = new HelperFunctions();
		
		if(GetRoomAvailibility(checkin, checkout) == true) {
			//add new bookingID to list
			int newid = roomIds.size() + 1;
			roomIds.add(newid);
			
			//update Map, decrement count of available rooms in the date range
			int duration = hp.getDuration(checkin, checkout);
			int currentRooms = 0;
			
			for(int i=0; i < duration; i++){
				Date nextDate = hp.addDays(checkin, i);
				currentRooms = Suit_Map.get(nextDate);
				Suit_Map.put(nextDate, currentRooms-1);
			}
			
			//Basic_Map.forEach((key, value) -> System.out.println(key + ":" + value)); // print map
			
			return true;
		}
		else
			return false;
	}
	
	public boolean GetRoomAvailibility(Date checkin, Date checkout) {
		//check for date range, by iterating through the map for the duration
		
		HelperFunctions hp = new HelperFunctions();
		
		int duration = hp.getDuration(checkin, checkout);
		
		for(int i=0; i < duration; i++){
			Date nextDate = hp.addDays(checkin, i);
			
			if(Suit_Map.get(nextDate)==0)
				return false;
		}
		return true;	
	}
	
	public void GetRoomDetails() {
		System.out.println("Suit Room Details");
		System.out.println("cost : $" + cost_per_day + " capcity: " + capacity);
	}
}

//Placeholder to store Guest details (not used for this example code)
class Guest {
	
	int GuestID;
	String FirstName;
	String LastName;
	Date dob;
	String address;
	private int CardDetail;
	
	Guest(int id, String fname, String lname){
		this.GuestID = id;
		this.FirstName = fname;
		this.LastName = lname;
	}
	
	public int getCardDetail() {
		return this.CardDetail;
	}
	
	public void setCardDetail(int cardDetail) {
		this.CardDetail = cardDetail;
	}  
	
	public void ViewGuestDetails() {
		System.out.println("GuestID: " + this.GuestID + "Name: " + this.FirstName + " " + this.LastName);
	}
	
}


public class HotelBooking {

	public static void main(String[] args) throws ParseException {
		
		//create rooms for all types
		Basic basicRoom = new Basic();
		Delux deluxRoom = new Delux();
		Suit suitRoom = new Suit();
		
		System.out.println("Welcome to Bookings.com!");
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.println("Enter check-in Date for June-2022 (yyyy-MM-dd): ");
			String inDate = sc.next();
			
			System.out.println("Enter check-out Date for June-2022 (yyyy-MM-dd): ");
			String outDate = sc.next();
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			
			HelperFunctions hp = new HelperFunctions();
			
			// validate date format
			while(hp.isValidFormat("yyyy-MM-dd", inDate)==false || hp.isValidFormat("yyyy-MM-dd", outDate)==false){
				System.out.println("Please enter valid date format! [yyyy-MM-dd]");
				
				System.out.println("Enter check-in Date for June-2022 (yyyy-MM-dd): ");
				inDate = sc.next();
				
				System.out.println("Enter check-out Date for June-2022 (yyyy-MM-dd): ");
				outDate = sc.next();
			}
			
			System.out.println("1. View Room Types and prices");
			System.out.println("2. View Room Availibility"); //based on date range
			System.out.println("3. Book Room");
			System.out.println("4. Change Dates");
			System.out.println("0: Exit");
			System.out.println("\nEnter option: ");
			
			int useroption = sc.nextInt();
			
			
			while(useroption != 0) {
				
				 switch(useroption) {
				
					case 1: basicRoom.GetRoomDetails();
							deluxRoom.GetRoomDetails();
							suitRoom.GetRoomDetails();
							break;
							
					case 2: 
							System.out.println("Enter room type to view availibility: 1:BASIC 2:DELUX 3:SUIT");
							int option = sc.nextInt();
							
							if(option==1) {
								if(basicRoom.GetRoomAvailibility(dateFormat.parse(inDate), dateFormat.parse(outDate)) == true) {
								
									System.out.println("This room is available. Do you want to book it now? (y)");
									
									char op = sc.next().charAt(0);
									if(op == 'y') {
										if(basicRoom.BookRoom(dateFormat.parse(inDate), dateFormat.parse(outDate)) == true)
											System.out.println("Congratulation room booked!");
									}
									else break;
								}
								else
									System.out.println("Oops! This room is not available.");
							}
							else if(option==2){
								if(deluxRoom.GetRoomAvailibility(dateFormat.parse(inDate), dateFormat.parse(outDate)) == true) {
									System.out.println("This room is available. Do you want to book it now? (y)");
									
									char op = sc.next().charAt(0);
									if(op == 'y') {
										if(suitRoom.BookRoom(dateFormat.parse(inDate), dateFormat.parse(outDate)) == true)
											System.out.println("Congratulation room booked!");
									}
									else break;
								}
								
								else
									System.out.println("Oops! This room is not available.");
							}
							else if(option==3){
								if(suitRoom.GetRoomAvailibility(dateFormat.parse(inDate), dateFormat.parse(outDate)) == true) {
									
									System.out.println("This room is available. Do you want to book it now? (y)");
									
									char op = sc.next().charAt(0);
									if(op == 'y') {
										if(suitRoom.BookRoom(dateFormat.parse(inDate), dateFormat.parse(outDate)) == true)
											System.out.println("Congratulation room booked!");
									}
									else break;
								}
									
								
								else
									System.out.println("Oops! This room is not available.");
							}
							else
								System.out.println("Enter valid room type!");
							break;
							
					case 3:
							System.out.println("Enter room type to book: 1:BASIC 2:DELUX 3:SUIT");
							option = sc.nextInt();
							
							if(option==1) {
								if(basicRoom.BookRoom(dateFormat.parse(inDate), dateFormat.parse(outDate)) == true) {
									// can extend to calling payment service
									System.out.println("Congratulation room booked!");
								}
								else
									System.out.println("Oops! This room type is fully booked. Try another date or roomtype");
							}
							else if(option==2) {
								if(deluxRoom.BookRoom(dateFormat.parse(inDate), dateFormat.parse(outDate)) == true) {
									// can extend to calling payment service
									System.out.println("Congratulation room booked!");
								}
								else
									System.out.println("Oops! This room type is fully booked. Try another date or roomtype");
							}
							else if(option==3) {
								if(suitRoom.BookRoom(dateFormat.parse(inDate), dateFormat.parse(outDate)) == true) {
									// can extend to calling payment service
									System.out.println("Congratulation room booked!");
								}
								else
									System.out.println("Oops! This room type is fully booked. Try another date or roomtype");
							}
							else
								System.out.println("Enter valid room type!");
							break;
					
					case 4: System.out.println("Enter new check-in Date (yyyy-MM-dd): ");
							inDate = sc.next();
					
							System.out.println("Enter new check-out Date (yyyy-MM-dd): ");
							outDate = sc.next();
							break;
							
					default: System.out.println("Enter valid option!"); //throw exception
				}
				
				System.out.println("Enter option: ");
				useroption = sc.nextInt();

			}
		}
		System.out.println("Exited from System..");
		
	}
	
}
