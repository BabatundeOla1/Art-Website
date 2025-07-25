package com.theezy.theezyart.services;

import com.theezy.theezyart.data.repositories.AdminRepository;
import com.theezy.theezyart.dto.request.AdminLoginRequest;
import com.theezy.theezyart.dto.response.AdminLoginResponse;
import com.theezy.theezyart.utils.exceptions.AdminNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AdminServiceImplTest {

    @Value("${admin.email}")
    private String adminEmail;

    @Value("${admin.password}")
    private String adminPassword;

    @Autowired
    private AdminService adminService;

    @Autowired
    private AdminRepository adminRepository;


    @Test
    void testThatAminCanLogin() {
        AdminLoginRequest admin = new AdminLoginRequest();
        admin.setEmail(adminEmail);
        admin.setPassword(adminPassword);

        AdminLoginResponse response = adminService.login(admin);
        assertNotNull(response);
    }

    @Test
    void testThatJWT_TokenIsGeneratedAfterLogin(){
        AdminLoginRequest admin = new AdminLoginRequest();
        admin.setEmail(adminEmail);
        admin.setPassword(adminPassword);

        AdminLoginResponse response = adminService.login(admin);
        assertThat(response.getAccessToken()).isNotEmpty();
        assertThat(response.getAccessToken()).isNotNull();
    }

    @Test
    void testThatPermanentAdminIsStoredInRepo(){
        adminService.register();
        assertEquals(1, adminRepository.count());
    }

    @Test
    void testThatAdminCantLoginWithIncorrectCredentials(){
        adminService.register();
        assertEquals(1, adminRepository.count());

        AdminLoginRequest admin = new AdminLoginRequest();
        admin.setEmail(adminEmail);
        admin.setPassword("Invalid Password");

        assertThrows(AdminNotFoundException.class, ()-> adminService.login(admin));
    }


}