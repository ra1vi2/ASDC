package ra1vi2.asds.DTO;

public class FreeFacNSec {

	private  String sem;
	private String sec;
	private String fac_id;
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
	public String getFac_id() {
		return fac_id;
	}
	public void setFac_id(String fac_id) {
		this.fac_id = fac_id;
	}
	@Override
	public String toString() {
		return "FreeFacNSec [sem=" + sem + ", sec=" + sec + ", fac_id="
				+ fac_id + "]";
	}
	
	
}
