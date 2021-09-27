package co.kr.user.VO;

public class UserVO {

	private int user_num;
	private String user_id;
	private String user_pw;
	private String user_name;
	private String msg;

	public int getUser_num() {
		return user_num;
	}

	public void setUser_num(int user_num) {
		this.user_num = user_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public UserVO(int user_num, String user_id, String user_pw, String user_name, String msg) {
		super();
		this.user_num = user_num;
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.user_name = user_name;
		this.msg = msg;
	}

	public UserVO() {
		super();
	}

}
