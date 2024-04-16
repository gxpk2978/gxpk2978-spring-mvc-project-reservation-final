package v2.mvc.spring.reservation.service;

import java.util.Map;


public interface ReservationService {

	boolean create(Map<String, Object> map);
	

	
	String createReservation(Map<String, Object> map);

	boolean logInRead(Map<String, Object> map);

	
	Map<String, Object> totalRead(String customer_id);
	
	boolean reservationUpdate(Map<String, Object> map);
	
	boolean reservationDelete(String roomNumber);
	
}
