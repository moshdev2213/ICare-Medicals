package com.project.Icare.Service;

import com.project.Icare.CollectionDTO.CustomVisionDTO;
import org.springframework.web.multipart.MultipartFile;

public interface CustomVisionService {
	CustomVisionDTO uploadImage(MultipartFile file );
}
