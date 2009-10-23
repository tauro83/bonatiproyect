-- Table: mascota

-- DROP TABLE mascota;

CREATE TABLE mascota
(
  rut character(9) NOT NULL,
  nombre character(50) NOT NULL,
  fechanacimiento character(10),
  claseanimal character(50),
  raza character(50),
  sexo character(10),
  estado boolean,
  imagen bytea,
  CONSTRAINT pk_mascota PRIMARY KEY (rut, nombre),
  CONSTRAINT fk_mascota_reference_cliente FOREIGN KEY (rut)
      REFERENCES cliente (rut) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
) 
WITHOUT OIDS;
ALTER TABLE mascota OWNER TO postgres;
