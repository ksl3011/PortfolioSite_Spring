package kr.co.ehr.comment.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.ehr.comment.service.CommentService;
import kr.co.ehr.comment.service.CommentVO;
import kr.co.ehr.common.SearchVO;


@Controller
public class CommentController {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CommentService svc;

	@ResponseBody
	@RequestMapping(value = "board/saveC.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public String do_saveC(CommentVO vo) {
		LOG.debug("================================");
		LOG.debug("Ctrl: do_saveC ..(1/2)");
		LOG.debug("vo: " + vo);
		LOG.debug("================================");

		int flag = svc.save(vo);
		
		JsonObject jo = new JsonObject();
		jo.addProperty("msg", flag);
		
		LOG.debug("================================");
		LOG.debug("Ctrl: do_saveC ..(2/2)");
		LOG.debug("flag: " + flag);
		LOG.debug("================================");
		
		return jo.toString();
	}
	
	@ResponseBody
	@RequestMapping(value = "board/updateC.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public String do_updateC(CommentVO vo) {
		LOG.debug("================================");
		LOG.debug("Ctrl: do_updateC ..(1/2)");
		LOG.debug("vo: " + vo);
		LOG.debug("================================");

		int flag = svc.update(vo);
		
		JsonObject jo = new JsonObject();
		jo.addProperty("msg", flag);
		
		LOG.debug("================================");
		LOG.debug("Ctrl: do_updateC ..(2/2)");
		LOG.debug("flag: " + flag);
		LOG.debug("================================");
		
		return jo.toString();
	}
	
	@ResponseBody
	@RequestMapping(value = "board/deleteC.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public String do_deleteC(CommentVO vo) {
		LOG.debug("================================");
		LOG.debug("Ctrl: do_deleteC ..(1/2)");
		LOG.debug("Ctrl) vo: " + vo);
		LOG.debug("================================");
		
		int flag = svc.delete(vo);
		
		JsonObject jo = new JsonObject();
		jo.addProperty("msg", flag);
		
		LOG.debug("================================");
		LOG.debug("Ctrl: do_deleteC ..(1/2)");
		LOG.debug("flag: " + flag);
		LOG.debug("================================");
		
		return jo.toString();
	}
	
	@ResponseBody
	@RequestMapping(value = "board/selectOneC.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public String do_selectOneC(CommentVO vo) {
		LOG.debug("================================");
		LOG.debug("Ctrl: do_selectOneC ..(1/2)");
		LOG.debug("vo: " + vo);
		LOG.debug("================================");
		
		CommentVO outvo = (CommentVO) svc.selectOne(vo);
		
		Gson gson = new Gson();
		String result = gson.toJson(outvo);
		
		LOG.debug("================================");
		LOG.debug("Ctrl: do_selectOneC ..(2/2)");
		LOG.debug("outvo: " + outvo);
		LOG.debug("================================");
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "board/retrieveC.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public String do_retrieveC(SearchVO vo) {
		LOG.debug("================================");
		LOG.debug("Ctrl: do_retrieveC ..(1/2)");
		LOG.debug("vo: " + vo);
		LOG.debug("================================");

		vo.setPageNum("1");
		vo.setPageSize("10000");
		vo.setSearchDiv("1");
		
		List<CommentVO> list = (List<CommentVO>) svc.retrieve(vo);
		
		Gson gson = new Gson();
		String result = gson.toJson(list);
		LOG.debug("================================");
		LOG.debug("Ctrl: do_retrieveC ..(2/2)");
		LOG.debug("list: " + result);
		LOG.debug("================================");
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "board/confirmPW_C.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public String do_confirmPasswordC(CommentVO vo) {
		LOG.debug("================================");
		LOG.debug("Ctrl: do_confirmPasswordC ..(1/2)");
		LOG.debug("vo: " + vo);
		LOG.debug("================================");
		
		CommentVO outvo = (CommentVO) svc.password(vo);
		
		JsonObject jo = new JsonObject();
		
		if(!vo.getPassword().equals(outvo.getPassword())) {
			jo.addProperty("msg", "0");
		}else {
			jo.addProperty("msg", "1");
		}
		
		LOG.debug("================================");
		LOG.debug("Ctrl: do_confirmPasswordC ..(2/2)");
		LOG.debug("outvo: " + outvo);
		LOG.debug("================================");
		
		return jo.toString();
	}

	@RequestMapping(value = "mainPage")
	public String go_mainPage() {
		return "main";
	}
	
	@RequestMapping(value = "")
	public String go_mainPageTwo() {
		return "main";
	}
}
