package com.corhuila.electivaii.IRepository;

import com.corhuila.electivaii.Entity.Materia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMateriaRepository extends JpaRepository<Materia, Long> {

}