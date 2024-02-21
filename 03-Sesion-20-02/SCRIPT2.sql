DROP DATABASE IF EXISTS electiva_ii; 
CREATE DATABASE electiva_ii;
USE electiva_ii;
-- Creación de las tablas para las entidades

CREATE TABLE persona (
    id INT AUTO_INCREMENT PRIMARY KEY,
    tipo_documento VARCHAR(50) NOT NULL,
    numero_documento VARCHAR(50) UNIQUE NOT NULL,
    nombre_completo VARCHAR(255) NOT NULL,
    correo VARCHAR(255) UNIQUE NOT NULL,
    telefono VARCHAR(20),
    direccion VARCHAR(255)
);

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50),
    contrasenia VARCHAR(50),
    persona_id INT UNIQUE
);

CREATE TABLE usuario_rol (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    rol_id INT
);

CREATE TABLE rol (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT
);


CREATE TABLE modulo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    ruta VARCHAR(255)
);

CREATE TABLE rol_modulo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    rol_id INT,
    modulo_id INT
);

CREATE TABLE vista (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    ruta VARCHAR(255)
);

CREATE TABLE modulo_vista (
    id INT AUTO_INCREMENT PRIMARY KEY,
    modulo_id INT,
    vista_id INT
);

-- Añadir las claves foráneas

ALTER TABLE usuario ADD CONSTRAINT fk_usuario_persona FOREIGN KEY (persona_id) REFERENCES persona(id);
ALTER TABLE usuario_rol ADD CONSTRAINT fk_usuario_rol_usuario FOREIGN KEY (usuario_id) REFERENCES usuario(id);
ALTER TABLE usuario_rol ADD CONSTRAINT fk_usuario_rol_rol FOREIGN KEY (rol_id) REFERENCES rol(id);
ALTER TABLE rol_modulo ADD CONSTRAINT fk_rol_modulo_rol FOREIGN KEY (rol_id) REFERENCES rol(id);
ALTER TABLE rol_modulo ADD CONSTRAINT fk_rol_modulo_modulo FOREIGN KEY (modulo_id) REFERENCES modulo(id);
ALTER TABLE modulo_vista ADD CONSTRAINT fk_modulo_vista_modulo FOREIGN KEY (modulo_id) REFERENCES modulo(id);
ALTER TABLE modulo_vista ADD CONSTRAINT fk_modulo_vista_vista FOREIGN KEY (vista_id) REFERENCES vista(id);
