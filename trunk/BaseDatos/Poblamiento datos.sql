
INSERT INTO cargo (nombre) VALUES ('Peluquero');
INSERT INTO cargo (nombre) VALUES ('Veterinario');
INSERT INTO cargo (nombre) VALUES ('Secretaria');

INSERT INTO catpeluqueria (servicio, nombre, precio, descripcion, estado) VALUES ('Corte', 'Melena',4500,'Para raza pequeña', 0);

INSERT INTO cirugiaobj (nombre, precio, descripcion) VALUES ('Cirugia','4500', '');

INSERT INTO clientepresencial (rut, telefono, celular, nombre, apaterno, amaterno, correo, estado, domicilio, comuna, region)
VALUES ('162989243', '96496051', NULL, 'Camilo', 'Verdugo', 'Gunther', 'camilo.verdugo@gmail.com', true, '27 Sur', 'Talca', 'Del Maule');

INSERT INTO mascota (rut, nombre, fechanacimiento, claseanimal, raza, sexo, estado, imagen)
VALUES ('162989243', 'larry', '13/01/2010', 'Perro', 'Mestizo', 'Macho', true, NULL);

INSERT INTO especie (nombre) VALUES ('Ave');
INSERT INTO especie (nombre) VALUES ('Gato');
INSERT INTO especie (nombre) VALUES ('Perro');

INSERT INTO raza (nombre, especie) VALUES ('Mestizo', 'Perro');
INSERT INTO raza (nombre, especie) VALUES ('San Bernardo', 'Perro');

INSERT INTO servicio (nombre) VALUES ('Peluquería');
INSERT INTO servicio (nombre) VALUES ('Pet Shop');
INSERT INTO servicio (nombre) VALUES ('Hoteleria');
INSERT INTO servicio (nombre) VALUES ('Policlinico');
INSERT INTO servicio (nombre) VALUES ('Pabellon');

INSERT INTO serviciopeluq (nombre) VALUES ('Corte');
INSERT INTO serviciopeluq (nombre) VALUES ('Pedicura');
INSERT INTO serviciopeluq (nombre) VALUES ('Baño');

INSERT INTO usuario (nombre, apaterno, amaterno, usuario, cargo, contrasena, servicio, pregistrar, peditar, peliminar, ppurgar, estado, id)
VALUES ('nombre', 'apellido', 'apellido', 'admin', 'Veterinario', 'admin', 'Peluquería', true, true, true, true, true, 1);

INSERT INTO usuario(nombre, apaterno, amaterno, usuario, cargo, contrasena, servicio, pregistrar, peditar, peliminar, ppurgar, estado)
    VALUES ('Juanito', 'Juanito', 'Juanito', 'juan', 'Veterinario', 'juan', 'petshop','true', 'true', 'true', 'true', 'true');

INSERT INTO vacuna (nombre, precio, caducidad, descripcion) VALUES ('Octuple', 22000, 2, 'Descripcion');

