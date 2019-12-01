package kr.co.ehr.board;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import kr.co.ehr.board.service.BoardService;
import kr.co.ehr.board.service.BoardVO;
import kr.co.ehr.board.service.impl.BoardServiceImpl;
import kr.co.ehr.common.SearchVO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardTest {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardService ser;
	
	@Ignore
	@Test
	public void save() {
		
		BoardVO vo = new BoardVO();
		vo.setDivNm("일반");
		vo.setContents("내용물");
		vo.setPassword("비밀번");
		vo.setUserId("김유저");
		vo.setTitle("김제목");
		
		int flag = ser.save(vo);
		LOG.debug("flag: " + flag);
	}
	
	@Ignore
	@Test
	public void retrieve() {
		
		SearchVO vo = new SearchVO();
		//vo.setSearchDiv("");
		//vo.setSearchWord("");
		
		vo.setPageNum("1");
		vo.setPageSize("10");
		
		List<BoardVO> list = (List<BoardVO>) ser.retrieve(vo);
		LOG.debug("list " + list);
	}
	
	@Ignore
	@Test
	public void select() {
		
		BoardVO vo = new BoardVO();
		vo.setPostNum(1);
		
		BoardVO out = (BoardVO) ser.selectOne(vo);
		LOG.debug("out: " + out);
	}
	
	@Ignore
	@Test
	public void delete() {
		
		BoardVO vo = new BoardVO();
		vo.setPostNum(1);
		vo.setPassword("비밀번");
		int flag = ser.delete(vo);
		LOG.debug("flag : " + flag);
	}
	
	@Ignore
	@Test
	public void update() {
		BoardVO vo = new BoardVO();
		vo.setDivNm("일반");
		vo.setContents("내용물");
		vo.setPassword("비밀번");
		vo.setUserId("김유저");
		vo.setTitle("김제목");
		
		//int flag = ser.save(vo);
		//LOG.debug("업로: " + flag);
		
		vo.setTitle("수정타이틀");
		vo.setPostNum(2);
		int flag2 = ser.update(vo);
		LOG.debug("업데이: " + flag2);
		
		
	}
}
