package com.theezy.theezyart.services;

import com.theezy.theezyart.data.model.Admin;
import com.theezy.theezyart.dto.request.AdminLoginRequest;
import com.theezy.theezyart.dto.request.AdminRegisterRequest;
import com.theezy.theezyart.dto.response.AdminLoginResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    UserDetails loadUserByUsername(String email) throws UsernameNotFoundException;

    AdminLoginResponse login(AdminLoginRequest adminLoginRequest);
    void register();

}
