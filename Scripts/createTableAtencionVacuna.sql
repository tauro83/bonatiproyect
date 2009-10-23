create table atencionvacuna(
	precio character(15),
	nombre character(50),
	descripcion character(100),
	fechacaducidad date,
	servicio character varying(20) NOT NULL DEFAULT 'Pabellon'::character varying,
	hora character(10),
	fecha date NOT NULL,
	costo character(50),
	CONSTRAINT atencionvacuna_pkey PRIMARY KEY (nombre, hora, fecha, servicio)
);