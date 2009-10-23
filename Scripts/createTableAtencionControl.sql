create table atencioncontrol(
	descripcion character(100),
	recomendacion character(50),
	proximafecha date,
	servicio character varying(20) NOT NULL DEFAULT 'Pabellon'::character varying,
	hora character(10),
	fecha date NOT NULL,
	costo character(50),
	CONSTRAINT atencioncontrol_pkey PRIMARY KEY (hora, fecha, servicio)
);