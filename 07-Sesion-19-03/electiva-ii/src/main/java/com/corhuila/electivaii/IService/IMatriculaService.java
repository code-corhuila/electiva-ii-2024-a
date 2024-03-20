package com.corhuila.electivaii.IService;

import com.corhuila.electivaii.Entity.Matricula;

import java.util.List;
import java.util.Optional;

public interface IMatriculaService {
    List<Matricula> findAll();
    Optional<Matricula> findById(Long id);
    Matricula save(Matricula estudiante);
    void update(Matricula estudiante, Long id);
    void delete(Long id);
}