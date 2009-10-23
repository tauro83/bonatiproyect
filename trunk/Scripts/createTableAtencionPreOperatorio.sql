create table atencionpreoperatorio(
	observaciones character(100),
	sintomas character(100),
	diagnosticos character(100),
	servicio character varying(20) NOT NULL DEFAULT 'Pabellon'::character varying,
	hora character(10),
	fecha date NOT NULL,
	costo character(50),
	CONSTRAINT atencionpreoperatorio_key PRIMARY KEY (hora, fecha, servicio)
);