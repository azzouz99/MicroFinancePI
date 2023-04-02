package com.example.pidev_finance.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class AccOrRef implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_AccOrRef;
    private String check_loan;


    @OneToOne
    @JoinColumn(name = "id_request")
    private Request request;



}