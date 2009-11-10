CREATE TABLE catpeluqueria
(
  servicio character(20) NOT NULL,
  nombre character(20) NOT NULL,
  precio integer,
  descripcion character(160),
  estado boolean DEFAULT true,
  CONSTRAINT catpeluqueria_pkey PRIMARY KEY (servicio, nombre)
)