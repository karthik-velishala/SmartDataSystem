package com.fissionlabs.model;

import java.util.ArrayList;
import java.util.List;

public class Response {
private List<AadhaarDetails> details=new ArrayList<AadhaarDetails>();

public List<AadhaarDetails> getDetails() {
	return details;
}

public void setDetails(List<AadhaarDetails> details) {
	this.details = details;
}
}
