create table Cirugia(
	clienteRut CHAR(8) not null references ClientePresencial(rut) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	mascotaNombre CHAR(50) not null,
	hora time not null,
	responsable CHAR(20) not null references Usuario(usuario) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	ayudante CHAR(20) not null references Usuario(usuario) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	fecha CHAR(10) not null,
	costo char(20),
	constraint PK_cirugia primary key (mascotaNombre,hora,clienteRut,fecha)
	
);

create table Diagnosticos(
	clienteRut CHAR(8) not null,
	mascotaNombre CHAR(50) not null,
	hora time not null,
	fecha CHAR(10) not null,
	diagnostico CHAR(200),
	nuevaFecha CHAR(10) not null,
	tipoCirugia CHAR(30),
	nuevaHora time not null,
	constraint PK_diagnosticos primary key (mascotaNombre,hora,clienteRut,fecha,nuevaFecha,nuevaHora),
	CONSTRAINT fk_cita_reference_usuario FOREIGN KEY (clienteRut,mascotaNombre,hora,fecha) REFERENCES Cirugia(clienteRut,mascotaNombre,hora,fecha) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);