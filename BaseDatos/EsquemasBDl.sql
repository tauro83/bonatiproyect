drop table Usuario cascade;
drop table ClientePresencial cascade;
drop table Mascota cascade;
drop table bitacora cascade;
drop table atencionpedicure cascade;
drop table atencionbanio cascade; 
drop table corte cascade;
drop table Atencion cascade;
drop table cita cascade;
drop table Cirugia cascade;
drop table Diagnosticos cascade; 
drop table atencionvacuna cascade;
drop table atencioncirugia cascade;
drop table atencionconsulta cascade;
drop table atencioncontrol cascade;
drop table atencionpreoperatorio cascade;
drop table Especie cascade;
drop table Cargo cascade;
drop table Servicio cascade;
drop table Vacuna cascade;
drop table Vacunacion cascade;
drop table consulta cascade;
drop table atencionpostoperatorio cascade;
drop table serviciopeluq cascade;
drop table catpeluqueria cascade;
drop table atencionpeluqueria cascade;
drop table serviciospeluqueria cascade;
drop table atencionalojamiento cascade;
drop table control cascade;
drop table preoperatorio cascade;
drop table pago cascade;
drop table detallepago cascade;
drop table avisoweb cascade;
drop table raza cascade;
drop table producto cascade;
drop table asuntowebaviso cascade;
drop table comuna cascade;
drop table bitacora2 cascade;
drop table cirugiaobj cascade;

CREATE TABLE usuario
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



create table clientepresencial
(
	rut CHAR(9) not null,
	telefono int ,
	celular int ,
	nombre CHAR(20),
	aPaterno CHAR(20),
    aMaterno CHAR(20),
	correo CHAR(60),
	estado bool,
	domicilio CHAR(200),
	comuna CHAR(50),
    region CHAR(50),
	constraint PK_rut primary key (rut)
);

create table mascota
(
	rut character(9),
	nombre character(50),
	fechanacimiento character(10),
	claseanimal character(50),
	raza character(50),
	sexo character(10),
	estado bool,
	imagen bytea,
	CONSTRAINT pk_mascota PRIMARY KEY (nombre,rut),
	CONSTRAINT fk_mascota_reference_ClientePresencial FOREIGN KEY (rut)	REFERENCES ClientePresencial(rut) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
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


CREATE TABLE atencionpedicure
(
	rutcliente character(9),
	nombremascota character(50),
	servicio varchar(20) DEFAULT 'Peluqueria',
	hora time,
	fecha date ,
	costo varchar(20),	
	descripcion text,
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
	comentario text,
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
	descripcion text,
	primary key (hora,fecha,servicio),
	FOREIGN KEY (rutcliente,nombremascota) REFERENCES Mascota(rut,nombre) MATCH FULL ON UPDATE RESTRICT ON DELETE RESTRICT
);


create table atencion
(
	clienteRut CHAR(9) references ClientePresencial(rut) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	mascotaNombre CHAR(20) not null,
	servicio CHAR(20),
	hora time,
	fecha CHAR(20),
	costo char(20),
	constraint PK_mascotaNombre primary key (mascotaNombre,hora,servicio)
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
  FOREIGN KEY (rutcliente)  REFERENCES clientePresencial (rut) MATCH FULL  ON UPDATE RESTRICT ON DELETE RESTRICT,
  FOREIGN KEY (responsable) REFERENCES usuario (usuario) MATCH FULL ON UPDATE RESTRICT ON DELETE RESTRICT
);


CREATE TABLE cirugia
(
  clienterut character(9) NOT NULL,
  mascotanombre character(50) NOT NULL,
  hora time without time zone NOT NULL,
  responsable character(20) NOT NULL,
  ayudante character(20) NOT NULL,
  fecha character(10) NOT NULL,
  costo character(20),
  estado integer DEFAULT 0,
  motivo text DEFAULT 0,	
  servicio character varying(20) NOT NULL DEFAULT 'Pabellon'::character varying,
  CONSTRAINT pk_cirugia PRIMARY KEY (mascotanombre, hora, clienterut, fecha),
  CONSTRAINT cirugia_ayudante_fkey FOREIGN KEY (ayudante)
      REFERENCES usuario (usuario) MATCH FULL
      ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT cirugia_clienterut_fkey FOREIGN KEY (clienterut)
      REFERENCES clientepresencial (rut) MATCH FULL
      ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT cirugia_responsable_fkey FOREIGN KEY (responsable)
      REFERENCES usuario (usuario) MATCH FULL
      ON UPDATE CASCADE ON DELETE RESTRICT
);

create table diagnosticos(
	clienteRut CHAR(9) not null,
	mascotaNombre CHAR(50) not null,
	hora time not null,
	fecha CHAR(10) not null,
	diagnostico text,
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
	descripcion text,
	fechacaducidad date,
	servicio character varying(20) NOT NULL DEFAULT 'Pabellon'::character varying,
	hora character(10),
	fecha date NOT NULL,
	costo character(50),
	CONSTRAINT atencionvacuna_pkey PRIMARY KEY (nombre, hora, fecha, servicio)
);


create table atencioncirugia (
	estado boolean,
	diagnostico text,
	tipo character(50),
	servicio character varying(20) NOT NULL DEFAULT 'Pabellon'::character varying,
	hora character(10),
	fecha date NOT NULL,
	costo character(50),
	CONSTRAINT atencioncirugia_pkey PRIMARY KEY (hora, fecha, servicio)
);

create table atencionconsulta(
	anamnesis text,
	servicio character varying(20) NOT NULL DEFAULT 'Pabellon'::character varying,
	hora character(10),
	fecha date NOT NULL,
	costo character(50),
	CONSTRAINT atencionconsulta_pkey PRIMARY KEY (hora, fecha, servicio)
);

create table atencioncontrol(
	cliente character(9),
	mascota character(30),
	descripcion text,
	fecha date NOT NULL,
	hora character(10) NOT NULL,
	responsable character(30),
	servicio character (20),
	costo character(7),
        motivo text DEFAULT 0,
	CONSTRAINT atencioncontrol_pkey PRIMARY KEY (hora, fecha, responsable),
	CONSTRAINT atencioncontrol_usuario_fkey FOREIGN KEY (responsable)
		REFERENCES usuario (usuario) MATCH FULL
		ON UPDATE CASCADE ON DELETE RESTRICT,
	CONSTRAINT atencioncontrol_mascota_fkey FOREIGN KEY (cliente, mascota)
		REFERENCES mascota (rut, nombre) MATCH FULL
		ON UPDATE CASCADE ON DELETE RESTRICT
);


create table atencionpreoperatorio(
	observaciones text,
	sintomas text,
	diagnosticos text,
	servicio character varying(20) NOT NULL DEFAULT 'Pabellon'::character varying,
	hora character(10),
	fecha date NOT NULL,
	costo character(50),
	CONSTRAINT atencionpreoperatorio_key PRIMARY KEY (hora, fecha, servicio)
);

CREATE TABLE especie
(
	nombre	CHAR(20) primary key
);

CREATE TABLE Cargo
(
	nombre	CHAR(20) primary key
);


CREATE TABLE servicio
(
	nombre	CHAR(20) primary key
);

CREATE TABLE vacuna
(
	nombre	CHAR(20) primary key,
	precio  int,
	caducidad int,
	descripcion text
	
);

create table vacunacion(
	vacuna CHAR(30) not null references vacuna(Nombre),
	clienteRut CHAR(9) not null references ClientePresencial(rut) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	mascotaNombre CHAR(50) not null,
	hora time not null,
	responsable CHAR(20) not null references Usuario(usuario) MATCH FULL ON DELETE RESTRICT ON UPDATE CASCADE,
	fecha date not null,
	costo char(20),
	estado integer DEFAULT '0',
	fechacaducidad date,
	descripcion text,
        motivo text DEFAULT 0,
	servicio character varying(20) NOT NULL DEFAULT 'Policlinico'::character varying,
	constraint PK_vacuna primary key (mascotaNombre,hora,clienteRut,fecha,vacuna)
);

CREATE TABLE consulta
(
  anamnesis text,
  servicio character(20) NOT NULL,
  hora character(20) NOT NULL,
  fecha character(20) NOT NULL,
  costo character(50),
  rut character(9),
  nombre character(20),
  responsable character(20),
  estado integer DEFAULT '0',
  motivo text DEFAULT 0,
  CONSTRAINT consulta_pkey PRIMARY KEY (hora, fecha, servicio),
  CONSTRAINT consulta_rut_fkey FOREIGN KEY (rut, nombre)
      REFERENCES mascota (rut, nombre) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
); 

CREATE TABLE atencionpostoperatorio
(
  medicamentos character(50),
  alimentos character(50),
  indicaciones text,
  servicio character varying(20) NOT NULL DEFAULT 'Pabellon'::character varying,
  hora character(10) NOT NULL,
  fecha character(10) NOT NULL,
  costo character(50),
  nombremascota character(50),
  rut character(9),
  apellido character(50),
  nombrecliente character(50),
  estado integer DEFAULT 0,
  motivo character(200) DEFAULT 0,
  CONSTRAINT pkey_atencionpostoperatorio PRIMARY KEY (hora, fecha, servicio),
  CONSTRAINT fk_atencionpostoperatorio_reference_mascota FOREIGN KEY (nombremascota, rut)
      REFERENCES mascota (nombre, rut) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);

CREATE TABLE serviciopeluq
(
  nombre character(20) NOT NULL,
  CONSTRAINT pkey_serviciopeluq PRIMARY KEY (nombre)
);

CREATE TABLE catpeluqueria
(
  servicio character(20) NOT NULL,
  nombre character(20) NOT NULL,
  precio integer,
  descripcion text,
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
	servicio character varying(20) NOT NULL DEFAULT 'Peluqueria'::character varying,
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
	descripcion text,
	estado integer DEFAULT '0',
	motivo text DEFAULT 0,
	constraint PK_peluqueriaServ primary key (mascotaNombre,hora,clienteRut,fecha,servicio,nuevahora,nuevafecha,nombre),
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
  comentario text,
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
	descripcion text,
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
  observaciones text,
  sintomas text,
  diagnostico text,
  fecha character(10) NOT NULL,
  hora character(10) NOT NULL,
  responsable character(30),
  ayudante character(30),
  estado integer DEFAULT '0',
  motivo text DEFAULT 0,		
  CONSTRAINT pk_preoperatorio PRIMARY KEY (rut, fecha, hora)
);

CREATE TABLE pago
(
  fecha date NOT NULL,
  hora time without time zone NOT NULL,
  estado integer DEFAULT 0,
  total integer,
  CONSTRAINT pk_pago PRIMARY KEY (fecha, hora)
);

CREATE TABLE detallepago
(
  fecha date NOT NULL,
  hora time without time zone NOT NULL,
  codigoproducto character(20) NOT NULL,
  cantidad integer,
  subtotal integer,
  CONSTRAINT pk_detallepago PRIMARY KEY (fecha, hora, codigoproducto), 
  CONSTRAINT fk_detallepago_pago
    FOREIGN KEY (fecha, hora)
    REFERENCES pago(fecha, hora)
    ON DELETE CASCADE
    ON UPDATE CASCADE
);

CREATE TABLE avisoweb
(
  id integer NOT NULL,
  nombre character(20) NOT NULL,
  apaterno character(20) NOT NULL,
  telefono0 character(4),
  telefono character(20),
  celular0 character(4),
  celular character(20),
  asunto text,
  descripcion text,
  estado integer DEFAULT '0',
  CONSTRAINT avisoweb_pkey PRIMARY KEY (nombre, id)
);

CREATE TABLE raza
(
  nombre character(30) NOT NULL,
  especie character(20) NOT NULL,
  CONSTRAINT pk_raza PRIMARY KEY (nombre, especie),
  CONSTRAINT raza_especie_fkey FOREIGN KEY (especie)
      REFERENCES especie (nombre) MATCH FULL
      ON UPDATE CASCADE ON DELETE RESTRICT
);

CREATE TABLE producto
(
  nombre character(20),
  precio character(20),
  categoria character(20),
  codigo character(20) NOT NULL,
  descripcion text,
  estado integer default 0,
  stock integer default 0,
  CONSTRAINT producto_pkey PRIMARY KEY (codigo)
); 

CREATE TABLE asuntowebaviso
(
	nombre Char (30) not null

);

CREATE TABLE comuna
(
  nombre character(50) NOT NULL,
  numregion integer,
  nombreregion character(60),
  CONSTRAINT id PRIMARY KEY (nombre, numregion)
) ;

CREATE TABLE bitacora2
(
  fecha character(10) NOT NULL,
  usuario character(50) NOT NULL,
  servicio character(20),
  accion character(120)
);

CREATE TABLE cirugiaobj
(
	nombre	CHAR(20) primary key,
	precio  int,
	descripcion text
	
);

CREATE TABLE productovendido
(
  codigo character(15) NOT NULL,
  unidades integer,
  precio integer,
  fecha date,
  CONSTRAINT productovendido_pkey PRIMARY KEY (codigo, fecha)
);
