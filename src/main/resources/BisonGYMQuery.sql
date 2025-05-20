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
    id_t_usuario INT DEFAULT 1,
    fecha_creacion DATETIME DEFAULT CURRENT_TIMESTAMP,
    activo BOOL,
    FOREIGN KEY (id_sexo) REFERENCES sexo(id_sexo) ON DELETE SET NULL,
    FOREIGN KEY (id_t_usuario) REFERENCES tipo_usuarios(id_t_usuario)
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
    FOREIGN KEY (id_entrenamiento) REFERENCES entrenamientos(id_entrenamiento) ON DELETE CASCADE,
    FOREIGN KEY (id_ejercicio) REFERENCES ejercicios(id_ejercicio)
);

CREATE TABLE series_entrenamiento (
    id_serie INT AUTO_INCREMENT PRIMARY KEY,
    id_detalle_entrenamiento INT NOT NULL,
    numero_serie INT NOT NULL,
    repeticiones INT NOT NULL,
    peso_usado DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_detalle_entrenamiento) REFERENCES detalles_entrenamiento(id_detalle) ON DELETE CASCADE
);


CREATE VIEW  vw_inicioSesion AS
SELECT id_usuario,username, password_hash,id_t_usuario
FROM usuarios;


-- Entrenamientos en cierto rango de Fechas
DELIMITER //
CREATE PROCEDURE sp_EntrenamientosFechas(IN p_id_usuario LONG, IN p_fecha_inicio DATE, IN p_fecha_fin DATE	)
BEGIN
	SELECT DATE_FORMAT(fecha, '%Y-%m') AS mes, COUNT(*) AS total
	FROM entrenamientos
	WHERE id_usuario = p_id_usuario
	AND fecha BETWEEN p_fecha_inicio AND p_fecha_fin
	GROUP BY mes
	ORDER BY mes;
END //
DELIMITER ;


-- Evolucion de peso usado
DELIMITER //
CREATE PROCEDURE sp_evolucion_peso_cargado(IN p_id_usuario LONG,IN p_id_ejercicio INT,IN p_fecha_inicio DATE,IN p_fecha_fin DATE)
BEGIN
	SELECT e.fecha, se.peso_usado
	FROM series_entrenamiento se
	JOIN detalles_entrenamiento de ON se.id_detalle_entrenamiento = de.id_detalle
	JOIN entrenamientos e ON de.id_entrenamiento = e.id_entrenamiento
	WHERE e.id_usuario = p_id_usuario
	AND de.id_ejercicio = p_id_ejercicio
	AND e.fecha BETWEEN p_fecha_inicio AND p_fecha_fin
	ORDER BY e.fecha;
END //
DELIMITER ;


 
 
 -- Peso y grasa entre ciertas fechas
 DELIMITER //

CREATE PROCEDURE sp_evolucion_peso(IN p_id_usuario LONG,IN p_fecha_inicio DATE,IN p_fecha_fin DATE)
BEGIN
    SELECT fecha, peso
    FROM medidas
    WHERE id_usuario = p_id_usuario
      AND fecha BETWEEN p_fecha_inicio AND p_fecha_fin
    ORDER BY fecha;
END //
DELIMITER ;

DELIMITER //
CREATE PROCEDURE sp_evolucion_grasa(IN p_id_usuario LONG,IN p_fecha_inicio DATE,IN p_fecha_fin DATE)
BEGIN
    SELECT fecha, porcentaje_grasa
    FROM medidas
    WHERE id_usuario = p_id_usuario
      AND fecha BETWEEN p_fecha_inicio AND p_fecha_fin
    ORDER BY fecha;
END //
DELIMITER ;
 
 -- Dificultades de ejecicios
DELIMITER //
CREATE PROCEDURE sp_dificultad_por_usuario(IN p_id_usuario LONG,IN p_fecha_inicio DATE,IN p_fecha_fin DATE)
BEGIN
    SELECT d.nivel, COUNT(*) AS total
    FROM entrenamientos e
    JOIN detalles_entrenamiento de ON e.id_entrenamiento = de.id_entrenamiento
    JOIN ejercicios ej ON de.id_ejercicio = ej.id_ejercicio
    JOIN dificultades d ON ej.id_dificultad = d.id_dificultad
    WHERE e.id_usuario = p_id_usuario
      AND DATE(e.fecha) BETWEEN p_fecha_inicio AND p_fecha_fin
    GROUP BY d.nivel;
END //
DELIMITER ;

-- Zonas Entrenadas por usuarios 
DELIMITER //
CREATE PROCEDURE sp_zonas_entrenadas_usuario(IN p_id_usuario LONG,IN p_fecha_inicio DATE,IN p_fecha_fin DATE)
BEGIN
    SELECT za.nombre_zona, COUNT(*) AS frecuencia
    FROM entrenamientos e
    JOIN detalles_entrenamiento de ON e.id_entrenamiento = de.id_entrenamiento
    JOIN ejercicios ej ON de.id_ejercicio = ej.id_ejercicio
    JOIN musculos m ON ej.id_musculo_principal = m.id_musculo
    JOIN zonas_anatomicas za ON m.id_zona = za.id_zona
    WHERE e.id_usuario = p_id_usuario
      AND DATE(e.fecha) BETWEEN p_fecha_inicio AND p_fecha_fin
    GROUP BY za.nombre_zona
    ORDER BY frecuencia DESC;
END //
DELIMITER ;

-- Entrenamientos del usuario
DELIMITER //
CREATE PROCEDURE sp_entrenamientos_usuario(IN p_id_usuario LONG)
BEGIN
    SELECT 
        e.id_entrenamiento,
        e.fecha,
        e.nombre AS nombre_entrenamiento,
        e.descripcion,
        e.duracion_minutos,
        e.observaciones
    FROM entrenamientos e
    WHERE e.id_usuario = p_id_usuario
    ORDER BY e.fecha DESC;
END //
DELIMITER ;

-- Detalle de cada entrenamiento
DELIMITER //
CREATE PROCEDURE sp_detalles_entrenamiento(IN p_id_entrenamiento LONG)
BEGIN
    SELECT 
        de.id_detalle,
        de.id_ejercicio
    FROM detalles_entrenamiento de
    WHERE de.id_entrenamiento = p_id_entrenamiento
    ORDER BY de.id_detalle;
END //
DELIMITER ;
-- Informacion del detalle
DELIMITER //
CREATE PROCEDURE sp_series_detalle(IN p_id_detalle LONG)
BEGIN
    SELECT 
        s.id_serie,
        s.numero_serie,
        s.repeticiones,
        s.peso_usado
    FROM series_entrenamiento s
    WHERE s.id_detalle_entrenamiento = p_id_detalle
    ORDER BY s.numero_serie;
END //
DELIMITER ;


