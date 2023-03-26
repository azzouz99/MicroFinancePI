package com.example.pidev_finance.repositories;


import com.example.pidev_finance.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IUserRepository extends JpaRepository<User, Integer> {
}
