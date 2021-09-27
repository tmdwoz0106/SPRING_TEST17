package co.kr.reply.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.board.VO.BoardVO;
import co.kr.reply.VO.ReplyVO;
import co.kr.reply.service.ReplyService;
import co.kr.reply.service.mapper.ReplyMapper;

@Service
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	public ReplyMapper replyMapper;

	@Override
	public List<ReplyVO> reply(int board_num) {
		return replyMapper.reply(board_num);
	}

	@Override
	public int replyMax() {
		return replyMapper.replyMax();
	}

	@Override
	public int insert(ReplyVO vo) {
		return replyMapper.insert(vo);
	}

	@Override
	public int delete(int reply_num,int board_num) {
		HashMap<String, Object> delete = new HashMap<String, Object>();
		delete.put("reply_num", reply_num);
		delete.put("board_num", board_num);
		return replyMapper.delete(delete);
	}

	@Override
	public ReplyVO detail(int reply_num, int board_num) {
		HashMap<String, Object> detail = new HashMap<String, Object>();
		detail.put("reply_num", reply_num);
		detail.put("board_num", board_num);
		return replyMapper.detail(detail);
	}



}
