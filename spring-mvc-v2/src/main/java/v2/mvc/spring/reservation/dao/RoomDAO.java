package v2.mvc.spring.reservation.dao;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import v2.mvc.spring.reservation.vo.Room;

@Repository
public class RoomDAO {
    
    @Autowired
    private SqlSessionTemplate sqlSessionTemplate;

    public List<Room> getAllRooms() {
    	
    	List<Room> result = sqlSessionTemplate.selectList("RoomMapper.getAllRooms");
  
        return result;

    }
    
    
    public boolean editRoomStatus(String number) {
    	
		
		int result = this.sqlSessionTemplate.update("RoomMapper.update" ,number); 
		//삽입성공 => 1 /// 실패 => 0    (리턴 :영향받은 행의 수)  
		
		if(result > 0 ) {
			
			System.out.println("룸상태 업데이트 성공");

			return true;
		}
		return false;
    	
    	
    }
    
    
    
    
    
    
}