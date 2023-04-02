package com.example.pidev_finance.repositories;

import com.example.pidev_finance.entities.Offers_Credit;
import com.example.pidev_finance.entities.Request;
import com.example.pidev_finance.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IUserRepository extends JpaRepository <User,Integer> {



}
