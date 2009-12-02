CREATE TABLE Especie
(
	nombre	CHAR(20) primary key
);

CREATE TABLE Cargo
(
	nombre	CHAR(20) primary key
);


CREATE TABLE Servicio
(
	nombre	CHAR(20) primary key
);

CREATE TABLE Vacuna
(
	nombre	CHAR(20) primary key,
	precio  int,
	caducidad int,
	descripcion CHAR(50)
	
);

create table Vacunacion(
	vacuna CHAR(30) not null references vacuna(Nombre),
	clienteRut CHAR(9) not null references ClientePresencial(rut) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	mascotaNombre CHAR(50) not null,
	hora time not null,
	responsable CHAR(20) not null references Usuario(usuario) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	fecha date not null,
	costo char(20),
	estado integer DEFAULT '0',
	fechacaducidad date,
	descripcion CHAR(200),
	servicio character varying(20) NOT NULL DEFAULT 'Pabellon'::character varying,
	constraint PK_vacuna primary key (mascotaNombre,hora,clienteRut,fecha,vacuna)
);

CREATE TABLE postoperatorio
(
  idpostoperatorio character(8) NOT NULL,
  observaciones character(50),
  sintomas character(50),
  diagnostico character(50),
  fecha character(10) NOT NULL,
  hora time without time zone NOT NULL,
  clienterut character(9) NOT NULL,
  mascotanombre character(50) NOT NULL,
  responsable character(30),
  alimento character(50),
  medicamento character(50),
  ayudante character(30),
  estado integer DEFAULT '0',
  CONSTRAINT pk_postoperatorio PRIMARY KEY (idpostoperatorio, fecha, hora)
);

CREATE TABLE consulta
(
  anamnesis character(300),
  servicio character(20) NOT NULL,
  hora character(20) NOT NULL,
  fecha character(20) NOT NULL,
  costo character(50),
  rut character(9),
  nombre character(20),
  responsable character(20),
  estado integer DEFAULT '0',
  CONSTRAINT consulta_pkey PRIMARY KEY (hora, fecha, servicio),
  CONSTRAINT consulta_rut_fkey FOREIGN KEY (rut, nombre)
      REFERENCES mascota (rut, nombre) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
); 

CREATE TABLE catpeluqueria
(
  servicio character(20) NOT NULL,
  nombre character(20) NOT NULL,
  precio integer,
  descripcion character(160),
  estado integer DEFAULT '0',
  CONSTRAINT catpeluqueria_pkey PRIMARY KEY (servicio, nombre)
);

create table atencionpeluqueria(
	clienteRut CHAR(9) not null references ClientePresencial(rut) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	mascotaNombre CHAR(50) not null,
	hora time not null,
	responsable CHAR(20) not null references Usuario(usuario) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	fecha date not null,
	estado integer DEFAULT '0',
	constraint PK_peluqueriaAten primary key (mascotaNombre,hora,clienteRut,fecha,responsable)
);

create table serviciospeluqueria(
	servicio CHAR(20) not null,
	nombre CHAR(20) not null,
	clienteRut CHAR(9) not null references ClientePresencial(rut) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	mascotaNombre CHAR(50) not null,
	hora time not null,
	responsable CHAR(20) not null references Usuario(usuario) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	fecha date not null,
	nuevafecha date not null,
	nuevahora time not null,
	costo char(20),
	descripcion CHAR(200),
	estado integer DEFAULT '0',
	constraint PK_peluqueriaServ primary key (mascotaNombre,hora,clienteRut,fecha,servicio,nombre),
	CONSTRAINT PK_catalogo FOREIGN KEY (servicio, nombre)
      REFERENCES catpeluqueria (servicio, nombre) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
);

CREATE TABLE atencionalojamiento
(
  servicio character(20),
  hora character(10) NOT NULL,
  fechaIngreso date NOT NULL,
  costo character(7),
  responsable character(30) NOT NULL,
  cliente character(30),
  mascota character(30),
  canil int,
  fechaSalida date NOT NULL,
  comentario character(500),
  diasEstadia int,
  eliminado boolean,
  estado integer DEFAULT '0',
  CONSTRAINT atencionalojamiento_pkey PRIMARY KEY (fechaIngreso, fechaSalida, canil),
  CONSTRAINT atencionalojamiento_mascota_fkey FOREIGN KEY (cliente, mascota)
      REFERENCES mascota (rut, nombre) MATCH FULL
      ON UPDATE CASCADE ON DELETE SET NULL
);

create table control(
	cliente character(9),
	mascota character(30),
	descripcion character(500),
	fecha date NOT NULL,
	hora character(10) NOT NULL,
	responsable character(30),
	servicio character (20),
	costo character(7),
	estado integer DEFAULT '0',
	CONSTRAINT control_pkey PRIMARY KEY (hora, fecha, responsable),
	CONSTRAINT control_usuario_fkey FOREIGN KEY (responsable)
		REFERENCES usuario (usuario) MATCH FULL
		ON UPDATE CASCADE ON DELETE RESTRICT,
	CONSTRAINT control_mascota_fkey FOREIGN KEY (cliente, mascota)
		REFERENCES mascota (rut, nombre) MATCH FULL
		ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE preoperatorio
(
  rut character(9) NOT NULL,
  nombre character(50) NOT NULL,
  observaciones character(50),
  sintomas character(50),
  diagnostico character(50),
  fecha character(10) NOT NULL,
  hora character(10) NOT NULL,
  responsable character(30),
  ayudante character(30),
  estado integer DEFAULT '0',
  CONSTRAINT pk_preoperatorio PRIMARY KEY (rut, fecha, hora)
);
