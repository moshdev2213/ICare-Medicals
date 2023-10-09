package com.project.Icare.Controller;

import com.project.Icare.Service.CustomVisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
