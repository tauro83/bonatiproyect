CREATE TABLE cliente
(
  nombre CHAR(12),
  apellido CHAR(12),
  apellido2 CHAR(12),
  rut CHAR(8) NOT NULL,
  rut2 CHAR(1) NOT NULL,
  telefono CHAR(3),
  telefono2 CHAR(10),
  celular CHAR(2),
  celular2 CHAR(10),
  direccion CHAR(20),
  region CHAR(20),
  comuna CHAR(20),
  email CHAR(20),
  email2 CHAR(20),
  estado BOOLEAN DEFAULT true,
  CONSTRAINT rut PRIMARY KEY (rut, rut2)
); 
