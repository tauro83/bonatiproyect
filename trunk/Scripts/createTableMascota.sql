create table Mascota(
	clienteRut int not null references ClientePresencial(rut) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	nombre CHAR(20),
	fechaNacimiento date ,
	sexo CHAR(20),
	estado bool,
	raza CHAR(20),
    primary key (nombre,clienteRut)
)


