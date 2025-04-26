CREATE DATABASE BisonGYM;
USE BisonGYM;

-- Tabla de tipos de usuario
CREATE TABLE tipo_usuarios (
    id_t_usuario INT AUTO_INCREMENT PRIMARY KEY,
    n_usuario VARCHAR(20) NOT NULL
);

-- Tabla de sexo
CREATE TABLE sexo (
    id_sexo INT AUTO_INCREMENT PRIMARY KEY,
    descripcion VARCHAR(20) NOT NULL
);

-- Tabla de usuarios
CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    apellido VARCHAR(100) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    username VARCHAR(50) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    fecha_nacimiento DATE,
    id_sexo INT,
    id_rol INT DEFAULT 1,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    activo BOOL,
    FOREIGN KEY (id_sexo) REFERENCES sexo(id_sexo) ON DELETE SET NULL,
    FOREIGN KEY (id_rol) REFERENCES tipo_usuarios(id_t_usuario)
);

-- Tabla de medidas
CREATE TABLE medidas (
    id_medida INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    fecha DATE NOT NULL,
    peso DECIMAL(5,2),
    altura DECIMAL(4,2),
    porcentaje_grasa DECIMAL(5,2),
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario) ON DELETE CASCADE
);

CREATE INDEX idx_usuario_fecha ON medidas(id_usuario, fecha);

-- Tabla de zonas anatómicas
CREATE TABLE zonas_anatomicas (
    id_zona INT AUTO_INCREMENT PRIMARY KEY,
    nombre_zona VARCHAR(100) NOT NULL
);

-- Tabla de músculos
CREATE TABLE musculos (
    id_musculo INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    id_zona INT NOT NULL,
    funcion TEXT,
    FOREIGN KEY (id_zona) REFERENCES zonas_anatomicas(id_zona) ON DELETE CASCADE
);

-- Tabla de dificultades
CREATE TABLE dificultades (
    id_dificultad INT AUTO_INCREMENT PRIMARY KEY,
    nivel ENUM('Principiante', 'Intermedio', 'Avanzado') NOT NULL
);

-- Tabla de ejercicios
CREATE TABLE ejercicios (
    id_ejercicio INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    id_musculo_principal INT NOT NULL,
    id_musculo_secundario INT,
    id_dificultad INT NOT NULL,
    FOREIGN KEY (id_musculo_principal) REFERENCES musculos(id_musculo),
    FOREIGN KEY (id_musculo_secundario) REFERENCES musculos(id_musculo),
    FOREIGN KEY (id_dificultad) REFERENCES dificultades(id_dificultad)
);

-- Tabla de entrenamientos
CREATE TABLE entrenamientos (
    id_entrenamiento INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    nombre VARCHAR(100),
    descripcion TEXT,
    duracion_minutos INT,
    observaciones TEXT,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id_usuario)
);

CREATE INDEX idx_entrenamiento_fecha ON entrenamientos(id_usuario, fecha);

-- Tabla de detalles de entrenamiento
CREATE TABLE detalles_entrenamiento (
    id_detalle INT AUTO_INCREMENT PRIMARY KEY,
    id_entrenamiento INT NOT NULL,
    id_ejercicio INT NOT NULL,
    orden_ejercicio INT,
    notas TEXT,
    FOREIGN KEY (id_entrenamiento) REFERENCES entrenamientos(id_entrenamiento) ON DELETE CASCADE,
    FOREIGN KEY (id_ejercicio) REFERENCES ejercicios(id_ejercicio)
);

CREATE TABLE series_entrenamiento (
    id_serie INT AUTO_INCREMENT PRIMARY KEY,
    id_detalle_entrenamiento INT NOT NULL,
    numero_serie INT NOT NULL,
    repeticiones INT NOT NULL,
    peso_usado DECIMAL(10, 2) NOT NULL,
    notas VARCHAR(255),
    FOREIGN KEY (id_detalle_entrenamiento) REFERENCES detalles_entrenamiento(id_detalle) ON DELETE CASCADE
);




