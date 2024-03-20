package com.corhuila.electivaii.Service;

import com.corhuila.electivaii.Entity.Matricula;
import com.corhuila.electivaii.IRepository.IMatriculaRepository;
import com.corhuila.electivaii.IService.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService implements IMatriculaService {

    @Autowired
    private IMatriculaRepository repository;


    @Override
    public List<Matricula> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Matricula> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Matricula save(Matricula matricula) {
        return repository.save(matricula);
    }

    @Override
    public void update(Matricula matricula, Long id) {
        Optional<Matricula> ps = repository.findById(id);

        if (!ps.isEmpty()){
            Matricula matriculaUpdate = ps.get();
            matriculaUpdate.setCorte(matricula.getCorte());
            matriculaUpdate.setNota(matricula.getNota());
            matriculaUpdate.setEstudianteId(matricula.getEstudianteId());
            matriculaUpdate.setMateriaId(matricula.getMateriaId());
            repository.save(matriculaUpdate);
        }else{
            System.out.println("No existe el estudiante");
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}