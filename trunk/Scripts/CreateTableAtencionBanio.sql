CREATE TABLE atencionbanio(
	rutcliente character(9),
	nombremascota character(50),
	servicio varchar(20) DEFAULT 'Peluqueria',
	hora time,
	fecha date ,
	costo varchar(20),	
	comentario varchar(500),
	primary key (hora,fecha,servicio),
	FOREIGN KEY (rutcliente,nombremascota) REFERENCES Mascota(rut,nombre) MATCH FULL ON UPDATE RESTRICT ON DELETE RESTRICT
);




	

	