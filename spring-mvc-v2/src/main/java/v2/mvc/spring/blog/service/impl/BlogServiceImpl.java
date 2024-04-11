package v2.mvc.spring.blog.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import v2.mvc.spring.blog.dao.BlogDAO;
import v2.mvc.spring.blog.mapper.BlogMapper;
import v2.mvc.spring.blog.service.BlogService;
import v2.mvc.spring.blog.vo.BlogEditRequestVO;


//@Repository, @Service, @Controller 이 세가지 쓰면 해당 클래스의 객체 인스턴스가 빈으로 등록된다.
//@Autowired 쓰면 의존성 주입 하겠다는 의미 
//생성자주입 필드주입 메서드주입

//클라이언트 
@Service
public class BlogServiceImpl implements BlogService{

	
	
	private BlogDAO blogDAO;
	private BlogMapper blogMapper;
	
//	생성자주입
	@Autowired
	public BlogServiceImpl(BlogDAO blogDAO, BlogMapper blogMapper) {
		this.blogDAO = blogDAO;
		this.blogMapper=blogMapper;
	}
	

	@Override
	public boolean delete(int blogContSeq) {
		return (this.blogMapper.delete(blogContSeq) > 0);
	}
	
	
	
	
	@Override
	public int create(Map<String, Object> map) {
		int seq = this.blogDAO.insert(map);
		return seq;
	}


	@Override
	public Map<String, Object> read (int blogContSeq) {
		Map<String, Object> blogCont = this.blogDAO.selectOne(blogContSeq);
		return blogCont;
	}
	
	@Override
	public boolean edit(BlogEditRequestVO blogEditRequestVO) {
		//영향받은 행의 수 반환
		int affectRowsCount = this.blogDAO.update(blogEditRequestVO);
		return affectRowsCount > 0;
	}
	

	
	
	
	
	
	
	
	
	
	

}
