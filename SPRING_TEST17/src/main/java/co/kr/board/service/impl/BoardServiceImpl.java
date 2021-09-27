package co.kr.board.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.kr.board.VO.BoardVO;
import co.kr.board.service.BoardService;
import co.kr.board.service.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	public BoardMapper boardMapper;

	@Override
	public List<BoardVO> list(int page, String type, String keyword) {
		int amount = 10;
		HashMap<String, Object> show = new HashMap<String, Object>();
		show.put("startRn", (page-1)*amount);
		show.put("endRn", page*amount);
		show.put("type",type);
		show.put("keyword", keyword);
		return boardMapper.list(show);
	}

	@Override
	public int total(String type, String keyword) {
		HashMap<String, Object> list = new HashMap<String, Object>();
		list.put("type",type);
		list.put("keyword", keyword);
		return boardMapper.total(list);
	}

	@Override
	public BoardVO detail(int board_num) {
		
		return boardMapper.detail(board_num);
	}

	@Override
	public int cntUp(BoardVO vo) {
		return boardMapper.cntUp(vo);
	}

	@Override
	public int insert(BoardVO vo) {
		return boardMapper.insert(vo);
	}

	@Override
	public int cntMax() {
		return boardMapper.cntMax();
	}

	@Override
	public int delete(int board_num) {
		return boardMapper.delete(board_num);
	}

	@Override
	public int modify(BoardVO vo) {
		return boardMapper.modify(vo);
	}
}
