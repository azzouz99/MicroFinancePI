package com.example.microfinancepi.entities;

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
public class Offers_Credit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_offer;
    @Enumerated(EnumType.STRING)
    private Type_of_credit credit;
    private Integer max_amount;
    private Integer min_amount;
    private String interest_rate;

    private String date_creation;

    private String repayment_period;



    @OneToMany(mappedBy ="offer" )
    private List<Request> requests;







}
