package kr.co.ehr.board.service;

import java.util.List;

import kr.co.ehr.common.DTO;

public interface BoardService {

	public int save(DTO dto);
	public int delete(DTO dto);
	public int update(DTO dto);
	public List<?> retrieve(DTO dto);
	public DTO selectOne(DTO dto);
	public int cntUpdate(DTO dto);
	public DTO password(DTO dto);
}
