package io.policydetailservice.policydetailservice.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="INFRACTION_POLICY")
public class Infraction {
	@Id
	@GeneratedValue
	private Long infractionID;
	private String infractionNumber;
	private String infractionType;
	private Date accidentDate;
	
	
	public Infraction(){
		
	}
	public Infraction(String infractionNumber, String infractionType,
			Date accidentDate) {
		super();
		this.infractionNumber = infractionNumber;
		this.infractionType = infractionType;
		this.accidentDate = accidentDate;
	}
	public Long getInfractionID() {
		return infractionID;
	}
	public void setInfractionID(Long infractionID) {
		this.infractionID = infractionID;
	}
	public String getInfractionNumber() {
		return infractionNumber;
	}
	public void setInfractionNumber(String infractionNumber) {
		this.infractionNumber = infractionNumber;
	}
	public String getInfractionType() {
		return infractionType;
	}
	public void setInfractionType(String infractionType) {
		this.infractionType = infractionType;
	}
	public Date getAccidentDate() {
		return accidentDate;
	}
	public void setAccidentDate(Date accidentDate) {
		this.accidentDate = accidentDate;
	}
	
	

}
