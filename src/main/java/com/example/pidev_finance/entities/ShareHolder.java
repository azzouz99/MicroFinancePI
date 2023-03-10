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
public class ShareHolder implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idShareholder;
    private String lastNameShareholder;
    private String FirstNameShareholder;
    private double investment;
    private String Email;
    private int numTel;
    @Enumerated
    private TypeShareholder partner;
    @ManyToOne
    private Event event;
}
