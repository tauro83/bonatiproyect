create table atencioncontrol(
	cliente character(9),
	mascota character(30),
	descripcion character(500),
	fecha date NOT NULL,
	hora character(10) NOT NULL,
	responsable character(30),
	servicio character (20),
	costo character(7),
	CONSTRAINT atencioncontrol_pkey PRIMARY KEY (hora, fecha, responsable),
	CONSTRAINT atencioncontrol_usuario_fkey FOREIGN KEY (responsable)
		REFERENCES usuario (usuario) MATCH FULL
		ON UPDATE CASCADE ON DELETE RESTRICT,
	CONSTRAINT atencioncontrol_mascota_fkey FOREIGN KEY (cliente, mascota)
		REFERENCES mascota (rut, nombre) MATCH FULL
		ON UPDATE CASCADE ON DELETE RESTRICT
);