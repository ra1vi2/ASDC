package ra1vi2.asds.DTO;

public class FacatttodadayDTO {
	
	private String fac_id;
	private String attendance;
	private String status;
	public String getFac_id() {
		return fac_id;
	}
	public void setFac_id(String fac_id) {
		this.fac_id = fac_id;
	}
	public String getAttendance() {
		return attendance;
	}
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "FacatttodadayDTO [fac_id=" + fac_id + ", attendance="
				+ attendance + ", status=" + status + "]";
	}
	
	

}
