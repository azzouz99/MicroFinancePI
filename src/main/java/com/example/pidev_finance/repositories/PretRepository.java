package com.example.pidev_finance.repositories;

import com.example.pidev_finance.entities.Pret;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PretRepository extends JpaRepository<Pret,Integer> {
    List<Pret> findByDatefinBefore(Date date);
}
