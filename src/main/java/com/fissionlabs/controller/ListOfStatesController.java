package com.fissionlabs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@RestController
public class ListOfStatesController {
	@RequestMapping(value = "/listOfStates", method = RequestMethod.POST)
public List<String> statesList(@RequestBody String query)
{
		List<String> stateList=new ArrayList<String>();
		String uri = "http://172.168.1.17:9200/aadhaardetails/data/_search";
		RestTemplate rt=new RestTemplate();
		String response= rt.postForObject(uri,query,String.class);
		Gson gson = new Gson();
		JsonElement element = gson.fromJson(response, JsonElement.class);
		JsonObject jsonObj = element.getAsJsonObject();
		JsonArray circle = jsonObj.getAsJsonObject("aggregations")
				.getAsJsonObject("states").getAsJsonArray("buckets");
		for (int j = 0; j < circle.size(); j++){
			JsonObject obj = (JsonObject) circle.get(j);
			String state=obj.get("key").getAsString();
			stateList.add(state);

		}
		return stateList;
		
		
}
}
