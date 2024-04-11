package v2.mvc.spring.blog.mapper;

import org.apache.ibatis.annotations.Mapper;

//매개변수 타입은 매퍼xml에서 적은 파라메타타입과 일치 or 형변환가능ㄴ해야한다.
@Mapper
public interface BlogMapper {
	int delete(int blogContSeq);
}
