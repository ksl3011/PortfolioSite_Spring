package kr.co.ehr.board;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import kr.co.ehr.board.service.BoardService;
import kr.co.ehr.board.service.BoardVO;
import kr.co.ehr.board.service.impl.BoardServiceImpl;
import kr.co.ehr.common.SearchVO;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardWebTest {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@Autowired
	private BoardService ser;
	
	@Test
	public void retrieve_update_delete() throws Exception{
		SearchVO vo = new SearchVO();
		vo.setPageNum("1");
		vo.setPageSize("10");
		//vo.setSearchDiv("");
		//vo.setSearchWord("");
		
		JsonArray list = this.get_retrieve(vo);
	
		JsonElement el = list.get(0);
		JsonObject ob = el.getAsJsonObject();
		
		BoardVO bvo = new BoardVO();
		bvo.setTitle("수정수");
		bvo.setContents("수정수정수정");
		bvo.setDivNm(ob.get("divNm")+"");
		bvo.setPassword("비밀번");
		bvo.setPostNum(Integer.parseInt(ob.get("postNum")+""));
		
		this.get_selectOne(bvo);
		
		this.do_update(bvo);
		
		this.do_delete(bvo);
		
		
	}
	
	@Ignore
	@Test
	public void save() throws Exception{
		BoardVO vo = new BoardVO();
		vo.setDivNm("일반");
		vo.setContents("내용물");
		vo.setPassword("비밀번");
		vo.setUserId("김유저");
		vo.setTitle("김제목");
		
		this.do_save(vo);
	}
	
	public JsonArray get_retrieve(SearchVO vo) throws Exception {
		MockHttpServletRequestBuilder createMessage = 
				MockMvcRequestBuilders.post("/board/retrieve.do")
										.param("searchDiv", vo.getSearchDiv())
										.param("searchWord", vo.getSearchWord())
										.param("pageSize", String.valueOf(vo.getPageSize()))
										.param("pageNum", String.valueOf(vo.getPageNum()));
		
		ResultActions resultAction = mockMvc.perform(createMessage)
										.andExpect(status().isOk());
		
		MvcResult result = mockMvc.perform(createMessage)
                .andExpect(status().isOk())
                .andReturn();
		

		String list = (String) result.getResponse().getContentAsString();
		LOG.debug("=====================================");
		LOG.debug("list :" + list);
		LOG.debug("=====================================");
		
		JsonParser jsonParser = new JsonParser();
		JsonArray jsonArray = (JsonArray) jsonParser.parse(list);
		return jsonArray;
	}
	
	public JsonObject get_selectOne(BoardVO vo) throws Exception {
		MockHttpServletRequestBuilder createMessage = 
				MockMvcRequestBuilders.post("/board/selectOne.do")
					.param("postNum", vo.getPostNum()+"");
		
		ResultActions resultAction = mockMvc.perform(createMessage)
										.andExpect(status().isOk());
		
		MvcResult result = mockMvc.perform(createMessage)
	                .andExpect(status().isOk())
	                .andReturn();
		
		String outvo = (String) result.getResponse().getContentAsString();
		
		LOG.debug("=====================================");
		LOG.debug("=outVO="+outvo);
		LOG.debug("=====================================");		
		
		JsonParser jsonParser = new JsonParser();
		JsonElement el = jsonParser.parse(outvo);
		JsonObject ob = el.getAsJsonObject();
		return ob;
	}
	
	public void do_update(BoardVO vo) throws Exception {
		MockHttpServletRequestBuilder createMessage = 
				MockMvcRequestBuilders.post("/board/update.do")
				.param("title", vo.getTitle())
				.param("divNm", vo.getDivNm())
				.param("contents", vo.getContents())
				.param("postNum", vo.getPostNum()+"")
				.param("password", vo.getPassword());
		
		ResultActions resultAction = mockMvc.perform(createMessage)
										.andExpect(MockMvcResultMatchers.content().contentType("application/json; charset=UTF-8"))
										.andExpect(MockMvcResultMatchers.jsonPath("$.msg", is(1)));
	
		String result = resultAction.andDo(print())
										.andReturn()
										.getResponse()
										.getContentAsString();
		
		LOG.debug("=====================================================");
		LOG.debug("return = " + result);
		LOG.debug("=====================================================");
	}
	
	public void do_delete(BoardVO vo) throws Exception {
		MockHttpServletRequestBuilder createMessage = 
				MockMvcRequestBuilders.post("/board/delete.do")
				.param("postNum", vo.getPostNum()+"")
				.param("password", vo.getPassword());
		
		ResultActions resultAction = mockMvc.perform(createMessage)
										.andExpect(MockMvcResultMatchers.content().contentType("application/json; charset=UTF-8"))
										.andExpect(MockMvcResultMatchers.jsonPath("$.msg", is(1)));
	
		String result = resultAction.andDo(print())
										.andReturn()
										.getResponse()
										.getContentAsString();
		
		LOG.debug("=====================================================");
		LOG.debug("return = " + result);
		LOG.debug("=====================================================");
	}
	
	public void do_save(BoardVO vo) throws Exception {
		MockHttpServletRequestBuilder createMessage = 
				MockMvcRequestBuilders.post("/board/insert.do")
				.param("title", vo.getTitle())
				.param("divNm", vo.getDivNm())
				.param("userId", vo.getUserId())
				.param("contents", vo.getContents())
				.param("password", vo.getPassword());
				
				
		
		ResultActions resultAction = mockMvc.perform(createMessage)
										.andExpect(MockMvcResultMatchers.content().contentType("application/json; charset=UTF-8"))
										.andExpect(MockMvcResultMatchers.jsonPath("$.msg", is(1)));
	
		String result = resultAction.andDo(print())
										.andReturn()
										.getResponse()
										.getContentAsString();
		
		LOG.debug("=====================================================");
		LOG.debug("return = " + result);
		LOG.debug("=====================================================");
	}
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

		
	}
	
	@After
	public void tearDown() {
		
	}
	
}
