package v2.mvc.spring.reservation.service.Impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import v2.mvc.spring.reservation.dao.ReservationDAO;
import v2.mvc.spring.reservation.service.ReservationService;

@Service
public class reservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationDAO reservationDAO;
	
	
	@Override
	public boolean create(Map<String, Object> map) {
	
		return reservationDAO.insert(map);
	}

	//룸조회
	@Override
	public boolean readRoom(String roomStatus) {
		
		return reservationDAO.selectOneRoom(roomStatus);
	}

	//예약 생성
	@Override
	public String createReservation(HashMap<String, Object> map) {
		
		return reservationDAO.createReservation(map);
	}

}
