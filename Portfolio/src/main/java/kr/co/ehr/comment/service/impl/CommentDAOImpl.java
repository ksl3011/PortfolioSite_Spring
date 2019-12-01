package kr.co.ehr.comment.service.impl;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.ehr.comment.service.CommentDAO;
import kr.co.ehr.comment.service.CommentVO;
import kr.co.ehr.common.DTO;
import kr.co.ehr.common.SearchVO;

@Component
public class CommentDAOImpl implements CommentDAO {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	private String NAMESPACE = "portfolio.comment";
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public int save(DTO dto) {
		String statement = this.NAMESPACE + ".do_save";
		
		LOG.debug("================================");
		LOG.debug("DAO: save ..(1/2)");
		LOG.debug("dto: " + dto);
		LOG.debug("================================");
		
		CommentVO invo = (CommentVO) dto;
		
		int flag = sqlSessionTemplate.insert(statement, invo);
		
		LOG.debug("================================");
		LOG.debug("DAO: save ..(2/2)");
		LOG.debug("flag: " + flag);
		LOG.debug("================================");
		
		return flag;
	}

	@Override
	public int delete(DTO dto) {
		String statement = this.NAMESPACE + ".do_delete";
		
		LOG.debug("================================");
		LOG.debug("DAO: delete ..(1/2)");
		LOG.debug("dto: " + dto);
		LOG.debug("================================");
		
		CommentVO invo = (CommentVO) dto;
		
		int flag = sqlSessionTemplate.delete(statement, invo);
		
		LOG.debug("================================");
		LOG.debug("DAO: delete ..(2/2)");
		LOG.debug("flag: " + flag);
		LOG.debug("================================");
		
		return flag;
	}

	@Override
	public int update(DTO dto) {
		String statement = this.NAMESPACE + ".do_update";
		
		LOG.debug("================================");
		LOG.debug("DAO: update ..(1/2)");
		LOG.debug("dto: " + dto);
		LOG.debug("================================");
		
		CommentVO invo = (CommentVO) dto;
		
		int flag = sqlSessionTemplate.update(statement, invo);
		
		LOG.debug("================================");
		LOG.debug("DAO: update ..(2/2)");
		LOG.debug("flag: " + flag);
		LOG.debug("================================");
		
		return flag;
	}

	@Override
	public List<?> retrieve(DTO dto) {
		String statement = this.NAMESPACE + ".get_retrieve";
		
		LOG.debug("================================");
		LOG.debug("DAO: retrieve ..(1/2)");
		LOG.debug("dto: " + dto);
		LOG.debug("================================");
		
		SearchVO invo = (SearchVO) dto;
		
		List<CommentVO> list = sqlSessionTemplate.selectList(statement, invo);
		
		LOG.debug("================================");
		LOG.debug("DAO: retrieve ..(2/2)");
		LOG.debug("list");
		for(int i=0 ; i<list.size() ; i++) {
			LOG.debug(list.get(i)+"");
		}
		LOG.debug("================================");
		
		return list;
	}

	@Override
	public DTO selectOne(DTO dto) {
		String statement = this.NAMESPACE + ".get_selectOne";

		LOG.debug("================================");
		LOG.debug("DAO: selectOne ..(1/2)");
		LOG.debug("dto: " + dto);
		LOG.debug("================================");
		
		CommentVO invo = (CommentVO) dto;

		CommentVO outvo = sqlSessionTemplate.selectOne(statement, invo);
		
		LOG.debug("================================");
		LOG.debug("DAO: selectOne ..(2/2)");
		LOG.debug("out: " + outvo);
		LOG.debug("================================");
		
		return outvo;
	}
	
	@Override
	public DTO password(DTO dto) {
		String statement = this.NAMESPACE + ".get_password";
		
		LOG.debug("================================");
		LOG.debug("DAO: passWord ..(1/2)");
		LOG.debug("dto: " + dto);
		LOG.debug("================================");
		
		CommentVO invo = (CommentVO) dto;
		
		CommentVO outvo = sqlSessionTemplate.selectOne(statement, invo);
		
		LOG.debug("================================");
		LOG.debug("DAO: passWord ..(2/2)");
		LOG.debug("out: " + outvo);
		LOG.debug("================================");
		
		return outvo;
	}

}
