package ra1vi2.asds.DTO;

public class TimeTableDTO {
	
	private String subject;
	private String fac_id;
	private String time;
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getFac_id() {
		return fac_id;
	}
	public void setFac_id(String fac_id) {
		this.fac_id = fac_id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "TimeTableDTO [subject=" + subject + ", fac_id=" + fac_id
				+ ", time=" + time + "]";
	}

}
