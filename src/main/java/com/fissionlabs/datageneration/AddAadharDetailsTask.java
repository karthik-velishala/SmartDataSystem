package com.fissionlabs.datageneration;

import java.util.ArrayList;

import org.springframework.web.client.RestTemplate;

import com.fissionlabs.model.AadhaarDetails;
import com.fissionlabs.model.Response;

public class AddAadharDetailsTask implements Runnable{

	ArrayList<AadhaarDetails> adharDetailsList;

	Long currentTime;

	AddAadharDetailsTask(ArrayList<AadhaarDetails> adharDetailsList){
		this.adharDetailsList = adharDetailsList;
	}

	@Override
	public void run() {

		String url = "http://172.168.1.17:9200/todayaadhaardetails/data";

		RestTemplate rt = new RestTemplate();
		Response res=new Response();
		res.setDetails(adharDetailsList);

		rt.postForEntity(url, res, null);

		System.out.println("The time difference is: "+(System.currentTimeMillis() - currentTime));

	}
}
