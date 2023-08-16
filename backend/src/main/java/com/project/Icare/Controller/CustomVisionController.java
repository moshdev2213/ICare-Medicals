package com.project.Icare.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.project.Icare.Service.CustomVisionService;

@RestController
@RequestMapping("/api/scan/eye")
@CrossOrigin("*")
public class CustomVisionController {
	
	@Autowired
	private CustomVisionService customVisionService;
	
	@PostMapping
	public ResponseEntity<?> fileUpload (@RequestParam("image") MultipartFile image){
		return ResponseEntity.ok(this.customVisionService.uploadImage(image));
	}
}
