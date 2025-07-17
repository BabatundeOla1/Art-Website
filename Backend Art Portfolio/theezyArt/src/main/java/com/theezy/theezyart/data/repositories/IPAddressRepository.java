package com.theezy.theezyart.data.repositories;

import com.theezy.theezyart.data.model.IPAddress;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IPAddressRepository extends MongoRepository<IPAddress, String> {
}
