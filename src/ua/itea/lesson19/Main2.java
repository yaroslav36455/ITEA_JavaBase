package ua.itea.lesson19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Main2 {

	public static void main(String[] args) {
		Passenger passenger1 = new Passenger("A1", "A2", "23", "039457", null);
		Passenger passenger2 = new Passenger("A1", "A2", "56", "323457", null);
		Passenger passenger3 = new Passenger("A1", "A2", "89", "239495", null);

		GunselPassenger gunselPassenger1 = new GunselPassenger("A1", "A2", "23", "039457", "45");
		GunselPassenger gunselPassenger2 = new GunselPassenger("A1", "A2", "56", "323457", "34");
		GunselPassenger gunselPassenger3 = new GunselPassenger("A1", "A2", "89", "239495", "5");
		
		ArrayList<Passenger> passengers = new ArrayList<>();
		ArrayList<GunselPassenger> gunselPassengers = new ArrayList<>();
		
		passengers.add(passenger1);
		passengers.add(passenger2);
		passengers.add(passenger3);
		
		gunselPassengers.add(gunselPassenger1);
		gunselPassengers.add(gunselPassenger2);
		gunselPassengers.add(gunselPassenger3);
		
//		for(Passenger passenger : passengers) {
//			Iterator<GunselPassenger> iter = gunselPassengers.iterator();
//			while(iter.hasNext()) {
//				GunselPassenger gunselPassenger = iter.next();
//			
//				if (gunselPassenger.getFirstName().equals(passenger.getFirstName())
//						&& gunselPassenger.getLastName().equals(passenger.getLastName())) {
//					passenger.setNumberTicket(gunselPassenger.getTicketNumber());
//					iter.remove();
//					break;
//				}
//			}
//		}
		
		Map<String, GunselPassenger> gunselPassengersMap = new HashMap<>();
		for (GunselPassenger gunselPassenger : gunselPassengers) {
			gunselPassengersMap.put(gunselPassenger.getTicketNumber(), gunselPassenger);
		}
		
		System.out.println(passengers);
	}

}
