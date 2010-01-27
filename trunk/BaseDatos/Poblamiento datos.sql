INSERT INTO cargo (nombre) VALUES ('Peluquero');
INSERT INTO cargo (nombre) VALUES ('Veterinario');
INSERT INTO cargo (nombre) VALUES ('Secretaria');
INSERT INTO cargo (nombre) VALUES ('Ayudante');

INSERT INTO catpeluqueria (servicio, nombre, precio, descripcion, estado) VALUES ('Corte', 'Melena',4500,'Para raza pequeña', 0);

INSERT INTO cirugiaobj (nombre, precio, descripcion) VALUES ('Cirugia','4500', '');

INSERT INTO clientepresencial (rut, telefono, celular, nombre, apaterno, amaterno, correo, estado, domicilio, comuna, region)
VALUES ('162989243', '96496051', NULL, 'Camilo', 'Verdugo', 'Gunther', 'camilo.verdugo@gmail.com', true, '27 Sur', 'Talca', 'Del Maule');


			
INSERT INTO mascota (rut, nombre, fechanacimiento, claseanimal, raza, sexo, estado, imagen)
VALUES ('162989243', 'larry', '13/01/2010', 'Perro', 'Mestizo', 'Macho', true, NULL);

INSERT INTO especie (nombre) VALUES ('Gato');
INSERT INTO especie (nombre) VALUES ('Perro');


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

INSERT INTO producto(
            nombre, precio, categoria, codigo, descripcion, estado, stock)
    VALUES ('PEDIGRI', '4500', '', '00000003332', '', '0', '3');

INSERT INTO usuario(
            nombre, apaterno, amaterno, usuario, cargo, contrasena, servicio, 
            pregistrar, peditar, peliminar, ppurgar, estado, id)
    VALUES ('Sandra', 'Russell', '', 'sandra', 'Ayudante', 'sandra', 'Pet Shop', 
            'true', 'true', 'true','true', 'true', '01');

INSERT INTO usuario(
            nombre, apaterno, amaterno, usuario, cargo, contrasena, servicio, 
            pregistrar, peditar, peliminar, ppurgar, estado, id)
    VALUES ('Claudio Antonio', 'Bonati', 'Bascuñán', 'Claudio', 'Veterinario', 'Claudio', 'Policlinico', 
            'true', 'true', 'true','true', 'true', '03');
   

			
INSERT INTO usuario(
            nombre, apaterno, amaterno, usuario, cargo, contrasena, servicio, 
            pregistrar, peditar, peliminar, ppurgar, estado, id)
    VALUES ('María Cristina', 'Richardson', 'Cruz', 'Cristy', 'Peluquera', 'Cristy', 'Peluquería', 
            'true', 'true', 'true','true', 'true', '02');

INSERT INTO vacuna(
            nombre, precio, caducidad, descripcion)
    VALUES ('Óctuple', '3000', '6', '');
	
INSERT INTO vacuna(
            nombre, precio, caducidad, descripcion)
    VALUES ('Antirrabica', '5000', '6', '');

INSERT INTO raza(
            nombre, especie)
    VALUES ('Mestizo', 'Gato');  

			
			
INSERT INTO raza(
            nombre, especie)
    VALUES ('Mestizo', 'Perro');  

INSERT INTO raza(
            nombre, especie)
    VALUES ('Pastor Alemán', 'Perro');

INSERT INTO raza(
            nombre, especie)
    VALUES ('Pastor de Brie', 'Perro');

INSERT INTO raza (nombre, especie) VALUES ('San Bernardo', 'Perro');

INSERT INTO avisoweb(nombre, apaterno, telefono0, telefono, celular0,
celular, asunto, descripcion, estado)
VALUES ('Gonzalo','Cáceres','72','342123','0','85562311','Vendo Cachorros','Vendo lindos cachorros pastor alemán','0');

INSERT INTO avisoweb(nombre, apaterno, telefono0, telefono, celular0,
celular, asunto, descripcion, estado)
VALUES ('Javier','Sarabia','75','234432','0','94436576','Compro cachorros poodle','Si alguien tiene cachorros poodle para la venta','0');

INSERT INTO avisoweb(nombre, apaterno, telefono0, telefono, celular0,
celular, asunto, descripcion, estado)
VALUES ('Constanza','Maldonado','75','443212','0','83324321','Regalo cachorros','Tiene tres meses de edad, cocker','0');
