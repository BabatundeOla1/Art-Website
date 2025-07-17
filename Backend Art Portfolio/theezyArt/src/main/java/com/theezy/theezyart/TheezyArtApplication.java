package com.theezy.theezyart;

import com.theezy.theezyart.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TheezyArtApplication implements CommandLineRunner {

    @Autowired
    private AdminService adminService;

    public static void main(String[] args) {
        SpringApplication.run(TheezyArtApplication.class, args);
    }

    @Override
    public void run(String... args) {
        adminService.register();
    }
}
