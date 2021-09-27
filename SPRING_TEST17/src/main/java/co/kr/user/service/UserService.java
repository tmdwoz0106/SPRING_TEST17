package co.kr.user.service;

import javax.servlet.http.HttpSession;

import co.kr.user.VO.UserVO;

public interface UserService {

	public UserVO login(String user_id, String user_pw,HttpSession session);

	public int join(UserVO vo);

	public int cntMax();

	public int delete(String user_id);

	public UserVO detail(String user_id);

	public int modify(UserVO vo);

}
