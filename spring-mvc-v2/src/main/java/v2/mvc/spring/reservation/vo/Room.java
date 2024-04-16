package v2.mvc.spring.reservation.vo;

import org.springframework.stereotype.Component;

@Component
public class Room {
    private String roomNumber;
    private String roomStatus;

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }
    
    @Override
    public String toString() {
        return "Room [roomNumber=" + roomNumber + ", roomStatus=" + roomStatus + "]";
    }
}