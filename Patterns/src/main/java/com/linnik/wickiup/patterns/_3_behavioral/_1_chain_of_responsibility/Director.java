package com.linnik.wickiup.patterns._3_behavioral._1_chain_of_responsibility;

/**
 * @author LinnykOleh
 */
public class Director extends Handler{

	@Override
	public void handleRequest(Request request) {
		if(request.getRequestType() == RequestType.CONFERENCE){
			System.out.println("Directors can approve conferences");
		}else {
			successor.handleRequest(request);
		}
	}
}
