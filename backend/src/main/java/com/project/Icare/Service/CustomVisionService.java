package com.project.Icare.Service;

import org.springframework.web.multipart.MultipartFile;

import com.project.Icare.CollectionDTO.CustomVisionDTO;

public interface CustomVisionService {
	CustomVisionDTO uploadImage(MultipartFile file );
}
