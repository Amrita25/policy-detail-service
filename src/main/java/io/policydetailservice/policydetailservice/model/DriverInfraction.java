package io.policydetailservice.policydetailservice.model;

import java.util.List;

public class DriverInfraction {
	private List<Infraction> infractions;

	public List<Infraction> getInfractions() {
		return infractions;
	}

	public void setInfractions(List<Infraction> infractions) {
		this.infractions = infractions;
	}
	
}
