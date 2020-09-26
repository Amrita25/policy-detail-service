package io.policydetailservice.policydetailservice.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import io.policydetailservice.policydetailservice.model.Driver;
import io.policydetailservice.policydetailservice.model.DriverInfraction;
import io.policydetailservice.policydetailservice.model.Infraction;
import io.policydetailservice.policydetailservice.model.PolicyDetail;
import io.policydetailservice.policydetailservice.model.Premium;
import io.policydetailservice.policydetailservice.service.PolicyDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class PolicyDetailsController {

	@Value("${DRIVER_INFRACTION_URI:http://192.168.99.100:8085}")
	private String driverInfractionServiceHost;

	@Value("${PREMIUM_SERVICE_URI:http://192.168.99.100:8086}")
	private String policyPremiumServiceHost;

	@Autowired
	PolicyDetailsService service;

	@Autowired
	private RestTemplate restTemplate;

	@PostMapping("/add-policy")
	public ResponseEntity<PolicyDetail> savePolicyDetails(@RequestBody PolicyDetail policy){
		System.out.println("inside savePolicyDetails method");
		//PolicyDetail policy = new PolicyDetail(polNum);
		//addListOfDrivers(policy);
		policy.getDrivers().forEach(dr->{
			ResponseEntity<DriverInfraction> responseEntity=restTemplate.getForEntity(driverInfractionServiceHost+"/api/driver-infraction-service/driver-infraction/{licenseNum}", DriverInfraction.class,createUriVariables(dr.getLicenseNumber()));
			DriverInfraction response = responseEntity.getBody();
			List<Infraction> responseInfraction = response.getInfractions();
			List<Infraction> drvInfractions = new ArrayList<>();
			drvInfractions=responseInfraction.stream().map(infraction->{
				return new Infraction(infraction.getInfractionNumber(), infraction.getInfractionType(), infraction.getAccidentDate());
			}).collect(Collectors.toList());

			dr.setInfractions(drvInfractions);
		});

		Premium premium = restTemplate.getForObject(policyPremiumServiceHost+"/api/policy-premium-service/get-premium", Premium.class);
		policy.setTotalPremium(premium);
		return new ResponseEntity<PolicyDetail>(service.saveNewPolicy(policy),HttpStatus.CREATED);
	}

	@GetMapping("/get-policy/{policyNumber}")
	public PolicyDetail retrievePolicyDetails(@PathVariable String policyNumber){
		return service.findByPolicyNumber(policyNumber);

	}

	private Map<String, String> createUriVariables(String licenseNumber) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("licenseNum", licenseNumber);
		return uriVariables;
	}
	private void addListOfDrivers(PolicyDetail policy){
		Driver driver1 = new Driver("Driver1","BVY123");
		Driver driver2 = new Driver("Driver2","ABC123");
		Driver driver3 = new Driver("Driver3","DEF123");

		/*List<Infraction> infractionList1 = new ArrayList<Infraction>();
		infractionList1.add(new Infraction("001","ATFAULT",new Date()));
		driver1.setInfractions(infractionList1);

		List<Infraction> infractionList2 = new ArrayList<Infraction>();
		infractionList2.add(new Infraction("002","NOTATFAULT",new Date()));
		driver2.setInfractions(infractionList2);*/

		List<Driver> drivers = new ArrayList<>();
		drivers.add(driver1);
		drivers.add(driver2);
		drivers.add(driver3);
		policy.setDrivers(drivers);
	}


}
