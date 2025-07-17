package com.theezy.theezyart.controller;

import com.theezy.theezyart.data.repositories.AdminRepository;
import com.theezy.theezyart.dto.request.AdminLoginRequest;
import com.theezy.theezyart.dto.response.AdminLoginResponse;
import com.theezy.theezyart.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("api/auth/")
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping("login")
    public ResponseEntity<AdminLoginResponse> login(@RequestBody AdminLoginRequest adminLoginRequest){
        AdminLoginResponse loginResponse = adminService.login(adminLoginRequest);
        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }
}
