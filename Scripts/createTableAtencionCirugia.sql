create table atencioncirugia (
	estado boolean,
	diagnostico character(100),
	tipo character(50),
	servicio character varying(20) NOT NULL DEFAULT 'Pabellon'::character varying,
	hora character(10),
	fecha date NOT NULL,
	costo character(50),
	CONSTRAINT atencioncirugia_pkey PRIMARY KEY (hora, fecha, servicio)
);