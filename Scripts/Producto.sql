CREATE TABLE producto
(
  nombre character(20),
  precio character(20),
  categoria character(20),
  codigo character(20) NOT NULL,
  descripcion character(50),
  CONSTRAINT producto_pkey PRIMARY KEY (codigo)
); 