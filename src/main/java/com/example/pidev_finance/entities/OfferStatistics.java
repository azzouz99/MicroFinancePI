package com.example.pidev_finance.entities;


import lombok.*;

import javax.persistence.*;
import java.io.Serializable;



@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class OfferStatistics implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer offerId;
    private Integer acceptedRequests;
    private Integer rejectedRequests;
    private Integer pendingRequests;
}
