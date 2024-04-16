package v2.mvc.spring.reservation.service.Impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import v2.mvc.spring.reservation.dao.ReservationDAO;
import v2.mvc.spring.reservation.service.ReservationService;

@Service
public class reservationServiceImpl implements ReservationService {
	@Autowired
	private ReservationDAO reservationDAO;
	
	//회원가입
	@Override
	public boolean create(Map<String, Object> map) {
	
		return reservationDAO.insert(map);
	}

	

	//예약 생성
	@Override
	public String createReservation(Map<String, Object> map) {
		
		return reservationDAO.createReservation(map);
	}


	//로그인 조회
	@Override
	public boolean logInRead(Map<String, Object> map) {
		
		return reservationDAO.logInRead(map);
	}



	@Override
	public Map<String, Object> totalRead(String customer_id) {
		
		return reservationDAO.totalRead(customer_id);
	}



	@Override
	public boolean reservationUpdate(Map<String, Object> map) {
		
		return reservationDAO.reservationUpdate(map);
	}



	@Override
	public boolean reservationDelete(String roomNumber) {
		// TODO Auto-generated method stub
		return  reservationDAO.reservationDelete(roomNumber);
	}








	

}
