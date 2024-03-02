# Promt: De acuerdo al siguiente contexto, primero leer cada uno de los puntos, finalmente luego de leer todo el contexto, realice la solicutud del ítem 4 y luego la 5

## Punto 1: Realizar inserción de n datos a la entidad `persona`

1.  Objetivo: Genere la lista de 100 personas con datos aleatorios, para registrar en la base de datos de la entidad persona en formato SQL.

2. Estructura de la entidad: 
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
    
2. Proporciono un ejemplo de como debe ir la sentencia SQL: 
    ```sql
        INSERT INTO persona(tipo_documento,numero_documento,nombre_completo, correo,telefono,direccion)VALUES
        ('CC','123456789','Juan Perez','juan1@gmail.com','1234567','Calle 123'),
        ('CC','432432','Adriana Mendez','adriana@gmail.com','234324','Calle 12');
    ```
4. Ahora construya una ciclo sql pero permita al usuario crear n cantidad de registros. 

5. Memorizar en adelante los anteriores datos del punto 3,  cómo `Entidad persona`, es decir cada vez que invoque la `Entidad persona`, pueda recodar estos datos que sean entregados.

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
3. Ahora generar los datos de esta solicitud. 

4. Memorizar en adelante los anteriores datos del punto 3, como `Entidad rol`, es decir cada vez que invoque la `Entidad rol`, pueda recodar estos datos que sean entregados.

# Punto 3: Generar un usuario a cada persona basado en la infomración `Entidad persona`, es decir, recordar la información almacenada en `Entidad persona` y generar un usuario a cada persona. 

* Para el caso del atributo `persona_id`, corresponde a la clave primaria de la `Entidad persona`. 
* Los datos almacenados en `Entidad persona`, inicia con clave primaria desde 1, 2 .... hasta la cantidad de personas almancenadas en `Entidad persona`

1. Estructura de la entidad:
    ```sql
        CREATE TABLE usuario (
            id INT AUTO_INCREMENT PRIMARY KEY,
            usuario VARCHAR(50),
            contrasenia VARCHAR(50),
            persona_id INT UNIQUE,
            FOREIGN KEY (persona_id) REFERENCES persona(id)
        );
    ```

2. Proporciono un ejemplo:
    ```sql    
        INSERT INTO usuario(usuario,contrasenia,persona_id)VALUES
            ('María732','123456789',1),
            ('Pedro123','432432',2);
    ```



