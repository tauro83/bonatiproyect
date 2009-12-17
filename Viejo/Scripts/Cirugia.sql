CREATE TABLE cirugia
(
  clienterut character(9) NOT NULL,
  mascotanombre character(50) NOT NULL,
  hora time without time zone NOT NULL,
  responsable character(20) NOT NULL,
  ayudante character(20) NOT NULL,
  fecha character(10) NOT NULL,
  costo character(20),
  estado integer DEFAULT 0,
  CONSTRAINT pk_cirugia PRIMARY KEY (mascotanombre, hora, clienterut, fecha),
  CONSTRAINT cirugia_ayudante_fkey FOREIGN KEY (ayudante)
      REFERENCES usuario (usuario) MATCH FULL
      ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT cirugia_clienterut_fkey FOREIGN KEY (clienterut)
      REFERENCES clientepresencial (rut) MATCH FULL
      ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT cirugia_responsable_fkey FOREIGN KEY (responsable)
      REFERENCES usuario (usuario) MATCH FULL
      ON UPDATE CASCADE ON DELETE RESTRICT
)