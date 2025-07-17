package com.theezy.theezyart.data.model;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
public class LoginHistory {
    @Id
    private String id;
    private String email;
    private String method;
    private String endpoint;
    private IPAddress ipAddress;
    private LocalDateTime timeStamp;
}
