package com.project.Icare.ServiceImpl;

import com.project.Icare.CollectionDTO.CustomVisionDTO;
import com.project.Icare.Exception.ImageException;
import com.project.Icare.Service.CustomVisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
@Service
public class CustomVisionImpl implements CustomVisionService {
	private static final String URL = "https://icare-prediction.cognitiveservices.azure.com/customvision/v3.0/Prediction/311714ad-d62f-4880-aad5-16407c6859ab/classify/iterations/ICare/image";
	private static final String PREDKEY = "5db61c6ea94645959688878437a3720f";
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public CustomVisionDTO uploadImage(MultipartFile file) {
		HttpHeaders headers = new HttpHeaders();
		 headers.set("Prediction-Key", PREDKEY);
		 
		 MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
		 body.add("image", file.getResource());
		 
		 HttpEntity<MultiValueMap<String, Object>> reqEntity =  new HttpEntity<>(body,headers);
		 
		 try {
	    	 ResponseEntity<CustomVisionDTO> responseEntity = restTemplate.exchange(URL, HttpMethod.POST, reqEntity, CustomVisionDTO.class);
	    	 return responseEntity.getBody();
	    } catch (RestClientException e) {
	    	 // Handle the exception and create an error response
	        e.printStackTrace();
	        String errorMessage = "Bad Request Image Format, Uri: " + file.getOriginalFilename();
	        ImageException errorResponse = new ImageException("BadRequestImageFormat", errorMessage);
	        return new CustomVisionDTO();
	    }
	} 
}
