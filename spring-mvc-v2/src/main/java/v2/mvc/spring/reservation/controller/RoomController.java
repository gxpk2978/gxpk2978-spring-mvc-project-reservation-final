package v2.mvc.spring.reservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import v2.mvc.spring.reservation.service.RoomService;
import v2.mvc.spring.reservation.vo.Room;

import java.util.List;

@Controller
public class RoomController {
    
    @Autowired
    private RoomService roomService;

    @GetMapping("/reservation/reservation/{custom_id}")
    public String getAllRooms(@PathVariable String custom_id, Model model) {
		System.out.println("룸 겟 성공");

        List<Room> rooms = roomService.getAllRooms();
        System.out.println(rooms+ "room" );
        model.addAttribute("rooms", rooms);
        

        return "/reservation/reservation"; // 해당 뷰의 이름
    }
}