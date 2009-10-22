create table Usuario (
	nombre	CHAR(20),
	aPaterno CHAR(20),
	aMaterno CHAR(20),
	usuario  CHAR(20) not null,
	cargo	char(20),
	contrasena	char(20),
	servicio	char(20),
	pRegistrar	bool,
	pEditar		bool,
	pEliminar	bool,
	pPurgar		bool,	
	estado bool,
   constraint PK_usuario primary key (usuario)
);



