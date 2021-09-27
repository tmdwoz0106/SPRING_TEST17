package co.kr.reply.VO;

public class ReplyVO {

	private int reply_num;
	private int board_num;
	private String reply_content;
	private String reply_author;
	private String reply_day;
	private int reply_group;
	private int reply_depth;

	public int getReply_num() {
		return reply_num;
	}

	public void setReply_num(int reply_num) {
		this.reply_num = reply_num;
	}

	public int getBoard_num() {
		return board_num;
	}

	public void setBoard_num(int board_num) {
		this.board_num = board_num;
	}

	public String getReply_content() {
		return reply_content;
	}

	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}

	public String getReply_author() {
		return reply_author;
	}

	public void setReply_author(String reply_author) {
		this.reply_author = reply_author;
	}

	public String getReply_day() {
		return reply_day;
	}

	public void setReply_day(String reply_day) {
		this.reply_day = reply_day;
	}

	public int getReply_group() {
		return reply_group;
	}

	public void setReply_group(int reply_group) {
		this.reply_group = reply_group;
	}

	public int getReply_depth() {
		return reply_depth;
	}

	public void setReply_depth(int reply_depth) {
		this.reply_depth = reply_depth;
	}

	public ReplyVO(int reply_num, int board_num, String reply_content, String reply_author, String reply_day,
			int reply_group, int reply_depth) {
		super();
		this.reply_num = reply_num;
		this.board_num = board_num;
		this.reply_content = reply_content;
		this.reply_author = reply_author;
		this.reply_day = reply_day;
		this.reply_group = reply_group;
		this.reply_depth = reply_depth;
	}

	public ReplyVO() {
		super();
	}

}
