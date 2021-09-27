package co.kr.board.VO;

public class BoardVO {

	private int board_num;
	private String board_title;
	private String board_content;
	private String board_author;
	private String board_day;
	private int board_view;

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public String getBoard_title() {
		return board_title;
	}

	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}

	public String getBoard_content() {
		return board_content;
	}

	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}

	public String getBoard_author() {
		return board_author;
	}

	public void setBoard_author(String board_author) {
		this.board_author = board_author;
	}

	public String getBoard_day() {
		return board_day;
	}

	public void setBoard_day(String board_day) {
		this.board_day = board_day;
	}

	public int getBoard_view() {
		return board_view;
	}

	public void setBoard_view(int board_view) {
		this.board_view = board_view;
	}

	public BoardVO(int board_num, String board_title, String board_content, String board_author, String board_day,
			int board_view) {
		super();
		this.board_num = board_num;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_author = board_author;
		this.board_day = board_day;
		this.board_view = board_view;
	}

	public BoardVO() {
		super();
	}

}
