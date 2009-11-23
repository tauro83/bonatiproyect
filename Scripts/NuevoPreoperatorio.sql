- Table: preoperatorio

-- DROP TABLE preoperatorio;

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
  CONSTRAINT pk_preoperatorio PRIMARY KEY (rut, fecha, hora)
) 
WITHOUT OIDS;
ALTER TABLE preoperatorio OWNER TO postgres1;
