CREATE TABLE corte(
	rutcliente character(9),
	nombremascota character(50),
	servicio varchar(20) DEFAULT 'Peluqueria',
	hora time,
	foto bytea,
	fecha date,
	raza varchar(20),
	costo varchar(20),	
	nombre varchar(20),
	categoria varchar(20),	
	descripcion varchar(500),
	primary key (hora,fecha,servicio),
	FOREIGN KEY (rutcliente,nombremascota) REFERENCES Mascota(rut,nombre) MATCH FULL ON UPDATE RESTRICT ON DELETE RESTRICT
);

