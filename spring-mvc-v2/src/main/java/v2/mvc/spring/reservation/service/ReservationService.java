package v2.mvc.spring.reservation.service;

import java.util.HashMap;
import java.util.Map;


public interface ReservationService {

	boolean create(Map<String, Object> map);
	
	boolean readRoom(String roomStatus);
	
	String createReservation(HashMap<String, Object> map);
	
}
