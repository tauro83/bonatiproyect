drop table IF EXISTS Raza;
drop table IF EXISTS Especie;
drop table IF EXISTS Cargo;
drop table IF EXISTS Servicio;
drop table IF EXISTS Vacuna;

CREATE TABLE Especie
(
	nombre	CHAR(20) primary key
);

CREATE TABLE Raza
(
	nombre char(20) primary key,
	especie char(20),
	FOREIGN KEY (especie) REFERENCES Especie(nombre) 	
);

CREATE TABLE Cargo
(
	nombre	CHAR(20) primary key
);

CREATE TABLE Servicio
(
	nombre	CHAR(20) primary key
);

CREATE TABLE Vacuna
(
	nombre	CHAR(20) primary key,
	precio  int,
	caducidad date,
	descripcion CHAR(50)
	
);
