CREATE TABLE serviciopeluq
(
  nombre character(20) NOT NULL,
  CONSTRAINT pkey_serviciopeluq PRIMARY KEY (nombre)
)

INSERT INTO serviciopeluq(nombre)
VALUES ('Baño');
INSERT INTO serviciopeluq(nombre)
VALUES ('Corte');
