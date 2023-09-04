package com.project.Icare.EmailTemps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SendLkSms {
	private final String URL = "https://sms.send.lk/api/v3/sms/send";
	private final String TOKEN = "1102|63zKUEcqXIOjKCbQFmI3PJajH0v1Q0mIkUHg7fNZ";

	@Autowired
	private RestTemplate restTemplate;

	public void sendSms(String reciver, String msg) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Authorization", "Bearer " + TOKEN);
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);

		String requestBody = "{\"recipient\": \"" + reciver + "\", \"sender_id\" : \"SendTest\", \"message\":\"" + msg
				+ "\"}";
		HttpEntity<String> reqEntity = new HttpEntity<>(requestBody, headers);

		/*
		  You can certainly use MultiValueMap to achieve the same result. However, in
		  this specific case, the API you are using expects the request body to be in
		  JSON format, not application/x-www-form-urlencoded format, which is commonly
		  used with MultiValueMap.
		  
		  The SMS API expects the request body in the JSON: 
			  example as below:- 
			  {
			  	"recipient": "your_mobile_number", 
			  	"sender_id": "YourSenderId", 
			  	"message":"Your_message" 
			  }
		  
		  MultiValueMap is commonly used for form data where the request body is in
		  application/x-www-form-urlencoded format like:-
		  	  recipient=your_mobile_number&sender_id=YourSenderId&message=Your_message
		  
		  
		  In this case, using MultiValueMap might not be the most appropriate choice as
		  it does not directly support sending data in JSON format. For sending data in
		  JSON format, using a String to hold the JSON payload in the request body and
		  setting the appropriate Content-Type header is more suitable.
		  
		  That being said, you can still use MultiValueMap if the API allows
		  application/x-www-form-urlencoded data for this specific case, but you'll
		  need to serialize your data manually to JSON format. However, using a String
		  and setting the Content-Type header to application/json is more
		  straightforward and commonly used for JSON payloads.
		 */
		
//		MultiValueMap<String, String> bodyMap = new LinkedMultiValueMap<>();
//		bodyMap.add("recipient", reciver);
//		bodyMap.add("sender_id", "sendTest");
//		bodyMap.add("message", msg);
//		HttpEntity<MultiValueMap<String, String>> reqEntity = new HttpEntity<>(bodyMap, headers);

		ResponseEntity<String> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, reqEntity, String.class);

//		System.out.println(reqEntity.toString() + " " + responseEntity.getBody());
	}
}
