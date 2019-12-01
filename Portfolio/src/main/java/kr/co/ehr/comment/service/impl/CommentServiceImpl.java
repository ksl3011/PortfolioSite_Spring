package kr.co.ehr.comment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.ehr.comment.service.CommentDAO;
import kr.co.ehr.comment.service.CommentService;
import kr.co.ehr.common.DTO;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDAO dao;
	
	@Override
	public int save(DTO dto) {
		return dao.save(dto);
	}

	@Override
	public int delete(DTO dto) {
		return dao.delete(dto);
	}

	@Override
	public int update(DTO dto) {
		return dao.update(dto);
	}

	@Override
	public List<?> retrieve(DTO dto) {
		return dao.retrieve(dto);
	}

	@Override
	public DTO selectOne(DTO dto) {
		return dao.selectOne(dto);
	}

	@Override
	public DTO password(DTO dto) {
		return dao.password(dto);
	}
}
