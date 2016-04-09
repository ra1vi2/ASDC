package ra1vi2.asds.DTO;

public class MessageDTO {
	
	private String from;
	private String about;
	private String msg_content;
	private String time;
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getMsg_content() {
		return msg_content;
	}
	public void setMsg_content(String msg_content) {
		this.msg_content = msg_content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "MessageDTO [from=" + from + ", about=" + about
				+ ", msg_content=" + msg_content + ", time=" + time + "]";
	}

}
