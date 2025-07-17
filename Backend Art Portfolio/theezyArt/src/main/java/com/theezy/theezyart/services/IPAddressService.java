package com.theezy.theezyart.services;

import com.theezy.theezyart.data.model.IPAddress;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public interface IPAddressService {

    IPAddress geoIPLookup(String ipAddress) throws IOException, InterruptedException;
}
