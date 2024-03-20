package com.corhuila.electivaii.Entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "corte", nullable = false)
    private Byte corte;

    @Column(name = "nota", nullable = false, precision = 10, scale = 1)
    private BigDecimal nota;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiante estudianteId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "meteria_id", nullable = false)
    private Materia materiaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getCorte() {
        return corte;
    }

    public void setCorte(Byte corte) {
        this.corte = corte;
    }

    public BigDecimal getNota() {
        return nota;
    }

    public void setNota(BigDecimal nota) {
        this.nota = nota;
    }

    public Estudiante getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(Estudiante estudianteId) {
        this.estudianteId = estudianteId;
    }

    public Materia getMateriaId() {
        return materiaId;
    }

    public void setMateriaId(Materia materiaId) {
        this.materiaId = materiaId;
    }
}