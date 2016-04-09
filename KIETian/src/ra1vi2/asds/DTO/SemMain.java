package ra1vi2.asds.DTO;

public class SemMain {
	private String sem;
	private String sec;
	private String roomno;
	private String status;
	public String getSem() {
		return sem;
	}
	public void setSem(String sem) {
		this.sem = sem;
	}
	public String getSec() {
		return sec;
	}
	public void setSec(String sec) {
		this.sec = sec;
	}
	public String getRoomno() {
		return roomno;
	}
	public void setRoomno(String roomno) {
		this.roomno = roomno;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "SemMain [sem=" + sem + ", sec=" + sec + ", roomno=" + roomno
				+ ", status=" + status + "]";
	}
	

}
