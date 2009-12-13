CREATE TABLE atencionpostoperatorio
(
  medicamentos character(50),
  alimentos character(50),
  indicaciones character(50),
  servicio character varying(20) NOT NULL DEFAULT 'Pabellon'::character varying,
  hora character(10) NOT NULL,
  fecha character(10) NOT NULL,
  costo character(50),
  nombremascota character(50),
  rut character(9),
  apellido character(50),
  nombrecliente character(50),
  estado integer,
  CONSTRAINT pkey_atencionpostoperatorio PRIMARY KEY (hora, fecha, servicio),
    CONSTRAINT fk_atencionpostoperatorio_reference_mascota FOREIGN KEY (nombremascota, rut)
      REFERENCES mascota (nombre, rut) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
)
