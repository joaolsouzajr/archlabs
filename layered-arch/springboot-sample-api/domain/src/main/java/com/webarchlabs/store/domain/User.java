package com.webarchlabs.store.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
//@Entity
//@Table(name = "users")
public class User {

    @Id
    @GenericGenerator(name = "uuid-generator", strategy = "uuid2")
    @GeneratedValue(generator = "uuid-generator")
    private UUID id;

    @Column(nullable = false)
    private String login;

    @Column(nullable = false)
    private String password;

}
