-- Database: "demoDB"

-- DROP DATABASE "demoDB";

CREATE DATABASE "demoDB"
  WITH OWNER = postgres
       ENCODING = 'SQL_ASCII'
       TABLESPACE = pg_default;

CREATE TABLE ASUNTOWEBAVISO
(
	nombre Char (30) not null

);