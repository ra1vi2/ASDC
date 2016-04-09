package ra1vi2.asds.DTO;

public class FacultyInsecDTO {

	private String fac_id;
	private String subject;
	public String getFac_id() {
		return fac_id;
	}
	public void setFac_id(String fac_id) {
		this.fac_id = fac_id;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "FacultyInsecDTO [fac_id=" + fac_id + ", subject=" + subject
				+ "]";
	}
	
}
