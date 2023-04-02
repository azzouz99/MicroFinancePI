package com.example.pidev_finance.repositories;

import com.example.pidev_finance.entities.AccOrRef;
import com.example.pidev_finance.entities.Request;
import com.example.pidev_finance.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAccOrRefRepository extends JpaRepository<AccOrRef, Integer> {
 /*   @Query("SELECT a FROM AccOrRef a JOIN a.request r JOIN r.user u WHERE u.id_user = :id_user")
    List<AccOrRef> find(@Param("id_user") Integer id_user);*/

}
