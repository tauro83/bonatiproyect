CREATE TABLE atencionpedicure(
	rutcliente character(9),
	nombremascota character(50),
	servicio varchar(20) DEFAULT 'Peluqueria',
	hora time,
	fecha date ,
	costo varchar(20),	
	descripcion varchar(500),
	nombre varchar(20),
	primary key (hora,fecha,servicio),
	FOREIGN KEY (rutcliente,nombremascota) REFERENCES Mascota(rut,nombre) MATCH FULL ON UPDATE RESTRICT ON DELETE RESTRICT
);


