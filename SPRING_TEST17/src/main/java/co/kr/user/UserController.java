package co.kr.user;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import co.kr.user.VO.UserVO;
import co.kr.user.service.UserService;

@Controller
public class UserController {

	@Autowired
	public UserService userService;
	//-----------------------------로그인---------------------------------
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String login() {
		
		return "home";
	}
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public ModelAndView login_ajax(String user_id,String user_pw, HttpSession session) {
		ModelAndView json = new ModelAndView("jsonView");
		UserVO vo = userService.login(user_id,user_pw,session);
		json.addObject("vo", vo);
		return json;
	}
	//-----------------------------로그아웃---------------------------------
	@RequestMapping(value = "/logout.do", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		ModelAndView json = new ModelAndView("jsonView");
		
		session.invalidate();
		
		return json;
	}
	//-----------------------------회원가입---------------------------------
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String join(Model model) {
		int max = userService.cntMax();
		model.addAttribute("max", max+1);
		return "user/join";
	}
	@RequestMapping(value = "/joinAjax.do", method = RequestMethod.POST)
	public ModelAndView join_ajax(UserVO vo) {
		ModelAndView json = new ModelAndView("jsonView");
		if(userService.join(vo) > 0) {
			json.addObject("msg", "회원가입 성공" );
			json.addObject("result", "1" );
		}else {
			json.addObject("msg", "이미 있는 아이디입니다." );
			json.addObject("result", "0" );
		}
		return json;
	}
	//-----------------------------회원 상세보기---------------------------------
	@RequestMapping(value = "/userDetail.do", method = RequestMethod.GET)
	public String userDetail(String user_id,Model model,HttpSession session) {
		String id = (String)session.getAttribute("user_id");
		UserVO vo = userService.detail(user_id);
		model.addAttribute("id", id);
		model.addAttribute("vo", vo);
		return "user/detail";
	}
	//-----------------------------회원탈퇴---------------------------------
	@RequestMapping(value = "/userDelete.do", method = RequestMethod.POST)
	public ModelAndView delete(String user_id) {
		ModelAndView json = new ModelAndView("jsonView");
		
		json.addObject("vo", userService.delete(user_id));

		return json;
	}
	//-----------------------------회원수정---------------------------------
	@RequestMapping(value = "/userModify.do",method = RequestMethod.GET)
	public String modify(Model model,String user_id) {
		UserVO vo = userService.detail(user_id);
		model.addAttribute("vo", vo);
		return "user/modify";
	}
	@RequestMapping(value = "/userModifyAjax.do", method = RequestMethod.POST)
	public ModelAndView modify_ajax(UserVO vo) {
		ModelAndView json = new ModelAndView("jsonView");
		json.addObject("vo", userService.modify(vo));
		return json;
	}
	
}
