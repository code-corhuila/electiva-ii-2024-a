package com.corhuila.electivaii.IService;

import com.corhuila.electivaii.Entity.Materia;

import java.util.List;
import java.util.Optional;

public interface IMateriaService {
    List<Materia> findAll();
    Optional<Materia> findById(Long id);
    Materia save(Materia estudiante);
    void update(Materia estudiante, Long id);
    void delete(Long id);
}