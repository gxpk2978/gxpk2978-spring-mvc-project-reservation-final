package v2.mvc.spring.blog.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import v2.mvc.spring.blog.vo.BlogEditRequestVO;

import org.mybatis.spring.SqlSessionTemplate;

//데이터에 접근하는 클래스임을 명시 스프링 빈으로 관리
//스프링 빈에 해당 클래스의 인스턴스 등록됨 이걸 service에 주입한다.


@Repository
public class BlogDAO {
	
	//	의존성을 주입 하라는뜻 -> 필드주입방식 
	//org.mybatis.spring.SqlSessionTemplate 빈에 등록된 이 클래스의 인스턴스가 스프링에 의해 멤버변수에 주입된다.
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	
	//삽입
	public int insert(Map<String, Object> map) {
		//여기서 insert는 mybatis 의 기능이고 매개변수로 매퍼패키지 해당id쿼리,해당 쿼리에 전달할 파라미터  
		int result = this.sqlSessionTemplate.insert("TB_BLG_CONT.insert" ,map); 
		//삽입성공 => 1 /// 실패 => 0    (리턴 :영향받은 행의 수)  
		//성공시 키 반환
		if(result > 0 && map.containsKey("seq_blg_cont")) {
			System.out.println(map.get("seq_blg_cont"));
			return (int)(Integer) map.get("seq_blg_cont");
		}
		
		return -1;
	}

	
	//조회
	public Map<String, Object> selectOne(int blogContSeq) {
		
		return this.sqlSessionTemplate.selectOne("TB_BLG_CONT.selectOne", blogContSeq);
	}
	
	
	//수정(업데이트)
	public int update(BlogEditRequestVO blogEditRequestVO) {
		
		return this.sqlSessionTemplate.update("TB_BLG_CONT.update",blogEditRequestVO);
	}
	
	
	
	
	
	
}