package com.corhuila.electivaii.Controller;

import com.corhuila.electivaii.Entity.Estudiante;
import com.corhuila.electivaii.IService.IEstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/estudiante")
public class EstudianteController {
    @Autowired
    private IEstudianteService service;

    @GetMapping()
    public List<Estudiante> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Estudiante> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping()
    public Estudiante save(@RequestBody Estudiante estudiante) {
        return service.save(estudiante);
    }


    @PutMapping("/{id}")
    public void update(@RequestBody Estudiante estudiante, @PathVariable Long id) {
        service.update(estudiante, id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}