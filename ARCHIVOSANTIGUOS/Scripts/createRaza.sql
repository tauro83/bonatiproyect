-- DROP TABLE raza;

CREATE TABLE raza
(
  nombre character(30) NOT NULL,
  especie character(20) NOT NULL,
  CONSTRAINT pk_raza PRIMARY KEY (nombre, especie),
  CONSTRAINT raza_especie_fkey FOREIGN KEY (especie)
      REFERENCES especie (nombre) MATCH FULL
      ON UPDATE CASCADE ON DELETE RESTRICT
) 
WITHOUT OIDS;
ALTER TABLE raza OWNER TO postgres;