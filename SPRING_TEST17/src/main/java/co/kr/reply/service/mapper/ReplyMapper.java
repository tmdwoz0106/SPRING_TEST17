package co.kr.reply.service.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.kr.board.VO.BoardVO;
import co.kr.reply.VO.ReplyVO;

@Mapper
public interface ReplyMapper {

	public List<ReplyVO> reply(int board_num);

	public int replyMax();

	public int insert(ReplyVO vo);

	public ReplyVO detail(HashMap<String, Object> detail);

	public int delete(HashMap<String, Object> delete);



}
