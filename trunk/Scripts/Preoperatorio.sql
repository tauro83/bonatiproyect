CREATE TABLE preoperatorio
(
  observaciones character(50),
  sintomas character(50),
  diagnostico character(30),
  servicio character(20) NOT NULL,
  hora character(7) NOT NULL,
  fecha character(10) NOT NULL,
  rut character(20),
  nombremascota character(20),
  raza character(20),
  sexo character(20),
  nombre character(20),
  apellidopaterno character(20),
  CONSTRAINT keys PRIMARY KEY (servicio, hora, fecha)
); 
