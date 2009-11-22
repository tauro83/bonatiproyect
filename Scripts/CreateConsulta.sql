CREATE TABLE consulta
(
  anamnesis character(300),
  servicio character(20) NOT NULL,
  hora character(20) NOT NULL,
  fecha character(20) NOT NULL,
  costo character(50),
  rut character(9),
  nombre character(20),
  responsable character(20),
  CONSTRAINT consulta_pkey PRIMARY KEY (hora, fecha, servicio),
  CONSTRAINT consulta_rut_fkey FOREIGN KEY (rut, nombre)
      REFERENCES mascota (rut, nombre) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
); 