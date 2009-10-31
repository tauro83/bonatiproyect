INSERT INTO Usuario (nombre,aPaterno,aMaterno,usuario,cargo,contrasena,servicio,pRegistrar,pEditar,pEliminar,pPurgar)
VALUES 		('Claudio', 'Bonati','Perez','cbonati','Veterinario','cbonati','Policlinico I','true','true','true','true');
INSERT INTO Usuario (nombre,aPaterno,aMaterno,usuario,cargo,contrasena,servicio,pRegistrar,pEditar,pEliminar,pPurgar)
VALUES 		('Cristina', 'Cruz','Perez','ccruz','Peluquero','ccruz','Peluqueria','true','true','true','false');
INSERT INTO Usuario (nombre,aPaterno,aMaterno,usuario,cargo,contrasena,servicio,pRegistrar,pEditar,pEliminar,pPurgar)
VALUES		('Felipe', 'Sazo','Saez','fsazo','Ayudante','fsazo','Hoteleria','false','false','false','false');
INSERT INTO Usuario (nombre,aPaterno,aMaterno,usuario,cargo,contrasena,servicio,pRegistrar,pEditar,pEliminar,pPurgar)
VALUES 		('Mauricio', 'Tapia','Ortiz','mtapia','Otro','mtapia','PetShop','true','false','false','false');
INSERT INTO Usuario (nombre,aPaterno,aMaterno,usuario,cargo,contrasena,servicio,pRegistrar,pEditar,pEliminar,pPurgar)
VALUES 		('Alejandra', 'Maraboli','Perez','amaraboli','Secretaria','cbonati','Policlinico I','true','true','false','false');

INSERT INTO cliente(nombre,apellido,apellido2,rut, telefono,telefono2,celular,celular2,direccion, region, comuna, email,  estado)
VALUES 	('Nicolas','Delgado','Nose','16167986','75','987654','09','87654345','alameda 550','Septima', 'Talca', 'nico2@mail.com', 'TRUE');
INSERT INTO cliente(nombre,apellido,apellido2,rut, telefono,telefono2,celular,celular2,direccion, region, comuna, email, estado)
VALUES 	('Sebastian','Arancibia','Olguin','16358963','75','908098','09','76578921','Los niches Clolihuache 15','Septima', 'Curico', 'seba2@mail.com', 'TRUE');
INSERT INTO cliente(nombre,apellido,apellido2,rut, telefono,telefono2,celular,celular2,direccion, region, comuna, email, estado)
VALUES 	('Cristian','Bravo','Rojas','163000001','75','9998098','09','765212321','Unimarc','Septima', 'Curico', 'Cristian2@mail.com', 'TRUE');
INSERT INTO cliente(nombre,apellido,apellido2,rut, telefono,telefono2,celular,celular2,direccion, region, comuna, email, estado)
VALUES 	('Camilo','Verdugo','guanthsr','163009991','75','9809876','09','765212321','calle 1','Septima', 'Talca', 'camilo2@mail.com', 'TRUE');
INSERT INTO cliente(nombre,apellido,apellido2,rut, telefono,telefono2,celular,celular2,direccion, region, comuna, email, estado)
VALUES 	('Raul','Lopez','raulrich','51669871','75','9805556','09','76554543','calle 2','Septima', 'Curico','raul2@mail.com', 'TRUE');


INSERT INTO ClientePresencial(rut,telefono1,telefono2,nombre,correo,estado,domicilioNumero,domicilioComuna,domicilioCalle)
VALUES 	('16298921', '324324','324234','Claudia','claudia@gmail.com','false','234','Talca','Los niches #231');
INSERT INTO ClientePresencial(rut,telefono1,telefono2,nombre,correo,estado,domicilioNumero,domicilioComuna,domicilioCalle)
VALUES 	('16298923', '223324','324234','Sofia','','false','624','Talca','Carrera #11');
INSERT INTO ClientePresencial(rut,telefono1,telefono2,nombre,correo,estado,domicilioNumero,domicilioComuna,domicilioCalle)
VALUES 	('16298925', '244324','32','Alejandro','avergara@hotmail.com','false','134','Talca','Los niches #231');
INSERT INTO ClientePresencial(rut,telefono1,telefono2,nombre,correo,estado,domicilioNumero,domicilioComuna,domicilioCalle)
VALUES 	('16298926', '213278','12','Andrade','claudia@gmail.com','false','234','Curico','Lircay #231');
INSERT INTO ClientePresencial(rut,telefono1,telefono2,nombre,correo,estado,domicilioNumero,domicilioComuna,domicilioCalle)
VALUES 	('16298927', '234354','2','Claudia','claudia@gmail.com','false','234','Talca','Los niches #231');


INSERT INTO Mascota (rut,nombre,fechaNacimiento,claseanimal,raza,sexo,estado,imagen)
VALUES 	('16298925', 'Larry2','10/05/2001','Perro','Pastor Aleman','Macho','true','');
INSERT INTO Mascota (rut,nombre,fechaNacimiento,claseanimal,raza,sexo,estado,imagen)
VALUES 	('16298923', 'Aguja','10/05/2001','Perro','Salchicha','Macho','true','');
INSERT INTO Mascota (rut,nombre,fechaNacimiento,claseanimal,raza,sexo,estado,imagen)
VALUES 	('16298923', 'Laica','10/05/2001','Perro','Pastor Aleman','Macho','false','');
INSERT INTO Mascota (rut,nombre,fechaNacimiento,claseanimal,raza,sexo,estado,imagen)
VALUES 	('16298923', 'Boby','10/05/2001','Perro','Kiltro','Macho','true','');
INSERT INTO Mascota (rut,nombre,fechaNacimiento,claseanimal,raza,sexo,estado,imagen)
VALUES 	('16298923', 'patitas','10/05/2001','Perro','Pastor Aleman','Macho','true','');


INSERT INTO Atencion (clienteRut,mascotaNombre,servicio,hora,fecha,costo)
VALUES 		('16298923','Larry','Hoteleria','12:52:30','20/10/09','3600');
INSERT INTO Atencion (clienteRut,mascotaNombre,servicio,hora,fecha,costo)
VALUES 		('16298923','Larry','Policlinico I','18:53:30','08/04/09','8200');
INSERT INTO Atencion (clienteRut,mascotaNombre,servicio,hora,fecha,costo)
VALUES 		('16298923','Cachupin','Peluqueria','08:53:30','10/10/09','9500');
INSERT INTO Atencion (clienteRut,mascotaNombre,servicio,hora,fecha,costo)
VALUES 		('16298925','Laica','Policlinico II','13:53:30','07/02/09','12600');
INSERT INTO Atencion (clienteRut,mascotaNombre,servicio,hora,fecha,costo)
VALUES 		('16298923','Larry','Peluqueria','23:53:30','03/03/09','2000');


INSERT INTO atencionpostoperatorio(medicamentos, alimentos, indicaciones, servicio, hora, fecha, costo, nombremascota, rut, apellido, nombrecliente)
VALUES ('aspirina', 'agua, alimento', 'reposo', 'Post Operatorio', '15:50:00', '2009-03-03', '5000', 'Larry', '152348429', 'Gonzales', 'Pedro');
INSERT INTO atencionpostoperatorio(medicamentos, alimentos, indicaciones, servicio, hora, fecha, costo, nombremascota, rut, apellido, nombrecliente)
VALUES ('aspirina', 'agua, alimento', 'reposo', 'Post Operatorio', '16:10:00', '2009-03-03', '5000', 'Tom', '152348429', 'Gonzales', 'Pedro');



INSERT INTO  corte(rutcliente,nombremascota,servicio,hora,foto,fecha,raza,costo,nombre,categoria,descripcion)
VALUES		  ('16298925', 'Larry2',DEFAULT ,'08:30:15','','2007-06-01','Pastor','13300',''	,'Corte tradicional','');
INSERT INTO  corte(rutcliente,nombremascota,servicio,hora,foto,fecha,raza,costo,nombre,categoria,descripcion)
VALUES		  ('16298925', 'Larry2',DEFAULT ,'18:40:12','','2008-06-05','Pastor','2200',''	,'Tradicional','');
INSERT INTO  corte(rutcliente,nombremascota,servicio,hora,foto,fecha,raza,costo,nombre,categoria,descripcion)
VALUES		  ('16298925', 'Larry2',DEFAULT ,'13:30:10','','2009-03-03','Pastor','5300',''	,'Corte tradicional','');
INSERT INTO  corte(rutcliente,nombremascota,servicio,hora,foto,fecha,raza,costo,nombre,categoria,descripcion)
VALUES		  ('16298925', 'Larry2',DEFAULT ,'10:30:13','','2002-05-02','Pastor','5600',''	,'Corte tradicional','');
INSERT INTO  corte(rutcliente,nombremascota,servicio,hora,foto,fecha,raza,costo,nombre,categoria,descripcion)
VALUES		  ('16298925', 'Larry2',DEFAULT ,'20:30:35','','2009-01-01','Pastor','8500',''	,'Corte tradicional','');




INSERT INTO  atencionbanio(rutcliente,nombremascota,servicio,hora,fecha,costo,comentario)
VALUES			  ('16298925', 'Larry2',DEFAULT ,'00:30:15','2008-05-01','5600','');
INSERT INTO  atencionbanio(rutcliente,nombremascota,servicio,hora,fecha,costo,comentario)
VALUES			  ('16298925', 'Larry2',DEFAULT ,'12:30:15','2009-09-01','9600','');
INSERT INTO  atencionbanio(rutcliente,nombremascota,servicio,hora,fecha,costo,comentario)
VALUES			  ('16298925', 'Larry2',DEFAULT ,'14:30:15','2009-05-01','12600','');
INSERT INTO  atencionbanio(rutcliente,nombremascota,servicio,hora,fecha,costo,comentario)
VALUES			  ('16298923','Boby',DEFAULT ,'11:30:15','2008-11-04','2500','');
INSERT INTO  atencionbanio(rutcliente,nombremascota,servicio,hora,fecha,costo,comentario)
VALUES			  ('16298923','Boby',DEFAULT ,'08:30:15','2007-06-01','13300','');


INSERT INTO  atencionpedicure(rutcliente,nombremascota,servicio,hora	,fecha	  	,costo	,descripcion		, nombre)
VALUES		  ('16298923','Boby',DEFAULT ,'20:30:35' ,'2009-01-01'	,'8500','Corte y limpieza'	,'Corte de u�as');
INSERT INTO  atencionpedicure(rutcliente,nombremascota,servicio,hora	,fecha	  	,costo	,descripcion		, nombre)
VALUES		  ('16298923','Boby' ,DEFAULT ,'10:20:31' ,'2009-06-02'	,'6000','Corte y limpieza'	,' ');
INSERT INTO  atencionpedicure(rutcliente,nombremascota,servicio,hora	,fecha	  	,costo	,descripcion		, nombre)
VALUES		  ('16298923', 'Laica'  ,DEFAULT ,'15:30:35' ,'2008-01-08'	,'3210','Corte y limpieza'	,' ');
INSERT INTO  atencionpedicure(rutcliente,nombremascota,servicio,hora	,fecha	  	,costo	,descripcion		, nombre)
VALUES		  ('16298923','Boby' ,DEFAULT ,'18:30:35' ,'2009-06-01'	,'6500','Corte y limpieza'	,' ');
INSERT INTO  atencionpedicure(rutcliente,nombremascota,servicio,hora	,fecha	  	,costo	,descripcion		, nombre)
VALUES		  ('16298923', 'Laica' ,DEFAULT ,'03:30:35' ,'2002-01-01'	,'8500','Corte y limpieza'	,'Corte de u�as');


INSERT INTO atencioncontrol(descripcion, recomendacion, proximafecha, servicio, hora, fecha, costo)
VALUES ('visita control de parastios', 'labado semanal', '2009-11-20', 'Policlinico', '20:15', '2009-10-20','2500');
INSERT INTO atencioncontrol(descripcion, recomendacion, proximafecha, servicio, hora, fecha, costo)
VALUES ('visita control de parastios', 'labado semanal', '2009-11-20', 'Policlinico', '20:15', '2009-10-15','2500');
INSERT INTO atencioncontrol(descripcion, recomendacion, proximafecha, servicio, hora, fecha, costo)
VALUES ('visita control de parastios', 'labado semanal', '2009-11-20', 'Policlinico', '20:15', '2009-10-4','2500');
INSERT INTO atencioncontrol(descripcion, recomendacion, proximafecha, servicio, hora, fecha, costo)
VALUES ('visita control de parastios', 'labado semanal', '2009-11-20', 'Policlinico', '20:15', '2009-9-20','2500');
INSERT INTO atencioncontrol(descripcion, recomendacion, proximafecha, servicio, hora, fecha, costo)
VALUES ('visita control de parastios', 'labado semanal', '2009-11-20', 'Policlinico', '20:15', '2009-9-15','2500');
INSERT INTO atencioncontrol(descripcion, recomendacion, proximafecha, servicio, hora, fecha, costo)
VALUES ('visita control de parastios', 'labado semanal', '2009-11-20', 'Policlinico', '20:15', '2009-8-20', '2500');


INSERT INTO atencionpostoperatorio( medicamentos, alimentos, indicaciones, servicio, hora, fecha,costo, nombremascota, rut, apellido, nombrecliente)
VALUES ('aspirina', 'agua, alimento', 'reposo', 'Post Operatorio', '15:50:00', '2001-05-21', '5000', 'Larry', '152348429', 'Gonzales', 'Pedro');
INSERT INTO atencionpostoperatorio( medicamentos, alimentos, indicaciones, servicio, hora, fecha,costo, nombremascota, rut, apellido, nombrecliente)
VALUES ('aspirina', 'agua, alimento', 'reposo', 'Post Operatorio', '16:10:00', '2001-05-21', '5000', 'Tom', '152348429', 'Gonzales', 'Pedro');
INSERT INTO atencionpostoperatorio( medicamentos, alimentos, indicaciones, servicio, hora, fecha,costo, nombremascota, rut, apellido, nombrecliente)
VALUES ('diazepan', 'carne', 'asdasd', 'Pabellon', '12:56:00', '2001-05-21', '1000', 'Kaizer', '152348429', 'ramirez', 'Diego');
INSERT INTO atencionpostoperatorio( medicamentos, alimentos, indicaciones, servicio, hora, fecha,costo, nombremascota, rut, apellido, nombrecliente)
VALUES ('diazepan', 'carne', 'asdasd', 'Pabellon', '12:36:00', '2001-06-21', '1000', 'Kaizer', '152348429', 'ramirez', 'Diego');
INSERT INTO atencionpostoperatorio( medicamentos, alimentos, indicaciones, servicio, hora, fecha,costo, nombremascota, rut, apellido, nombrecliente)
VALUES ('diazepan', 'carne', 'asdasd', 'Pabellon', '12:53:00', '2001-09-21', '1000', 'Kaizer', '152348429', 'ramirez', 'Diego');
INSERT INTO atencionpostoperatorio( medicamentos, alimentos, indicaciones, servicio, hora, fecha,costo, nombremascota, rut, apellido, nombrecliente)
VALUES ('diazepan', 'carne', 'asdasd', 'Pabellon', '12:09:00', '2001-10-15', '1000', 'Kaizer', '152348429', 'ramirez', 'Diego');
INSERT INTO atencionpostoperatorio( medicamentos, alimentos, indicaciones, servicio, hora, fecha,costo, nombremascota, rut, apellido, nombrecliente)
 VALUES ('diazepan', 'carne', 'asdasd', 'Pabellon', '12:01:00', '2001-10-05', '1000', 'Kaizer', '152348429', 'ramirez', 'Diego');
 
 
 INSERT INTO atencionvacuna(precio, nombre, descripcion, fechacaducidad, servicio, hora, fecha, costo)
    VALUES ('6500', 'antiparasitits', 'reduce la vida de parasitos en el organismo', '2009-12-3', 'Policlinico', '15:34', 
            '2009-10-14', '4100');
INSERT INTO atencionvacuna(precio, nombre, descripcion, fechacaducidad, servicio, hora, fecha, costo)
    VALUES ('6500', 'antiparasitits', 'reduce la vida de parasitos en el organismo', '2009-12-3', 'Policlinico', '15:34', 
            '2009-10-2', '4100');
INSERT INTO atencionvacuna(precio, nombre, descripcion, fechacaducidad, servicio, hora, fecha, costo)
    VALUES ('6500', 'antiparasitits', 'reduce la vida de parasitos en el organismo', '2009-12-3', 'Policlinico', '15:34', 
            '2009-9-20', '4100');
INSERT INTO atencionvacuna(precio, nombre, descripcion, fechacaducidad, servicio, hora, fecha, costo)
    VALUES ('6500', 'antiparasitits', 'reduce la vida de parasitos en el organismo', '2009-12-3', 'Policlinico', '15:34', 
            '2009-9-24', '4100');
INSERT INTO atencionvacuna(precio, nombre, descripcion, fechacaducidad, servicio, hora, fecha, costo)
    VALUES ('6500', 'antiparasitits', 'reduce la vida de parasitos en el organismo', '2009-12-3', 'Policlinico', '15:34', 
            '2009-9-1', '4100');
INSERT INTO atencionvacuna(precio, nombre, descripcion, fechacaducidad, servicio, hora, fecha, costo)
    VALUES ('6500', 'antiparasitits', 'reduce la vida de parasitos en el organismo', '2009-12-3', 'Policlinico', '15:34', 
            '2009-8-20', '4100');
			
			
INSERT INTO atencionpreoperatorio( observaciones, sintomas, diagnosticos, servicio, hora, fecha, costo)
VALUES ('pierna rota', 'ninguno', 'asdasd', 'asdasd', '12:56', '2001-05-21', '1000');
INSERT INTO atencionpreoperatorio( observaciones, sintomas, diagnosticos, servicio, hora, fecha, costo)
    VALUES ('pierna rota', 'ninguno', 'asdasd', 'asdasd', '12:36', '2001-06-21', 
            '1000');
INSERT INTO atencionpreoperatorio( observaciones, sintomas, diagnosticos, servicio, hora, fecha, costo)
    VALUES ('pierna rota', 'ninguno', 'asdasd', 'asdasd', '12:53', '2001-09-21', 
            '1000');
INSERT INTO atencionpreoperatorio( observaciones, sintomas, diagnosticos, servicio, hora, fecha, costo)
    VALUES ('pierna rota', 'ninguno', 'asdasd', 'asdasd', '12:09', '2001-10-15', 
            '1000');
INSERT INTO atencionpreoperatorio( observaciones, sintomas, diagnosticos, servicio, hora, fecha, costo)
    VALUES ('pierna rota', 'ninguno', 'asdasd', 'asdasd', '12:01', '2001-10-05', 
            '1000');
			
INSERT INTO atencioncirugia(
            estado, diagnostico, tipo, servicio, hora, fecha, costo)
    VALUES (true, 'ninguno', 'no especificado', 'Pabellon', '16:30', '2009-10-12', '14930');
INSERT INTO atencioncirugia(
            estado, diagnostico, tipo, servicio, hora, fecha, costo)
    VALUES (true, 'ninguno', 'no especificado', 'Pabellon', '16:30', '2009-10-10', '14930');

INSERT INTO atencioncirugia(
            estado, diagnostico, tipo, servicio, hora, fecha, costo)
    VALUES (true, 'ninguno', 'no especificado', 'Pabellon', '16:30', '2009-10-5', '14930');

INSERT INTO atencioncirugia(
            estado, diagnostico, tipo, servicio, hora, fecha, costo)
    VALUES (true, 'ninguno', 'no especificado', 'Pabellon', '16:30', '2009-9-12', '14930');

INSERT INTO atencioncirugia(
            estado, diagnostico, tipo, servicio, hora, fecha, costo)
    VALUES (true, 'ninguno', 'no especificado', 'Pabellon', '16:30', '2009-9-25', '14930');

INSERT INTO atencioncirugia(
            estado, diagnostico, tipo, servicio, hora, fecha, costo)
    VALUES (true, 'ninguno', 'no especificado', 'Pabellon', '16:30', '2009-8-12', '14930');


INSERT INTO atencionvacuna(precio, nombre, descripcion, fechacaducidad, servicio, hora, fecha, costo)
    VALUES ('6500', 'antiparasitits', 'reduce la vida de parasitos en el organismo', '2009-12-3', 'Policlinico', '15:34', 
            '2009-8-12', '4100');
			
INSERT INTO atencionconsulta(
            anamnesis, servicio, hora, fecha, costo)
    VALUES ('Primera inyeccion', 'Policlinico', '15:36', '2009-10-20', '5000');
INSERT INTO atencionconsulta(
            anamnesis, servicio, hora, fecha, costo)
    VALUES ('control mensual de octubre', 'Policlinico', '15:36', '2009-10-5', '5000');

INSERT INTO atencionconsulta(
            anamnesis, servicio, hora, fecha, costo)
    VALUES ('Primera inyeccion', 'Policlinico', '15:36', '2009-10-15', '5000');

INSERT INTO atencionconsulta(
            anamnesis, servicio, hora, fecha, costo)
    VALUES ('Primera inyeccion', 'Policlinico', '15:36', '2009-9-20', '5000');

INSERT INTO atencionconsulta(
            anamnesis, servicio, hora, fecha, costo)
    VALUES ('Primera inyeccion', 'Policlinico', '15:36', '2009-9-28', '5000');

INSERT INTO atencionconsulta(
            anamnesis, servicio, hora, fecha, costo)
    VALUES ('Primera inyeccion', 'Policlinico', '15:36', '2009-9-1', '5000');

INSERT INTO atencionconsulta(
            anamnesis, servicio, hora, fecha, costo)
    VALUES ('Primera inyeccion', 'Policlinico', '15:36', '2009-8-20', '5000');

