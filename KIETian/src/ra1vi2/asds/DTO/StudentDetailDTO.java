package ra1vi2.asds.DTO;

public class StudentDetailDTO {
	
	private String roll_no;
	private String name;
	private String semester;
	private String section;
	private String subject;
	private String sub_att;
	public String getRoll_no() {
		return roll_no;
	}
	public void setRoll_no(String roll_no) {
		this.roll_no = roll_no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getSub_att() {
		return sub_att;
	}
	public void setSub_att(String sub_att) {
		this.sub_att = sub_att;
	}
	@Override
	public String toString() {
		return "StudentDetail [roll_no=" + roll_no + ", name=" + name
				+ ", semester=" + semester + ", section=" + section
				+ ", subject=" + subject + ", sub_att=" + sub_att + "]";
	}
	
	

}
