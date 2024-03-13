package com.corhuila.electivaii.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "tipo_documento", length = 50, nullable = false)
    private String tipoDocumento;
}
