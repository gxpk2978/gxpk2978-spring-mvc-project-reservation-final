package v2.mvc.spring.blog.vo;



//DTO라고 불리기도하며 값의 이름과 타입을 미리 정의해서 사용할 수 있음 맵과 다르게
public class BlogEditRequestVO {

	private int blogContSeq;
	private String title;
	private String contBdy;
	
	public int getBlogContSeq() {
		return blogContSeq;
	}
	public void setBlogContSeq(int blogContSeq) {
		this.blogContSeq = blogContSeq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContBdy() {
		return contBdy;
	}
	public void setContBdy(String contBdy) {
		this.contBdy = contBdy;
	}
	
	
}
