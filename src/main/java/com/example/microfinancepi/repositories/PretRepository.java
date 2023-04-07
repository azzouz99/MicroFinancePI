package com.example.microfinancepi.repositories;

import com.example.microfinancepi.entities.Pret;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface PretRepository extends JpaRepository<Pret,Integer> {
    List<Pret> findByDatefinBefore(Date date);
}
