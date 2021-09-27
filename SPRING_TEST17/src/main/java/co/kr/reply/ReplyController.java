package co.kr.reply;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.kr.board.VO.BoardVO;
import co.kr.reply.VO.ReplyVO;
import co.kr.reply.service.ReplyService;

@Controller
public class ReplyController {

	@Autowired
	public ReplyService replyService;
	
	@RequestMapping(value = "/reply_insert.do", method = RequestMethod.GET)
	public String reply_insert(ReplyVO vo,Model model) {
		SimpleDateFormat simple = new SimpleDateFormat("yyyy.MM.dd");
		Date date = new Date();
		vo.setReply_day(simple.format(date));
		replyService.insert(vo);
		return "redirect:/boardDetail.do?board_num="+vo.getBoard_num();
	}
	//--------------------------댓글 삭제-------------------------------------
//	@RequestMapping(value = "/reply_detail.do", method = RequestMethod.GET)
//	public ModelAndView reply_delete_get(int reply_num) {
//		ModelAndView json = new ModelAndView("jsonView");
//
//		json.addObject("result", replyService.detail(reply_num));
//		System.out.println(reply_num);
//		return json;
//	}
//	@RequestMapping(value = "/replyDetail.do", method = RequestMethod.GET)
//	public String reply_detail(int reply_num,int board_num,Model model) {
//		replyService.detail(reply_num,board_num);
//		return "board/detail";
//	}
	
	@RequestMapping(value = "/reply_delete", method = RequestMethod.POST)
	public ModelAndView reply_delete(int reply_num,int board_num) {
		ModelAndView json = new ModelAndView("jsonView");
	
		json.addObject("result", replyService.delete(reply_num,board_num));
		return json;
	}
//	@RequestMapping(value = "/reply_delete", method = RequestMethod.POST)
//	public String delete(int reply_num, int board_num) {
//		replyService.delete(reply_num, board_num);
//		return "redirect:/boardDetail.do?board_num="+vo.getBoard_num();
//	}
}
