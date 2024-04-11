package v2.mvc.spring.blog.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import v2.mvc.spring.blog.service.BlogService;
import v2.mvc.spring.blog.vo.BlogEditRequestVO;

@Controller
//대게 컨트롤러는 필드주입 방식을 사용
public class BlogController {
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String getcreate() {
		return "blog/create";
	}
	
	@Autowired
	BlogService blogService;
	
	//@RequestParam : post온 데이타를 메소드의 매개변수의 타입으로 넘겨준다.
	//삽입하기
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String postCreate(@RequestParam Map<String, Object> map) {
		
		int blogContseq = this.blogService.create(map);
		return "redirect:/read/" + String.valueOf(blogContseq);
	}
	
	//(@PathVariable 어노테이션은 경로 변수를 메서드의 매개변수로 매핑하는 데 사용됩니다. )
	//매개변수 Model은 spring이 메소드 실행될때 넣어준다.
	//조회하기
	@GetMapping(value = "/read/{blogContSeq}")
	public String getRead(@PathVariable("blogContSeq") int blogContSeq, Model model )
	{
		Map<String, Object> blogCont = this.blogService.read(blogContSeq);
		model.addAttribute("blogCont", blogCont);
		return "blog/read";
	}
	//수정하기 화면 보여주기
	@GetMapping(value="/edit/{blogContSeq}")
	public ModelAndView getEdit(@PathVariable("blogContSeq") int blogContSeq) {
		ModelAndView mav = new ModelAndView("/blog/edit");
		
		Map<String, Object> blogCont = this.blogService.read(blogContSeq);
		
		if(blogCont == null) {
			mav.setViewName("redirect:/list");
			return mav;
		}
		mav.addObject("blogCont",blogCont);
		return mav;
	}
	
	//수정하기 제출했을때 화면
	@PutMapping(value = "/edit/{blogContSeq}")
	public String putEdit(BlogEditRequestVO blogEditRequestVO) {
		
		boolean isSuccessEdit = this.blogService.edit(blogEditRequestVO);
		
		if(isSuccessEdit) {
			
			return "redirect:/edit/"+String.valueOf(blogEditRequestVO.getBlogContSeq());
		}
		return "redirect:/list";
	}
	
	
	@DeleteMapping(value = "/delete")
	public String delete(int blogContSeq) {
		
		this.blogService.delete(blogContSeq);
		
		return "redirect:/create";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
