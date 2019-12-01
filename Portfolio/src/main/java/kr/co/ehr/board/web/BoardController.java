package kr.co.ehr.board.web;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import kr.co.ehr.board.service.BoardService;
import kr.co.ehr.board.service.BoardVO;
import kr.co.ehr.common.SearchVO;


@Controller
public class BoardController {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private BoardService svc;
	
	@Resource(name = "downloadView")
	private View download;
	
	@ResponseBody
	@RequestMapping(value = "board/save.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public String do_save(BoardVO vo) {
		LOG.debug("================================");
		LOG.debug("Ctrl: do_insert ..(1/2)");
		LOG.debug("vo: " + vo);
		LOG.debug("================================");
		
		if(vo.getDivNm().equals("1")) vo.setDivNm("일반");
		else if(vo.getDivNm().equals("2")) vo.setDivNm("공지");
		int flag = svc.save(vo);
		
		JsonObject jo = new JsonObject();
		jo.addProperty("msg", flag);
		
		LOG.debug("================================");
		LOG.debug("Ctrl: do_insert ..(2/2)");
		LOG.debug("flag: " + flag);
		LOG.debug("================================");
		
		return jo.toString();
	}
	
	@ResponseBody
	@RequestMapping(value = "board/update.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public String do_update(BoardVO vo) {
		LOG.debug("================================");
		LOG.debug("Ctrl: do_update ..(1/2)");
		LOG.debug("vo: " + vo);
		LOG.debug("================================");
		
		if(vo.getDivNm().equals("1")) vo.setDivNm("일반");
		else if(vo.getDivNm().equals("2")) vo.setDivNm("공지");
		int flag = svc.update(vo);
		
		JsonObject jo = new JsonObject();
		jo.addProperty("msg", flag);
		
		LOG.debug("================================");
		LOG.debug("Ctrl: do_update ..(2/2)");
		LOG.debug("flag: " + flag);
		LOG.debug("================================");
		
		return jo.toString();
	}
	
	@ResponseBody
	@RequestMapping(value = "board/delete.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public String do_delete(BoardVO vo) {
		LOG.debug("================================");
		LOG.debug("Ctrl: do_delete ..(1/2)");
		LOG.debug("Ctrl) vo: " + vo);
		LOG.debug("================================");
		
		int flag = svc.delete(vo);
		
		JsonObject jo = new JsonObject();
		jo.addProperty("msg", flag);
		
		LOG.debug("================================");
		LOG.debug("Ctrl: do_delete ..(1/2)");
		LOG.debug("flag: " + flag);
		LOG.debug("================================");
		
		return jo.toString();
	}
	
	@ResponseBody
	@RequestMapping(value = "board/selectOne.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public String do_selectOne(BoardVO vo, HttpServletRequest req, HttpServletResponse res) {
		LOG.debug("================================");
		LOG.debug("Ctrl: do_selectOne ..(1/2)");
		LOG.debug("vo: " + vo);
		LOG.debug("================================");
		
		int flag = 0;
		Cookie[] cookieList = req.getCookies();
		for(Cookie ck : cookieList) {						//쿠키 존재확인
			if(ck.getName().equals(vo.getPostNum()+"")) {	//존재시
				flag = 1;
			}
		}
		if(flag == 0) {										//쿠키없을때
			flag = svc.cntUpdate(vo);
			Cookie newCk = new Cookie(vo.getPostNum()+"", "1");
			res.addCookie(newCk);	
		}
		
		BoardVO outvo = (BoardVO) svc.selectOne(vo);
		
		Gson gson = new Gson();
		String result = gson.toJson(outvo);
		
		LOG.debug("================================");
		LOG.debug("Ctrl: do_selectOne ..(2/2)");
		LOG.debug("outvo: " + outvo);
		LOG.debug("cnt: " + flag);
		LOG.debug("================================");
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "board/retrieve.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public String do_retrieve(SearchVO vo) {
		LOG.debug("================================");
		LOG.debug("Ctrl: do_retrieve ..(1/2)");
		LOG.debug("vo: " + vo);
		LOG.debug("================================");
		
		//검색구분이 구분일때
		if(vo.getSearchDiv().equals("4")) {
			if(vo.getSearchWord().equals("일반")) vo.setSearchWord("1");
			else if(vo.getSearchWord().equals("공지")) vo.setSearchWord("2");
		}
		List<BoardVO> list = (List<BoardVO>) svc.retrieve(vo);
		
		Gson gson = new Gson();
		String result = gson.toJson(list);
		LOG.debug("================================");
		LOG.debug("Ctrl: do_retrieve ..(2/2)");
		LOG.debug("list: " + result);
		LOG.debug("================================");
		
		return result;
	}
	
	@ResponseBody
	@RequestMapping(value = "board/confirmPW.do", method = RequestMethod.POST, produces = "application/json; charset=UTF-8")
	public String do_confirmPassword(BoardVO vo) {
		LOG.debug("================================");
		LOG.debug("Ctrl: do_confirmPassword ..(1/2)");
		LOG.debug("vo: " + vo);
		LOG.debug("================================");
		
		BoardVO outvo = (BoardVO) svc.password(vo);
		
		JsonObject jo = new JsonObject();
		
		if(!vo.getPassword().equals(outvo.getPassword())) {
			jo.addProperty("msg", "0");
		}else {
			jo.addProperty("msg", "1");
		}
		
		LOG.debug("================================");
		LOG.debug("Ctrl: do_confirmPassword ..(2/2)");
		LOG.debug("outvo: " + outvo);
		LOG.debug("================================");
		
		return jo.toString();
	}
	
	@RequestMapping(value="board/downloadResume.do",method = RequestMethod.POST)	
	public ModelAndView resumeDown(SearchVO search , HttpServletRequest req, ModelAndView mView) {
		//String dftFilePath = "/usr/local/src/apache-tomcat-8.5.47/webapps/pfBoardFile/";
		String dftFilePath = "E:\\JAVA\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\Portfolio\\";
		String filePath = dftFilePath + "boardFile" + File.separator;

		//서버에 있는 파일 경로
		String saveFileNm = filePath + "DOCX.docx";
		String orgFileNm  = "웹개발자이력서_이규섭.docx";
		mView.setView(download);
		
		File downloadFile = new File(saveFileNm);
		mView.addObject("downloadFile", downloadFile);
		mView.addObject("orgFileNm", orgFileNm);
		
		return mView;
	}
}
