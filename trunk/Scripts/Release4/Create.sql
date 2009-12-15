CREATE TABLE pago
(
  fecha date NOT NULL,
  hora time without time zone NOT NULL,
  estado integer,
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
  CONSTRAINT pk_detallepago PRIMARY KEY (fecha, hora, codigoproducto)
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
  asunto character(50),
  descripcion character(160),
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
  descripcion character(50),
  estado integer default 0,
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

