package co.kr.user.service.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.kr.user.VO.UserVO;

@Mapper
public interface UserMapper {

	public int idCheck(String user_id);

	public UserVO login(HashMap<String, Object> login);

	public int join(UserVO vo);

	public List<UserVO> userId();

	public int cntMax();

	public int delete(String user_id);

	public UserVO detail(String user_id);

	public int modify(UserVO vo);

}
