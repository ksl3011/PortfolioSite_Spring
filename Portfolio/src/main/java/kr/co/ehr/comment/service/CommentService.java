package kr.co.ehr.comment.service;

import java.util.List;

import kr.co.ehr.common.DTO;

public interface CommentService {

	public int save(DTO dto);
	public int delete(DTO dto);
	public int update(DTO dto);
	public List<?> retrieve(DTO dto);
	public DTO selectOne(DTO dto);
	public DTO password(DTO dto);
}
