create table Mascota(
	rut character(8 ),
	nombre character(50),
	fechanacimiento character(10),
	claseanimal character(50),
	raza character(50),
	sexo character(10),
	estado bool,
	imagen bytea NOT NULL,
	CONSTRAINT pk_mascota PRIMARY KEY (rut, nombre),
	CONSTRAINT fk_mascota_reference_ClientePresencial FOREIGN KEY (rut)
	REFERENCES ClientePresencial(rut) MATCH SIMPLE ON UPDATE RESTRICT ON DELETE RESTRICT
)

