package com.corhuila.electivaii.Service;

import com.corhuila.electivaii.Entity.Estudiante;
import com.corhuila.electivaii.IRepository.IEstudianteRepository;
import com.corhuila.electivaii.IService.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService implements IEstudianteService {

    @Autowired
    private IEstudianteRepository repository;


    @Override
    public List<Estudiante> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Estudiante> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Estudiante save(Estudiante estudiante) {
        return repository.save(estudiante);
    }

    @Override
    public void update(Estudiante estudiante, Long id) {
        Optional<Estudiante> ps = repository.findById(id);

        if (!ps.isEmpty()){
            Estudiante estudianteUpdate = ps.get();
            estudianteUpdate.setNombre(estudiante.getNombre());
            estudianteUpdate.setDocumento(estudiante.getDocumento());
            estudianteUpdate.setEstado(estudiante.getEstado());
            repository.save(estudianteUpdate);
        }else{
            System.out.println("No existe el estudiante");
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}