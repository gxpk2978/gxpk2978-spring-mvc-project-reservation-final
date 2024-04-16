package v2.mvc.spring.reservation.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import v2.mvc.spring.reservation.vo.Room;
@Mapper
public interface RoomMapper {
	  List<Room> getAllRooms();
}
