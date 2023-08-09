CREATE DATABASE agenda;
USE agenda;

CREATE TABLE contactos (
	id INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(45),
    apellido VARCHAR(45),
    correo VARCHAR(45) UNIQUE NOT NULL
);

INSERT INTO contactos VALUES (0, 'marco', 'muralles', 'vini.muralles@gmail.com');
INSERT INTO contactos VALUES (0, 'juan', 'ortiz', 'juan.ortiz@gmial.com');
INSERT INTO contactos VALUES (0, 'María', 'García', 'maria.garcia@gmial.com');

SELECT * FROM contactos;

SELECT * FROM contactos WHERE nombre = 'juan';

UPDATE contactos SET correo = 'maria.nuevo@example.com' WHERE id = '3';

SELECT * FROM contactos;

-- FASE 2

CREATE TABLE categorias (
	id_categoria INT PRIMARY KEY AUTO_INCREMENT,
    nombre_categoria VARCHAR(45)
);

INSERT INTO categorias VALUES ('0', 'Administrador'), ('0', 'Informatica'), ('0', 'Ventas'), ('0', 'Contabilidad');

ALTER TABLE contactos ADD categoria INT;

ALTER TABLE contactos ADD CONSTRAINT fk_contactos_categorias FOREIGN KEY (categoria) REFERENCES categorias(id_categoria);

UPDATE contactos SET categoria = '1' WHERE id = '1';
UPDATE contactos SET categoria = '2' WHERE id = '2';
UPDATE contactos SET categoria = '3' WHERE id = '3';   
    
CREATE VIEW vista_principal AS 
SELECT co.id, co.nombre, co.apellido, co.correo, ca.nombre_categoria
	FROM contactos co
    INNER JOIN categorias ca ON co.categoria = ca.id_categoria
    ORDER BY co.id ASC;
    
SELECT * FROM vista_principal;

DROP VIEW vista_principal;

SELECT * FROM contactos WHERE correo = 'vini.muralles@gmail.com';


