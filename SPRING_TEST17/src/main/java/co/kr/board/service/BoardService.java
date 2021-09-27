package co.kr.board.service;

import java.util.List;

import co.kr.board.VO.BoardVO;

public interface BoardService {

	public List<BoardVO> list(int page, String type, String keyword);

	public int total(String type,String keyword);

	public BoardVO detail(int board_num);

	public int cntUp(BoardVO vo);
	
	public int insert(BoardVO vo);

	public int cntMax();

	public int delete(int board_num);

	public int modify(BoardVO vo);

}
