create table Atencion(
	clienteRut int not null references ClientePresencial(rut) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	mascotaNombre CHAR(20) not null,
	servicio CHAR(20),
	hora time,
	fecha date,
	constraint PK_mascotaNombre primary key (mascotaNombre)
)


