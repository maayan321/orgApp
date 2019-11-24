package com.example.orgApp.repositories;

import com.example.orgApp.objects.Manager;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends MongoRepository<Manager, String> {

}

