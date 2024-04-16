package v2.mvc.spring.reservation.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

import v2.mvc.spring.board.service.Impl.BoardServiceImpl;
import v2.mvc.spring.reservation.service.ReservationService;
import v2.mvc.spring.reservation.service.RoomService;
import v2.mvc.spring.reservation.vo.Room;

@Controller
public class ReservationController {
	
	@Autowired
	private ReservationService ReservationService;
	
	@Autowired
    private RoomService roomService;

	
	
	@GetMapping(value="/createReservation")
	public String home() {
		System.out.println("기본화면으로 돌아가기");
		return "reservation/start";
	}
	
	@GetMapping(value="/reservation/signup")
	public String signup_get() {
		System.out.println("회원가입_GET");
		return "reservation/signup";
	}
	
	
	//로그인 조회하기
	@PostMapping(value="/createReservation")
	public String logIn(@RequestParam Map<String, Object> map) {
		
		System.out.println("로그인실행_post 매개변수 : "+map);
		
		boolean result = this.ReservationService.logInRead(map);
		String customer_id = (String) map.get("customer_id");
		if(result == true) {
			System.out.println("로그인 성공");
			
			return "redirect:/reservation/reservation/"+customer_id;
			
		}
		
		 return "redirect:/createReservation";
		
		
	}
		//회원가입 js 에서 데이터보내고 응답하기
	 	@ResponseBody
	    @RequestMapping(value = "/reservation/signup", method = RequestMethod.POST)
	    public HashMap<String, Object> signup_post(@RequestBody HashMap<String, Object> map) {
	            System.out.println(map);
	            boolean suc = this.ReservationService.create(map);
	            
	            if(suc == true) {
	            	map.put("suc", "true");	            	
	            }else {
	            	map.put("suc", "false");	            	
	            }
	            
				return map;
	    }
 	//예약 생성
 	@PostMapping("/reservation/reservation/{custom_id}")
 	public String submitReservation(
 	    @PathVariable("custom_id") String custom_id, @RequestParam Map<String, Object> map
 	) {
 	    System.out.println("예약생성 post: " + map);

 		map.put("custom_id", custom_id);
 	    System.out.println("map: " + map);
 	
 	 String result =  this.ReservationService.createReservation(map);
 	System.out.println("result: " + result);
 	 		String roomNumber = (String) map.get("roomNumber");
 			boolean result2	=	this.roomService.roomEdit(roomNumber);
 			
 	    return "redirect:/createReservation";
 	}
	 	
 	@GetMapping(value="/reservation/reservationDetail/{custom_id}")
 	public String reservationDetail(@PathVariable String custom_id, Model model) {
		
		System.out.println("custom_id : "+custom_id);
		
		Map<String, Object> result = this.ReservationService.totalRead(custom_id);

        model.addAttribute("total", result);
       
        return "/reservation/reservationDetail";
			
		}
	
 	
 	
 	
 	@GetMapping(value="/reservation/reservationEdit/{custom_id}")
 	public String reservationEdit(@PathVariable String custom_id, Model model) {
 		
		
		System.out.println("수정하기 custom_id : "+custom_id);
		 List<Room> rooms = roomService.getAllRooms();
	        System.out.println(rooms+ "room" );
	        model.addAttribute("rooms", rooms);

        return "/reservation/reservationEdit";
			
		}
 	
 	
 	@PutMapping("/reservation/update/{custom_id}")
    public String updateReservation(@RequestParam Map<String, Object> map, @PathVariable String custom_id) {
        // 여기에 예약 정보를 수정하는 로직을 구현합니다.
        // numberOfPeople와 roomNumber를 이용하여 예약 정보를 업데이트합니다.
 		map.put("custom_id", custom_id);
 		System.out.println("수정하기 map : "+map);
 		boolean resrult =this.ReservationService.reservationUpdate(map);

        return "redirect:/createReservation"; // 예약이 성공적으로 업데이트되었음을 클라이언트에게 응답합니다.
    }
	
 	
 	@DeleteMapping("/reservation/delete")
    public String deleteReservation(@RequestParam String roomNumber) {
       
 		System.out.println("roomNumber 삭제하기 : "+roomNumber);
 		boolean resrult =this.ReservationService.reservationDelete(roomNumber);

        return "redirect:/createReservation"; // 예약이 성공적으로 업데이트되었음을 클라이언트에게 응답합니다.
    }
 	
}





