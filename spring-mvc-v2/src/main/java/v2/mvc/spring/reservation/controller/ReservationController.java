package v2.mvc.spring.reservation.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

import v2.mvc.spring.board.service.Impl.BoardServiceImpl;
import v2.mvc.spring.reservation.service.ReservationService;

@Controller
public class ReservationController {
	
	@Autowired
	ReservationService ReservationService;
	
	
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
	
	@PostMapping(value="/createReservation")
	public String logIn() {
		System.out.println("로그인실행_post");
		return "reservation/signup";
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
	
	 	
	 	//예약하기_get create
	 	@GetMapping(value="/reservation/reservation/{customer_id}")
	 	public String reservation_get(@PathVariable("customer_id") String customer_id) {
	 	    System.out.println("reservation: " + customer_id);
	 	    return "reservation/reservation";
	 	}
	 	
	 	
	 	//예약하기_post create
	 	@ResponseBody
	    @RequestMapping(value="/reservation/reservation/{customer_id}", method = RequestMethod.POST)
	    public HashMap<String, Object> reservation_post( @RequestBody HashMap<String, Object> map) {
	 	    System.out.println(" reservation_post실행");
	 	    //성공하면 해당 방 예약번호 반환할거다. 
	 	    
	 		System.out.println(map);
	 		String roomStatus = (String) map.get("selectedSeat");
	 		System.out.println(roomStatus);
	 		//해당 룸의 상태를 먼저 조회 > 빈방이면 예약 가능 아니면 false 
	 		
	 		if(this.ReservationService.readRoom(roomStatus)) {
	 			System.out.println("해당 자리 빈방 확인");
	 			
	 			 this.ReservationService.createReservation(map);
	 			System.out.println(map);
	 			return map;
	 			
	 			
	 		}
	            
	            
				return map;
	    }

}





