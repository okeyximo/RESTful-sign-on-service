package com.example.systemspecstask.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "merchant")
public class User extends AbstractEntity{

    @Column(nullable = false,columnDefinition = "VARCHAR(100)")
    private String companyName;

    @Column(unique = true,columnDefinition = "VARCHAR(100)")
    private String phoneNumber;

    @Column(columnDefinition = "VARCHAR(100)")
    private String address;

    @Column(columnDefinition = "VARCHAR(100)")
    private String businessType;

    @Column(unique = true,nullable = false,columnDefinition = "VARCHAR(100)")
    private String email;

    @Column(columnDefinition = "VARCHAR(250)")
    private String accountNumber;

    @Column(name = "password",nullable = false)
    private String password;
}
