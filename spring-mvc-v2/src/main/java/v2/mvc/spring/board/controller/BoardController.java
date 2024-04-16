package v2.mvc.spring.board.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import v2.mvc.spring.board.service.Impl.BoardServiceImpl;

@Controller
public class BoardController {

	@Autowired
	BoardServiceImpl boardService;
	
	
	//시작화면으로 오기
	@GetMapping(value="/createBoard")
	public String home() {
		System.out.println("기본화면으로 돌아가기");
		return "board/start";
	}
	//등록하기 누르면 밑의 화면 보여준다.
	@RequestMapping(value = "board/create", method = RequestMethod.GET)
	public String getcreate() {
		System.out.println("등록하기버튼 누르고 해당 메소드 실행");
		return "board/create";
	}

	//등록하기 확인 누르면  post 제출된다.
	@RequestMapping(value = "board/create", method = RequestMethod.POST)
	public String postCreate(@RequestParam Map<String, Object> map) {
		boolean blogContseq = this.boardService.create(map);
		System.out.println("POST_등록성공");
		return "redirect:/createBoard";
	}
	
	
	

	@GetMapping("/board/edit/{queryString}")
	public String edit(@PathVariable String queryString) {
	    System.out.println("Get : 수정화면"+queryString);
	    // detail 객체 사용
	    return "board/edit";
	}
	
	@PutMapping(value = "/board/edit/{queryString}")
	public String putEdit(@PathVariable int queryString, @RequestParam Map<String, Object> map) {
		System.out.println("ddd"+queryString);
		
		map.put("resident_id", queryString);
		
		boolean isSuccessEdit = this.boardService.edit(map);
		if(isSuccessEdit) {
			System.out.println("수정 성고_Put");
			return "redirect:/createBoard";
		}
		return "redirect:/board/edit";
	}
	
	@GetMapping("/board/detail")
	public String showDetail(Map<String, Object> detail) {
		// detail 객체 사용
		System.out.println("디테일 화면 보여주기");
		return "board/detail";
	}
	
	//조회하기  일반적으로 redirect를 사용하면 HTTP 리다이렉트가 발생하므로, 속성을 직접 전달할 수 없습니다. 
	//그러나 다른 방법이 있습니다. RedirectAttributes를 사용하여 속성을 보관하고 리다이렉트 시 함께 전달할 수 있습니다.
	@RequestMapping(value = "/createBoard", method = RequestMethod.POST)
	public String read(@RequestParam Map<String, Object> map, Model model,RedirectAttributes redirectAttributes) {
		

		 Map<String, Object> detail = this.boardService.read(map);
	
		model.addAttribute("detail", detail);
		
		System.out.println("등록 조회성공");
		redirectAttributes.addFlashAttribute("detail", detail);
		return"redirect:board/detail";
	}
	
	//삭제
	@DeleteMapping(value = "/board/delete/{queryString}")
	public String delete(@PathVariable int queryString) {
	   
		this.boardService.delete(queryString);

		System.out.println("삭제성공");
	    return "redirect:/createBoard";
	}
	
	
}
