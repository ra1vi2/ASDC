package ra1vi2.asds.DTO;

public class StudentListDTO {
	
	private String name;
	private String rollno;
	private String attendance;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public String getAttendance() {
		return attendance;
	}
	public void setAttendance(String attendance) {
		this.attendance = attendance;
	}
	@Override
	public String toString() {
		return "StudentListDTO [name=" + name + ", rollno=" + rollno
				+ ", attendance=" + attendance + "]";
	}
	
}
