package com.java.spring_sec.domain;

import lombok.*;


import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

import static javax.persistence.FetchType.*;
import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy=AUTO)
    private Long id;
    private String name;
    private String username;
    private String password;
    @ManyToMany(fetch =EAGER)
    private Collection<Role> roles=new ArrayList<>();
}
