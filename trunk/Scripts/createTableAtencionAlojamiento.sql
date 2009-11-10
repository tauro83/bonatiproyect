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
  comentario character(500),
  diasEstadia int,
  eliminado boolean,

  CONSTRAINT atencionalojamiento_pkey PRIMARY KEY (fechaIngreso, fechaSalida, canil),
  CONSTRAINT atencionalojamiento_mascota_fkey FOREIGN KEY (cliente, mascota)
      REFERENCES mascota (rut, nombre) MATCH FULL
      ON UPDATE CASCADE ON DELETE SET NULL
) 