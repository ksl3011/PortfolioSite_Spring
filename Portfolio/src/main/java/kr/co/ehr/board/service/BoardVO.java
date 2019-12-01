package kr.co.ehr.board.service;

import kr.co.ehr.common.DTO;

public class BoardVO implements DTO{

	private int totalCnt;	//총글수
	private int postNum;	//고유번호
	private int num;		//게시글 순번
	private String divNm;
	private String title;
	private String contents;
	private String userId;
	private String regDt;
	private int cnt;		//조회수
	private String password;
	private int notice;		//공지
	private int commentCnt;	//댓글개수
	
	public BoardVO() {}

	public BoardVO(int totalCnt, int postNum, int num, String divNm, String title, String contents, String userId,
			String regDt, int cnt, String password, int notice, int commentCnt) {
		super();
		this.totalCnt = totalCnt;
		this.postNum = postNum;
		this.num = num;
		this.divNm = divNm;
		this.title = title;
		this.contents = contents;
		this.userId = userId;
		this.regDt = regDt;
		this.cnt = cnt;
		this.password = password;
		this.notice = notice;
		this.commentCnt = commentCnt;
	}

	public int getTotalCnt() {
		return totalCnt;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getDivNm() {
		return divNm;
	}

	public void setDivNm(String divNm) {
		this.divNm = divNm;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getNotice() {
		return notice;
	}

	public void setNotice(int notice) {
		this.notice = notice;
	}

	public int getCommentCnt() {
		return commentCnt;
	}

	public void setCommentCnt(int commentCnt) {
		this.commentCnt = commentCnt;
	}

	@Override
	public String toString() {
		return "BoardVO [totalCnt=" + totalCnt + ", postNum=" + postNum + ", num=" + num + ", divNm=" + divNm
				+ ", title=" + title + ", contents=" + contents + ", userId=" + userId + ", regDt=" + regDt + ", cnt="
				+ cnt + ", password=" + password + ", notice=" + notice + ", commentCnt=" + commentCnt + "]";
	}

}	
