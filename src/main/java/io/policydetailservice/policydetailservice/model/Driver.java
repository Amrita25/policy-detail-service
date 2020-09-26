package io.policydetailservice.policydetailservice.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Driver {
	@Id
	@GeneratedValue
	private Long id;
	private String driverName;
	private String licenseNumber;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="driver_id")
	private List<Infraction> infractions;
	
	public Driver(){
		
	}

	public Driver(String driverName, String licenseNumber) {
		super();
		this.driverName = driverName;
		this.licenseNumber = licenseNumber;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public List<Infraction> getInfractions() {
		return infractions;
	}

	public void setInfractions(List<Infraction> infractions) {
		this.infractions = infractions;
	}
	
	

}
