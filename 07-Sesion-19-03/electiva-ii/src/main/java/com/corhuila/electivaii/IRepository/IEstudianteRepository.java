package com.corhuila.electivaii.IRepository;

import com.corhuila.electivaii.Entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante, Long> {

}