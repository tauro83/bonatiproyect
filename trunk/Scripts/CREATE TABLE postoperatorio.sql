CREATE TABLE atencionpostoperatorio
(
  medicamentos character(50),
  alimentos character(50),
  indicaciones character(50),
  servicio character varying(20) NOT NULL DEFAULT 'Pabellon'::character varying,
  hora character(10) NOT NULL,
  fecha date NOT NULL,
  costo character(50),
  nombremascota character(50),
  rut character(9),
  apellido character(50),
  nombrecliente character(50),
  estado character(1),
  CONSTRAINT atencionpostoperatorio_pkey PRIMARY KEY (hora, fecha, servicio)
)