package dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

//@XmlRootElement(name="crime")
public class Crime {

	private int id;
	private String crimeRegion;
	private String crimeType;
	private String suspectDetails;

	public Crime() {

	}

	public Crime(String crimeRegion, String crimeType, String suspectDetails,
			int id) {
		// super();
		this.setId(id);
		this.crimeRegion = crimeRegion;
		this.crimeType = crimeType;
		this.suspectDetails = suspectDetails;
	}
   
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    
	public String getCrimeRegion() {
		return crimeRegion;
	}

	public void setCrimeRegion(String crimeRegion) {
		this.crimeRegion = crimeRegion;
	}
    @XmlElement
	public String getCrimeType() {
		return crimeType;
	}

	public void setCrimeType(String crimeType) {
		this.crimeType = crimeType;
	}
    
	public String getSuspectDetails() {
		return suspectDetails;
	}

	public void setSuspectDetails(String suspectDetails) {
		this.suspectDetails = suspectDetails;
	}

	@Override
	public String toString() {
		return "Crime [id=" + id + ", crimeRegion=" + crimeRegion
				+ ", crimeType=" + crimeType + ", suspectDetails="
				+ suspectDetails + "]";
	}

}
