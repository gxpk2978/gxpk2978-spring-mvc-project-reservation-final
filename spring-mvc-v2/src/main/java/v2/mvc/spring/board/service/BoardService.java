package v2.mvc.spring.board.service;

import java.util.Map;

public interface BoardService {
 boolean create(Map<String, Object> map);
 
 Map<String, Object> read(Map<String, Object> map);

Map<String, Object> read2(int number);

boolean edit(Map<String, Object> map);
boolean delete(int num);
}
