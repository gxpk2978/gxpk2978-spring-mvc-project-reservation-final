package v2.mvc.spring.board.dao;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import v2.mvc.spring.blog.vo.BlogEditRequestVO;

@Repository
public class BoardDAO {
	
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
	//성공여부 끝
	public boolean insert(Map<String, Object> map) {
		//영향받은 행의 수 반환
		int QueryResult = this.sqlSessionTemplate.insert("PERSONAL_INFO.insert",map);
		if(QueryResult>0) {
			return true;
		}
		
		return false;
	}

	public Map<String, Object> selectOne(Map<String, Object> map) {
		
	//selectOne 메서드는 오직 하나의 객체만을 리턴
		return this.sqlSessionTemplate.selectOne("PERSONAL_INFO.selectOne",map);
	}
	
	public Map<String, Object> selectOne2(int number) {
		
		
		return this.sqlSessionTemplate.selectOne("PERSONAL_INFO.selectOne",number);
	}
	
	//수정(업데이트)
	public boolean update(Map<String, Object> map) {
		//영향받은 행의 수 반환
		int result =this.sqlSessionTemplate.update("PERSONAL_INFO.update",map);
		return  result > 0;
	
	}
	
	public boolean delete(int num) {
		//영향받은 행의 수 반환
		int result =this.sqlSessionTemplate.delete("PERSONAL_INFO.delete",num);
		return  result > 0;

}
	
	
}
