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
    direccion VARCHAR(255),
    state bit not null default 1,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP,
    user_by INT,
    user_update INT,
    user_delete INT 
);

CREATE TABLE usuario (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario VARCHAR(50),
    contrasenia VARCHAR(50),
    persona_id INT UNIQUE,
    FOREIGN KEY (persona_id) REFERENCES persona(id),
    state bit not null default 1,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP,
    user_by INT,
    user_update INT,
    user_delete INT 
);

CREATE TABLE rol (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    state bit not null default 1,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP,
    deleted_at TIMESTAMP,
    user_by INT,
    user_update INT,
    user_delete INT 
);

CREATE TABLE usuario_rol (
    id INT AUTO_INCREMENT PRIMARY KEY,
    usuario_id INT,
    rol_id INT,
    FOREIGN KEY (usuario_id) REFERENCES usuario(id),
    FOREIGN KEY (rol_id) REFERENCES rol(id)
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
    modulo_id INT,
    FOREIGN KEY (rol_id) REFERENCES rol(id),
    FOREIGN KEY (modulo_id) REFERENCES modulo(id)
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
    vista_id INT,
    FOREIGN KEY (modulo_id) REFERENCES modulo(id),
    FOREIGN KEY (vista_id) REFERENCES vista(id)
);



