-- Database: "demoDB"

-- DROP DATABASE "demoDB";

CREATE DATABASE "demoDB"
  WITH OWNER = postgres
       ENCODING = 'SQL_ASCII'
       TABLESPACE = pg_default;

insert into asuntowebaviso(nombre)
values ('Compra');

insert into asuntowebaviso(nombre)
values ('Venta');

insert into asuntowebaviso(nombre)
values ('Cruza');

insert into asuntowebaviso(nombre)
values ('Regalo');