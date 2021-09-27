package co.kr.board.service.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import co.kr.board.VO.BoardVO;

@Mapper
public interface BoardMapper {

	public List<BoardVO> list(HashMap<String, Object> show);

	public int total(HashMap<String, Object> list);

	public BoardVO detail(int board_num);

	public int cntUp(BoardVO vo);

	public int insert(BoardVO vo);

	public int cntMax();

	public int delete(int board_num);

	public int modify(BoardVO vo);

}
