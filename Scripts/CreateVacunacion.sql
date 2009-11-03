create table Vacunacion(
	vacuna CHAR(30) not null references vacuna(Nombre),
	clienteRut CHAR(9) not null references ClientePresencial(rut) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	mascotaNombre CHAR(50) not null,
	hora time not null,
	responsable CHAR(20) not null references Usuario(usuario) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	fecha date not null,
	costo char(20),
	fechacaducidad date,
	descripcion CHAR(200),
	servicio character varying(20) NOT NULL DEFAULT 'Pabellon'::character varying,
	constraint PK_vacuna primary key (mascotaNombre,hora,clienteRut,fecha,vacuna)
);