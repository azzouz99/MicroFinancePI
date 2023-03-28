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
public class Investment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_invest;
    private Integer id_client;
    private Float amount_inv;
    private Date date_inv;
    private Date datefin;
    private Status_Tr status;
    @Enumerated
    private Periode periode;
    private Float win;
    @OneToMany(mappedBy = "investment")
    private List<Transaction> transactions;
    @ManyToOne
    private User user;
}
