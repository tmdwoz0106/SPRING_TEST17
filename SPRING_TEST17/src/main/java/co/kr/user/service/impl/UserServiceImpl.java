package co.kr.user.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.user.VO.UserVO;
import co.kr.user.service.UserService;
import co.kr.user.service.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserMapper userMapper;

	@Override
	public UserVO login(String user_id, String user_pw, HttpSession session) {
		HashMap<String, Object> login = new HashMap<String, Object>();
		UserVO vo = new UserVO();
		int i = userMapper.idCheck(user_id);
		if (i > 0) {
			login.put("user_id", user_id);
			login.put("user_pw", user_pw);
			vo = userMapper.login(login);
			if (vo == null) {
				vo = new UserVO();
				vo.setMsg("잘못된 비밀번호입니다.");
				return vo;
			} else {
				session.setAttribute("user_id", user_id);
				return vo;
			}
		} else {
			vo = new UserVO();
			vo.setMsg("없는 아이디입니다.");
			return vo;
		}
	}

	@Override
	public int join(UserVO vo) {
		List<UserVO> list = userMapper.userId();
		for (int i = 0; i < list.size(); i++) {
			if(vo.getUser_id().equals(list.get(i).getUser_id())) {
				return 0;
			}
		}
		return userMapper.join(vo);
	}

	@Override
	public int cntMax() {
		return userMapper.cntMax();
	}

	@Override
	public int delete(String user_id) {
		
		return userMapper.delete(user_id);
	}

	@Override
	public UserVO detail(String user_id) {
		return userMapper.detail(user_id);
	}

	@Override
	public int modify(UserVO vo) {
		return userMapper.modify(vo);
	}


}
