package com.project.webapp.Controller;

import com.project.webapp.DTO.AloginDto;
import com.project.webapp.Entity.Admin;
import com.project.webapp.Exception.ResourceNotFound;
import com.project.webapp.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin("http://localhost:5173") // Removed trailing slash
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Admin register(@RequestBody Admin admin){
        return adminService.register(admin);
    }

    @GetMapping("/exist/admin/{email}")
    public ResponseEntity<Admin> findAdmin(@PathVariable(value = "email") String email){
        Admin resAdmin = adminService.findAdmin(email).orElseThrow(
                ()->new ResourceNotFound("Admin Not exist with Email " +email)
        );
        return ResponseEntity.ok(resAdmin);
    }

    @PostMapping("/login/admin")
    public ResponseEntity<AloginDto> loginAdmin(@RequestBody AloginDto loginDao){
        AloginDto logRes = adminService.loginAdmin(loginDao.getEmail(), loginDao.getPassword()).orElseThrow(
                ()->new ResourceNotFound("mail And Password Error")
        );
        return ResponseEntity.ok(logRes);
    }
}
