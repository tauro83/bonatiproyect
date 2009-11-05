drop table IF EXISTS Usuario cascade;
drop table IF EXISTS ClientePresencial cascade;
drop table IF EXISTS Mascota cascade;
drop table IF EXISTS Producto cascade;
drop table IF EXISTS bitacora cascade;
drop table IF EXISTS atencionpostoperatorio cascade;
drop table IF EXISTS atencionpedicure cascade;
drop table IF EXISTS atencionbanio cascade; 
drop table IF EXISTS corte cascade;
drop table IF EXISTS Atencion cascade;
drop table IF EXISTS preoperatorio cascade;
drop table IF EXISTS cita cascade;
drop table IF EXISTS Cirugia cascade;
drop table IF EXISTS Diagnosticos cascade; 
drop table IF EXISTS atencionvacuna cascade;
drop table IF EXISTS atencioncirugia cascade;
drop table IF EXISTS atencionconsulta cascade;
drop table IF EXISTS atencioncontrol cascade;
drop table IF EXISTS atencionpreoperatorio cascade;

CREATE TABLE Usuario
(
	nombre	CHAR(20),
	aPaterno CHAR(20),
	aMaterno CHAR(20),	
	usuario  CHAR(20) primary key,
	cargo	char(20),
	contrasena	char(20),
	servicio	char(20),
	pRegistrar	bool,
	pEditar		bool,
	pEliminar	bool,
	pPurgar		bool,	
	estado bool DEFAULT true,
	id serial
);



create table ClientePresencial
(
	rut CHAR(9) not null,
	telefono int ,
	celular int ,
	nombre CHAR(20),
	aPaterno CHAR(20),
    aMaterno CHAR(20),
	correo CHAR(20),
	estado bool,
	domicilio CHAR(40),
	comuna CHAR(20),
    region CHAR(20),
	constraint PK_rut primary key (rut)
);

create table Mascota
(
	rut character(9),
	nombre character(50),
	fechanacimiento character(10),
	claseanimal character(50),
	raza character(50),
	sexo character(10),
	estado bool,
	imagen bytea,
	CONSTRAINT pk_mascota PRIMARY KEY (rut, nombre),
	CONSTRAINT fk_mascota_reference_ClientePresencial FOREIGN KEY (rut)	REFERENCES ClientePresencial(rut) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

CREATE TABLE Producto
(
	nombre	CHAR(20),
	precio CHAR(20),
	categoria CHAR(20),
	codigo CHAR(20) primary key
);



CREATE TABLE bitacora
(
  usuario character(20) NOT NULL,
  accion character(20) NOT NULL,
  fechaaccion character(20) NOT NULL,
  horaaccion character(20) NOT NULL,
  fechaacita character(20),
  horacita character(20),
  cliente character(20),
  mascota character(20),
  servicio character(20),
  CONSTRAINT pk_bitacora PRIMARY KEY (usuario, accion, fechaaccion, horaaccion)
) ;


CREATE TABLE atencionpostoperatorio
(
  medicamentos character(50),
  alimentos character(50),
  indicaciones character(50),
  servicio character varying(20) NOT NULL DEFAULT 'Pabellon'::character varying,
  hora character(10),
  fecha date NOT NULL,
  costo character(50),
  nombremascota character(50),
  rut character(9),
  apellido character(50),
  nombrecliente character(50),
  CONSTRAINT atencionpostoperatorio_pkey PRIMARY KEY (hora, fecha, servicio)
);


CREATE TABLE atencionpedicure
(
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

CREATE TABLE atencionbanio
(
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

CREATE TABLE corte
(
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


create table Atencion
(
	clienteRut CHAR(9) references ClientePresencial(rut) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	mascotaNombre CHAR(20) not null,
	servicio CHAR(20),
	hora time,
	fecha CHAR(20),
	costo char(20),
	constraint PK_mascotaNombre primary key (mascotaNombre,hora,servicio)
);

create table preoperatorio 
(
	idpreoperatorio CHAR(8) not null,
	observaciones CHAR(50),
	sintomas CHAR(50),
    diagnostico CHAR(50),
	fecha CHAR(10),
	hora CHAR(10),
    responsable CHAR(30),
	ayudante CHAR(30),
	constraint PK_preoperatorio primary key (idpreoperatorio,fecha,hora)
);


CREATE TABLE cita
(
  rutcliente character(9),
  nombremascota character(20),
  fecha character(10) NOT NULL,
  hora character(5) NOT NULL,
  servicio character(30) NOT NULL,
  responsable character(20) NOT NULL,
  CONSTRAINT pk_cita PRIMARY KEY (fecha, hora, servicio, responsable),
  CONSTRAINT fk_cita_reference_cliente FOREIGN KEY (rutcliente)  REFERENCES clientePresencial (rut) MATCH FULL  ON UPDATE RESTRICT ON DELETE RESTRICT,
  CONSTRAINT fk_cita_reference_usuario FOREIGN KEY (responsable) REFERENCES usuario (usuario) MATCH FULL ON UPDATE RESTRICT ON DELETE RESTRICT
);


create table Cirugia
(
	clienteRut CHAR(9) not null references ClientePresencial(rut) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	mascotaNombre CHAR(50) not null,
	hora time not null,
	responsable CHAR(20) not null references Usuario(usuario) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	ayudante CHAR(20) not null references Usuario(usuario) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	fecha CHAR(10) not null,
	costo char(20),
	constraint PK_cirugia primary key (mascotaNombre,hora,clienteRut,fecha)
	
);

create table Diagnosticos(
	clienteRut CHAR(9) not null,
	mascotaNombre CHAR(50) not null,
	hora time not null,
	fecha CHAR(10) not null,
	diagnostico CHAR(200),
	nuevaFecha CHAR(10) not null,
	tipoCirugia CHAR(30),
	nuevaHora time not null,
	id CHAR(2),
	constraint PK_diagnosticos primary key (mascotaNombre,hora,clienteRut,fecha,nuevaFecha,nuevaHora,id),
	CONSTRAINT fk_cita_reference_usuario FOREIGN KEY (clienteRut,mascotaNombre,hora,fecha) REFERENCES Cirugia(clienteRut,mascotaNombre,hora,fecha) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
);

create table atencionvacuna(
	precio character(15),
	nombre character(50),
	descripcion character(100),
	fechacaducidad date,
	servicio character varying(20) NOT NULL DEFAULT 'Pabellon'::character varying,
	hora character(10),
	fecha date NOT NULL,
	costo character(50),
	CONSTRAINT atencionvacuna_pkey PRIMARY KEY (nombre, hora, fecha, servicio)
);


create table atencioncirugia (
	estado boolean,
	diagnostico character(100),
	tipo character(50),
	servicio character varying(20) NOT NULL DEFAULT 'Pabellon'::character varying,
	hora character(10),
	fecha date NOT NULL,
	costo character(50),
	CONSTRAINT atencioncirugia_pkey PRIMARY KEY (hora, fecha, servicio)
);

create table atencionconsulta(
	anamnesis character(100),
	servicio character varying(20) NOT NULL DEFAULT 'Pabellon'::character varying,
	hora character(10),
	fecha date NOT NULL,
	costo character(50),
	CONSTRAINT atencionconsulta_pkey PRIMARY KEY (hora, fecha, servicio)
);


create table atencioncontrol(
	descripcion character(100),
	recomendacion character(50),
	proximafecha date,
	servicio character varying(20) NOT NULL DEFAULT 'Pabellon'::character varying,
	hora character(10),
	fecha date NOT NULL,
	costo character(50),
	CONSTRAINT atencioncontrol_pkey PRIMARY KEY (hora, fecha, servicio)
);


create table atencionpreoperatorio(
	observaciones character(100),
	sintomas character(100),
	diagnosticos character(100),
	servicio character varying(20) NOT NULL DEFAULT 'Pabellon'::character varying,
	hora character(10),
	fecha date NOT NULL,
	costo character(50),
	CONSTRAINT atencionpreoperatorio_key PRIMARY KEY (hora, fecha, servicio)
);
