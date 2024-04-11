package v2.mvc.spring.board.service.Impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import v2.mvc.spring.blog.dao.BlogDAO;
import v2.mvc.spring.blog.mapper.BlogMapper;
import v2.mvc.spring.board.dao.BoardDAO;
import v2.mvc.spring.board.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;
	
	@Autowired
	public BoardServiceImpl(BoardDAO boardDAO) {
		this.boardDAO = boardDAO;
	}
	

	@Override
	public boolean create(Map<String, Object> map) {	
		
		return this.boardDAO.insert(map);
	}


	@Override
	public Map<String, Object> read(Map<String, Object> map) {
		return this.boardDAO.selectOne(map);
	}

	
	@Override
	public Map<String, Object> read2(int number) {
		return this.boardDAO.selectOne2(number);
	}


	@Override
	public boolean edit(Map<String, Object> map) {
		
		return this.boardDAO.update(map);
	}


	@Override
	public boolean delete(int num) {

		return (this.boardDAO.delete(num));
	}
	
	 


}
