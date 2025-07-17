package com.theezy.theezyart.data.repositories;

import com.theezy.theezyart.data.model.LoginHistory;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LoginHistoryRepository extends MongoRepository<LoginHistory, String> {

}
