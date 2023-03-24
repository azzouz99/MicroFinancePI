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
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_user;
    private String user_firstname;
    private String user_lastname;
    private String email_address;
    private String user_password;
    @Enumerated
    private User_role role;
    private String profile_picture;
    private String user_phone;
    private String Fn_rapport;
    private Float amount;
    @OneToMany(mappedBy ="user" )
    private List<Request> requests;
}
