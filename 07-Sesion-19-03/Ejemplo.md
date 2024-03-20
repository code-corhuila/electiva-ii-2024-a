# Paquetes del backend

* package Entity
* package IRepository
* package IServicice
* package Service
* package Controller

**Tener en cuenta**
* IClass => Corresponde a Interfaces
* AClass => Corresponde a Clases Abstractas
* Class => Corresponde a Clases Nomales


# Normal

**Existen atributos que se repiten y estos son succetibles de mapearsen de manera globlar, ejemplo, a continuación el atributo estado**


# Crear base de datos

```sql
    DROP DATABASE IF EXISTS electiva_ii ; 
    CREATE DATABASE electiva_ii;
```

# Creación del proyecto

Motor base de datos MYSQL
-----------------
https://start.spring.io/#!type=maven-project&language=java&platformVersion=3.2.3&packaging=jar&jvmVersion=17&groupId=com.corhuila&artifactId=electiva-ii&name=electiva-ii&description=Electiva%20II&packageName=com.corhuila.electiva-ii&dependencies=web,data-jpa,devtools,mysql

# Conexión - application properties
```java
    spring.application.name=electiva-ii
    server.port= 9000
    spring.jpa.hibernate.ddl-auto = update
    spring.datasource.url = jdbc:mysql://localhost:3306/electiva_ii
    spring.datasource.username = root
    spring.datasource.password = abcd
```


## Entity

Estudiante
---------
```java
@Entity
@Table(name = "estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "documento", length = 20, nullable = false, unique = true)
    private String documento;

    @Column(name = "estado")
    private Boolean estado;

    //Encapsulamiento
}
```

Materia
---------
```java
@Entity
@Table(name = "materia")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "codigo", nullable = false)
    private String codigo;

    @Column(name = "nombre", length = 20, nullable = false, unique = true)
    private String nombre;

    @Column(name = "estado")
    private Boolean estado;

    //Encapsulamiento
}
```

Matricula
---------
```java
@Entity
@Table(name = "matricula")
public class Matricula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "corte", nullable = false)
    @NotNull
    @Min(1) 
    @Max(3) 
    private Byte corte;

    @Column(name = "nota", nullable = false, precision = 10, scale = 1)
    @DecimalMin(value = "0.0", inclusive = true)
    @DecimalMax(value = "5.0", inclusive = true)
    private BigDecimal nota;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "estudiante_id", nullable = false)
    private Estudiante estudianteId;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "meteria_id", nullable = false)
    private Materia materiaId;

    //Encapsulamiento
}
```

## Repository

IEstudianteRepository
---------
```java
@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante, Long> {

}
```

IMateriaRepository
---------
```java
@Repository
public interface IMateriaRepository extends JpaRepository<Materia, Long> {

}
```

IMatriculaRepository
---------
```java
@Repository
public interface IMatriculaRepository extends JpaRepository<Matricula, Long> {

}
```

## IService

IEstudianteService
---------
```java
public interface IEstudianteService {
    List<Estudiante> findAll();
    Optional<Estudiante> findById(Long id);
    Estudiante save(Estudiante estudiante);
    void update(Estudiante estudiante, Long id);
    void delete(Long id);
}
```

IMateriaService
---------
```java
public interface IMateriaService {
    List<Materia> findAll();
    Optional<Materia> findById(Long id);
    Materia save(Materia estudiante);
    void update(Materia estudiante, Long id);
    void delete(Long id);
}
```

IMatriculaService
---------
```java
public interface IMatriculaService {
    List<Matricula> findAll();
    Optional<Matricula> findById(Long id);
    Matricula save(Matricula estudiante);
    void update(Matricula estudiante, Long id);
    void delete(Long id);
}
```

## Service

EstudianteService
---------
```java
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
```

MateriaService
---------
```java
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
```

MatriculaService
---------
```java
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
```

## Controller


EstudianteController
---------
```java
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
```

MateriaController
---------
```java
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/materia")
public class MateriaController {
    @Autowired
    private IMateriaService service;

    @GetMapping()
    public List<Materia> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Materia> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping()
    public Materia save(@RequestBody Materia materia) {
        return service.save(materia);
    }


    @PutMapping("/{id}")
    public void update(@RequestBody Materia materia, @PathVariable Long id) {
        service.update(materia, id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
```

MatriculaController
---------
```java
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/matricula")
public class MatriculaController {
    @Autowired
    private IMatriculaService service;

    @GetMapping()
    public List<Matricula> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Matricula> findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping()
    public Matricula save(@RequestBody Matricula matricula) {
        return service.save(matricula);
    }


    @PutMapping("/{id}")
    public void update(@RequestBody Matricula matricula, @PathVariable Long id) {
        service.update(materia, id);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
```

# Aplicar patrón

## Entity

ABaseEntity
---------
```java
@Suppermapped
public abstract class ABaseEntity {
    //Atributos Genéricos
}
```

Estudiante
---------
```java
@Entity
@Table(name = "estudiante")
public class Estudiante extends ABaseEntity {
   //Agregar atributos propios de la clase
}
```

## IRepository

IBaseRepository
---------
```java
@Repository
public interface IBaseRepository <T extends ABaseEntity, ID> extends JpaRepository<T, ID> {
  
}
```

IEstudianteRepository
---------
```java
@Repository
public interface IEstudianteRepository extends ABaseEntity<Estudiante, Long>{

}
```

## IService

IBaseService
---------
```java
public interface IBaseService <T extends ABaseEntity> {
	List<T> all();
    List<T> findByStateTrue();
    T findById(Long id) throws Exception;
    T save(T entity) throws Exception;
    void update(Long id, T entity) throws Exception;
    void delete(Long id) throws Exception;
}
```

IEstudianteService
---------
```java
public interface IEstudianteService extends IBaseService<Estudiante> {

}
```

## Service

ABaseService
---------
**Explore la creación del archivo BaseService, para ello aplique el concepto visto. Recomendación usar objeto T, D y S**

EstudianteService
---------
**Use el servicio abstracto**

## Controller

ABaseController
---------
**Explore la creación del archivo BaseController, para ello aplique el concepto visto. Recomendación usar objeto T, D y S**

EstudianteController
---------
**Use el controller abstracto**


