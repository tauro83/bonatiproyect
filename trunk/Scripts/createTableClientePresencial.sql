create table ClientePresencial (
	rut CHAR(8) not null,
	telefono1 int ,
	telefono2 int ,
	nombre CHAR(20),
	correo CHAR(20),
	estado bool,
	domicilioNumero int,
	domicilioComuna CHAR(20), 
	domicilioCalle CHAR(20),
	constraint PK_rut primary key (rut)
);


		


