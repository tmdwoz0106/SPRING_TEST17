package co.kr.reply.service;

import java.util.List;

import co.kr.board.VO.BoardVO;
import co.kr.reply.VO.ReplyVO;

public interface ReplyService {

	public List<ReplyVO> reply(int board_num);

	public int replyMax();

	public int insert(ReplyVO vo);

	public int delete(int reply_num,int board_num);

	public ReplyVO detail(int reply_num,int board_num);



}
