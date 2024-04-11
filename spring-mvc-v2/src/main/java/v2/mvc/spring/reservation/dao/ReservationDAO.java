package v2.mvc.spring.reservation.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	
	
	public boolean selectOneRoom(String roomStatus) {
		
		String result =this.sqlSessionTemplate.selectOne("ROOM.selectOne",roomStatus);
		System.out.println("룸조회실행 ");
		System.out.println(result);
		
		if(result.equals("empty") ) {
 			System.out.println("예약할 룸상태 : "+result);

			return true;
		}
		System.out.println("예약할 룸상태 : "+result);
		return false;
		
	}
	
	public String createReservation(HashMap<String, Object> map) {
		System.out.println("createReservation실행");
		int effect = this.sqlSessionTemplate.insert("RESERVATION.insert",map);
		System.out.println("삽입성공? : "+effect);
				if(effect > 0) {
					
				
				String result = (String) map.get("reservation_id");
				System.out.println("reservation_id : "+result);
					return result;

				}
				
		return "false";
		
	}
	
	
	
	
}
