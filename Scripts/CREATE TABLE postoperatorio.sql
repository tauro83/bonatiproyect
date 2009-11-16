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
  estado integer,
  CONSTRAINT pk_postoperatorio PRIMARY KEY (idpostoperatorio, fecha, hora)
)

INSERT INTO postoperatorio(idpostoperatorio,observaciones,sintomas,diagnostico,fecha,hora,clienterut,mascotanombre,responsable,alimento,medicamento,ayudante,estado)
VALUES('1','observaciones del postoperatorio','síntomas que tiene la mascota','diagnóstico dela mascota','01/09/09','12:30:00','162989243','Estela','','','','','1');
