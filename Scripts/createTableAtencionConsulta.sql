create table atencionconsulta(
	anamnesis character(100),
	servicio character varying(20) NOT NULL DEFAULT 'Pabellon'::character varying,
	hora character(10),
	fecha date NOT NULL,
	costo character(50),
	CONSTRAINT atencionconsulta_pkey PRIMARY KEY (hora, fecha, servicio)
);