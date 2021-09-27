package co.kr.board;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.kr.board.VO.BoardVO;
import co.kr.board.service.BoardService;
import co.kr.reply.VO.ReplyVO;
import co.kr.reply.service.ReplyService;

@Controller
public class BoardController {

	@Autowired
	public BoardService boardService;
	
	@Autowired
	public ReplyService replyService;
	
	//-------------------------게시판 리스트--------------------------------
	@RequestMapping(value = "/boardList.do", method = RequestMethod.GET)
	public String list(HttpSession session,Model model) {
		String id = (String)session.getAttribute("user_id");
		model.addAttribute("id", id);
		return "board/list";
	}
	@RequestMapping(value = "/ListAjax.do", method = RequestMethod.GET)
	public ModelAndView list_ajax(int page, String type, String keyword) {
		ModelAndView json = new ModelAndView("jsonView");
		SimpleDateFormat simple = new SimpleDateFormat("yyyy.MM.dd");
		Date date = new Date();
		String board_day = simple.format(date);
		
		List<BoardVO> list = boardService.list(page,type,keyword);
		for(int i = 0; i<list.size(); i++) {
			list.get(i).setBoard_day(board_day);
		}
		System.out.println(list);
		int endPage = (int)(Math.ceil(page*1.0/10))*10;
		int startPage = endPage - 9;
		if(startPage <= 0) {
			startPage = 1;
		}
		int total = boardService.total(type,keyword);
		int totalPage = (int)(Math.ceil(total*1.0/10));
		if(endPage > totalPage) {
			endPage = totalPage;
		}
		System.out.println(total);
		boolean prev = page > 1;
		boolean next = page < endPage;
		
		json.addObject("list", list);
		json.addObject("endPage", endPage);
		json.addObject("startPage", startPage);
		json.addObject("prev", prev);
		json.addObject("next", next);
		return json;
	}
	//-------------------------게시판 상세보기--------------------------------
	@RequestMapping(value = "/boardDetail.do", method = RequestMethod.GET)
	public String detail(int board_num,Model model,HttpSession session) {
		String id = (String)session.getAttribute("user_id");
		SimpleDateFormat simple = new SimpleDateFormat("yyyy.MM.dd");
		Date date = new Date();
		String board_Day = simple.format(date);
		BoardVO vo = boardService.detail(board_num);
		vo.setBoard_day(board_Day);
		vo.setBoard_view(vo.getBoard_view()+1);
		boardService.cntUp(vo);
		
		List<ReplyVO> list = replyService.reply(board_num);
		int replyMax = replyService.replyMax();
		
		model.addAttribute("list", list);
		model.addAttribute("max", replyMax+1);
		model.addAttribute("id", id);
		model.addAttribute("vo", vo);
		return "board/detail";
	}
	//-------------------------게시판 추가------------------------------------
	@RequestMapping(value = "/boardInsert.do", method = RequestMethod.GET)
	public String insert(Model model,HttpSession session) {
		String id = (String)session.getAttribute("user_id");
		int max = boardService.cntMax();
		model.addAttribute("max", max+1);
		model.addAttribute("id", id);
		return "board/insert";
	}
	@RequestMapping(value = "/BoardInsertAjax.do", method = RequestMethod.POST)
	public ModelAndView insert_ajax(BoardVO vo) {
		ModelAndView json = new ModelAndView("jsonView");
		json.addObject("result", boardService.insert(vo));
		return json;
	}
	//-------------------------게시판 삭제------------------------------------
	@RequestMapping(value = "/BoardDelete.do", method = RequestMethod.POST)
	public ModelAndView delete(int board_num) {
		ModelAndView json = new ModelAndView("jsonView");
		json.addObject("result", boardService.delete(board_num));
		return json;
	}
	//-------------------------게시판 수정------------------------------------
	@RequestMapping(value = "/BoardModify.do", method = RequestMethod.GET)
	public String modify(int board_num,Model model) {
		BoardVO vo = boardService.detail(board_num);
		model.addAttribute("vo", vo);
		return "board/modify";
	}
	@RequestMapping(value = "/BoardModifyAjax.do", method = RequestMethod.POST)
	public ModelAndView modify_ajax(BoardVO vo) {
		ModelAndView json = new ModelAndView("jsonView");
		json.addObject("result", boardService.modify(vo));
		return json;
	}
}
