package com.zhelezov.unikoom.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false, unique = true)
    private Long id;
    @NonNull
    @Column(name = "USERNAME", nullable = false, unique = true)
    private String username;
    @NonNull
    @Column(name = "FULL_NAME", nullable = false)
    private String fullName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;
    @Enumerated(EnumType.STRING)
    @Column(name = "SEX")
    private Sex sex;
    @Column(name = "PHOTO")
    private byte[] photo;
}

