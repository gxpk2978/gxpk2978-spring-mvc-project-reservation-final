package v2.mvc.spring.reservation.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public class ReservationDAO {


	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public boolean insert(Map<String, Object> map) {
		//여기서 insert는 mybatis 의 기능이고 매개변수로 매퍼패키지 해당id쿼리,해당 쿼리에 전달할 파라미터  
		int result = this.sqlSessionTemplate.insert("CUSTOMER.insert" ,map); 
		//삽입성공 => 1 /// 실패 => 0    (리턴 :영향받은 행의 수)  
		
		if(result > 0 ) {
			return true;
		}
		return false;
	}
	
	
	
	public String createReservation(Map<String, Object> map) {
		System.out.println("createReservation실행");
		int effect = this.sqlSessionTemplate.insert("RESERVATION.insert",map);
		
		System.out.println("삽입성공 : "+effect);
				if(effect > 0) {

				String result = (String) map.get("reservation_id");
				System.out.println("reservation_id : "+result);
					return result;
				}
				
		return "false";
		
	}
	
	
	
	public boolean logInRead(Map<String, Object> map) {
		
		System.out.println("map : "+map.get("customer_id"));
		Map<String, Object>  result = this.sqlSessionTemplate.selectOne("RESERVATION.selectOne", map);
		
		System.out.println("로그인조회 아이디 : "+result.get("CUSTOMER_ID"));

		if(result.get("CUSTOMER_ID").equals(map.get("customer_id"))) {
			
			return true;
		}
		
		
		return false;
	}
	
	
	
public Map<String, Object> totalRead(String customer_id) {
		
	
	System.out.println("customer_id : "+customer_id);
	
	Map<String, Object>  result = this.sqlSessionTemplate.selectOne("RESERVATION.selectOneTotal", customer_id);
	
	System.out.println("totalDetail : "+result);
	return result;
	}
	
	
	
	
public boolean reservationUpdate(Map<String, Object> map) {
	
		String customer_id = (String) map.get("custom_id");
		
		String preNumber = this.sqlSessionTemplate.selectOne("RESERVATION.getPreviousReservation", customer_id);
		map.put("oldRoomNumber", preNumber);
		System.out.println("수정하기 : map : "+map);
		String getNumber = (String) map.get("roomNumber");
		
		int updateRoomStatus=this.sqlSessionTemplate.update("RESERVATION.updateRoomStatus", preNumber);
		int updateRoomStatusToFull=this.sqlSessionTemplate.update("RESERVATION.updateRoomStatusToFull", getNumber);

		int  result = this.sqlSessionTemplate.update("RESERVATION.update", map);
		

		if(result>0) {
			System.out.println("수정 성공");
			return true;
		}
		
	return false;
	}
	
	
	
	
public boolean reservationDelete(String roomNumber) {
	
	int updateRoomStatus = this.sqlSessionTemplate.update("RESERVATION.updateRoomStatus", roomNumber);
	int deleteRecorde = this.sqlSessionTemplate.delete("RESERVATION.delete", roomNumber);
	
	
return false;
}

	
	
	
	
	
	
	
	
}
