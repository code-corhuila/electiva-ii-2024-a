# Promt: De acuerdo al siguiente contexto, primero leer todo y luego realizar

## Punto 1: Genere la lista de 100 personas con datos aleatorios, para registrar en la base de datos de la entidad persona.


1. Estructura de la entidad: 
    ```sql
        CREATE TABLE persona (
        id INT AUTO_INCREMENT PRIMARY KEY,
        tipo_documento VARCHAR(50) NOT NULL,
        numero_documento VARCHAR(50) UNIQUE NOT NULL,
        nombre_completo VARCHAR(255) NOT NULL,
        correo VARCHAR(255) UNIQUE NOT NULL,
        telefono VARCHAR(20),
        direccion VARCHAR(255));
    ```
    
2. Proporciono un ejemplo: 
    ```sql
        INSERT INTO persona(tipo_documento,numero_documento,nombre_completo, correo,telefono,direccion)VALUES
        ('CC','123456789','Juan Perez','juan1@gmail.com','1234567','Calle 123'),
        ('CC','432432','Adriana Mendez','adriana@gmail.com','234324','Calle 12');
    ```

## Punto 2: Genere la lista de 10 roles con datos aleatorios, para registrar en la base de datos de la entidad rol.


1. Estructura de la entidad: 
    ```sql
        CREATE TABLE rol (
            id INT AUTO_INCREMENT PRIMARY KEY,
            nombre VARCHAR(100) NOT NULL,
            descripcion TEXT
        );
    ```
    
2. Proporciono un ejemplo: 
    ```sql
        INSERT INTO rol(nombre, descripcion)VALUES
        ('Administrador','Gestor de la app'),
        ('Vendedor','Encargador de las ventas');        
    ```



