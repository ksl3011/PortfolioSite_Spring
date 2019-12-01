package kr.co.ehr.common;

public class SearchVO implements DTO{

	private String searchDiv;	//검색구분
	private String searchWord;	//검색어
	private String pageNum;		//호출 페이지 번호
	private String pageSize;	//한 페이지 게시물수
	
	public SearchVO() {}
	
	public SearchVO(String searchDiv, String searchWord, String pageNum, String pageSize) {
		super();
		this.searchDiv = searchDiv;
		this.searchWord = searchWord;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}
	
	public String getSearchDiv() {
		return searchDiv;
	}
	
	public void setSearchDiv(String searchDiv) {
		this.searchDiv = searchDiv;
	}
	
	public String getSearchWord() {
		return searchWord;
	}
	
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	
	public String getPageNum() {
		return pageNum;
	}
	
	public void setPageNum(String pageNum) {
		this.pageNum = pageNum;
	}
	
	public String getPageSize() {
		return pageSize;
	}
	
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	
	@Override
	public String toString() {
		return "SearchVO [searchDiv=" + searchDiv + ", searchWord=" + searchWord + ", pageNum=" + pageNum
				+ ", pageSize=" + pageSize + "]";
	}
	
}
