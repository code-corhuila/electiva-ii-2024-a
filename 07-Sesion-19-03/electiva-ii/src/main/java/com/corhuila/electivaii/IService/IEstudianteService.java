package com.corhuila.electivaii.IService;

import com.corhuila.electivaii.Entity.Estudiante;

import java.util.List;
import java.util.Optional;

public interface IEstudianteService {
    List<Estudiante> findAll();
    Optional<Estudiante> findById(Long id);
    Estudiante save(Estudiante estudiante);
    void update(Estudiante estudiante, Long id);
    void delete(Long id);
}