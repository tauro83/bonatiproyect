CREATE TABLE catpeluqueria
(
  servicio character(20) NOT NULL,
  nombre character(20) NOT NULL,
  precio integer,
  descripcion character(160),
  estado boolean DEFAULT true,
  CONSTRAINT catpeluqueria_pkey PRIMARY KEY (servicio, nombre)
);

create table peluqueria(
	servicio CHAR(20) not null,
	nombre CHAR(20) not null,
	clienteRut CHAR(9) not null references ClientePresencial(rut) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	mascotaNombre CHAR(50) not null,
	hora time not null,
	responsable CHAR(20) not null references Usuario(usuario) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	fecha date not null,
	costo char(20),
	descripcion CHAR(200),
	estado Boolean default true,
	constraint PK_peluqueriaR primary key (mascotaNombre,hora,clienteRut,fecha,servicio),
	CONSTRAINT PK_catalogo FOREIGN KEY (servicio, nombre)
      REFERENCES catpeluqueria (servicio, nombre) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);
