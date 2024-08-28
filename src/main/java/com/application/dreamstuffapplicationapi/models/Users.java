package com.application.dreamstuffapplicationapi.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.transaction.Transactional;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Transactional
@Schema(description = "Users entity")
@Table(name= "users")
public class Users {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    private String first_name;

    private String last_name;

    private String email;

    private String password;


    public Users(Long user_id, String first_name, String last_name, String email, String password) {

        this.user_id = user_id;

        this.first_name = first_name;

        this.last_name = last_name;

        this.email = email;

        this.password = password;
    }
}
