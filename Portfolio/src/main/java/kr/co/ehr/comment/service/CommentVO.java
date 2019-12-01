package kr.co.ehr.comment.service;

import kr.co.ehr.common.DTO;

public class CommentVO implements DTO {

	private String userId;
	private String contents;
	private int postNum;		//글 고유번호
	private int commentNum;		//코멘트 고유번호
	private String password;		//코멘트 비밀번호
	private String regDt;
	
	public CommentVO() {}

	public CommentVO(String userId, String contents, int postNum, int commentNum, String password, String regDt) {
		super();
		this.userId = userId;
		this.contents = contents;
		this.postNum = postNum;
		this.commentNum = commentNum;
		this.password = password;
		this.regDt = regDt;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getPostNum() {
		return postNum;
	}

	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRegDt() {
		return regDt;
	}

	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}

	@Override
	public String toString() {
		return "CommentVO [userId=" + userId + ", contents=" + contents + ", postNum=" + postNum + ", commentNum="
				+ commentNum + ", password=" + password + ", regDt=" + regDt + "]";
	}

}
