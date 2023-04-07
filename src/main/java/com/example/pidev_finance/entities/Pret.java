package com.example.pidev_finance.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pret implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_pret;
    private Float amount;
    private Integer investmentPeriodInMonths;
    private Date date_inv;
    private Date datefin;
    private Float Interest;

    private Integer id_user;
    @OneToMany(mappedBy = "pret")
    private List<Transaction> transactions;
}
