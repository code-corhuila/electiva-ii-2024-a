package com.corhuila.electivaii.Service;

import com.corhuila.electivaii.Entity.Materia;
import com.corhuila.electivaii.IRepository.IMateriaRepository;
import com.corhuila.electivaii.IService.IMateriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MateriaService implements IMateriaService {

    @Autowired
    private IMateriaRepository repository;


    @Override
    public List<Materia> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Materia> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Materia save(Materia materia) {
        return repository.save(materia);
    }

    @Override
    public void update(Materia materia, Long id) {
        Optional<Materia> ps = repository.findById(id);

        if (!ps.isEmpty()){
            Materia materiaUpdate = ps.get();
            materiaUpdate.setCodigo(materia.getCodigo());
            materiaUpdate.setNombre(materia.getNombre());
            materiaUpdate.setEstado(materia.getEstado());
            repository.save(materiaUpdate);
        }else{
            System.out.println("No existe el estudiante");
        }
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}