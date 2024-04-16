package v2.mvc.spring.reservation.service;


import v2.mvc.spring.reservation.dao.RoomDAO;
import v2.mvc.spring.reservation.vo.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomService {
    
    @Autowired
    private RoomDAO roomDAO;

    public List<Room> getAllRooms() {
        return roomDAO.getAllRooms();
    }
    
    
    
    public boolean roomEdit(String number) {
		return roomDAO.editRoomStatus(number);
	}
}