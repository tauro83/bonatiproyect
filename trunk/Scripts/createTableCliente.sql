CREATE TABLE cliente
(
  nombre character(12),
  apellido character(12),
  apellido2 character(12),
  rut character(9) NOT NULL,
  telefono character(3),
  telefono2 character(10),
  celular character(2),
  celular2 character(10),
  direccion character(30),
  region character(20),
  comuna character(20),
  email character(40),
  CONSTRAINT cliente_pkey PRIMARY KEY (rut)
) ;