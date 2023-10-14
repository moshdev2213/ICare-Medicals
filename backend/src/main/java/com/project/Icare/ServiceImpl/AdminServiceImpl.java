package com.project.Icare.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Icare.Collection.Admin;
import com.project.Icare.CollectionDTO.AloginDto;
import com.project.Icare.Repo.AdminRepo;
import com.project.Icare.Service.AdminService;

import java.util.Optional;
import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepo adminRepo;
    @Override
    public Admin register(Admin admin) {
        String aid = UUID.randomUUID().toString().split("-")[0];
        admin.setId(aid);
        return adminRepo.save(admin);
    }

    @Override
    public Optional<Admin> findAdmin(String email) {
        Optional<Admin> resAdmin = adminRepo.findByEmail(email);
        return resAdmin;
    }

    @Override
    public Optional<AloginDto> loginAdmin(String email, String password) {
        Optional<AloginDto> resLoginOptional = adminRepo.findByEmailAndPassword(email, password);
        return resLoginOptional;
    }

	
}
