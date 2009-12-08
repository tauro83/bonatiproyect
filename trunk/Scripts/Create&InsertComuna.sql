CREATE TABLE comuna
(
  nombre character(50) NOT NULL,
  numregion integer,
  nombreregion character(60),
  CONSTRAINT id PRIMARY KEY (nombre, numregion)
) ;

INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Alto Hospicio', '1', 'Región de Tarapacá');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Camiña', '1', 'Región de Tarapacá');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Colchane', '1', 'Región de Tarapacá');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Huara', '1', 'Región de Tarapacá');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Iquique', '1', 'Región de Tarapacá');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Pica', '1', 'Región de Tarapacá');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Pozo Almonte', '1', 'Región de Tarapacá');

INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Antofagasta', '2', 'Region de Antofagasta');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Calama', '2', 'Región de Antofagasta');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Sierra Gorda', '2', 'Región de Antofagasta');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Taltal', '2', 'Región de Antofagasta');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Ollagüe', '2', 'Región de Antofagasta');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('San Pedro de Atacama', '2', 'Región de Antofagasta');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('María Elena', '2', 'Región de Antofagasta');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Tocopilla', '2', 'Región de Antofagasta');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Mejillones', '2', 'Región de Antofagasta');

INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Chañaral', '3', 'Región de Atacama');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Diego de Almagro', '3', 'Región de Atacama');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Copiapó', '3', 'Región de Atacama');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Tierra Amarilla', '3', 'Región de Atacama');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Alto del Carmen', '3', 'Región de Atacama');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Freirina', '3', 'Región de Atacama');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Huasco', '3', 'Región de Atacama');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Vallenar', '3', 'Región de Atacama');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Caldera', '3', 'Región de Atacama');

INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Canela', '4', 'Región de Coquimbo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Illapel', '4', 'Región de Coquimbo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Los Vilos', '4', 'Región de Coquimbo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Salamanca', '4', 'Región de Coquimbo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Andacollo', '4', 'Región de Coquimbo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Coquimbo', '4', 'Región de Coquimbo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('La Higuera', '4', 'Región de Coquimbo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('La Serena', '4', 'Región de Coquimbo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Paihuano', '4', 'Región de Coquimbo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Vicuña', '4', 'Región de Coquimbo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Combarbalá', '4', 'Región de Coquimbo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Monte Patria', '4', 'Región de Coquimbo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Ovalle', '4', 'Región de Coquimbo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Punitaqui', '4', 'Región de Coquimbo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Río Hurtado', '4', 'Región de Coquimbo');

INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Los Andes', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('San Esteban', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Calle Larga', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Rinconada', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Isla de Pascua', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Petorca', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('La Ligua', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Cabildo', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Papudo', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Zapallar', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('San Antonio', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Algarrobo', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Cartagena', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('El Quisco', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('El Tabo', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Santo Domingo', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('San Felipe', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Catemu', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Llay Llay', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Panquehue', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Putaendo', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Santa María', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Quillota', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Calera', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Hijuelas', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Limache', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('La Cruz', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Nogales', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Olmúe', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Valparaíso', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Casablanca', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Concon', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Juan Fernández', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Puchuncaví', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Quilpué', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Quintero', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Villa Alemana', '5', 'Región de Valparaíso');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Viña del Mar', '5', 'Región de Valparaíso');

INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Rancagua', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Codegua', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Coinco', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Coltauco', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Doñihue', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Graneros', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Las Cabras', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Mostazal', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Machalí', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Malloa', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Olivar', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Peumo', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Pichidegua', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Quinta de Tilcoco', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Rengo', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Requinoa', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('San Vicente', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('San Fernando', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Chépica', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Chimbarongo', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Lolol', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Nancagua', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Palmilla', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Peralillo', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Placilla', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Pumanque', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Santa Cruz', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Pichilemu', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('La Estrella', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Litueche', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Marchigue', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Navidad', '6', 'Región Del Libertador Bernardo OHiggins');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Paredones', '6', 'Región Del Libertador Bernardo OHiggins');

INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Cauquenes', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Pelluhue', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Chanco', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Curicó', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Teno', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Romeral', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Molina', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Sagrada Familia', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Hualañe', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Licantén', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Vichuquén', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Rauco', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Linares', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Yerbas Buenas', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Colbún', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Longaví', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Parral', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Retiro', '7', 'Regióndel Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Villa Alegre', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('San Javier', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Talca', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Pelarco', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Río Claro', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('San Clemente', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Maule', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('San Rafael', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Empedrado', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Pencahue', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Constitución', '7', 'Región del Maule');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Curepto', '7', 'Región del Maule');

INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Arauco', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Cañete', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Contulmo', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Curanilahue', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Lebu', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Los Alamos', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Tirua', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Los Angeles', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Alto Bío-Bío', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Antuco', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Cabrero', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Laja', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Mulchín', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Nacimiento', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Negrete', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Quilaco', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Quilleco', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Santa Bárbara', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('San Rosendo', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Tucapel', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Yumbel', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Concepción', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Chiguayante', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Coronel', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Florida', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Hualpín', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Hualqui', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Lota', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Penco', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('San Pedro de la Paz', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Santa Juana', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Talcahuano', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Tomé', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Chillán', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Bulnes', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Chillán Viejo', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Cobquecura', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Coelemu', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Coihueco', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('El Carmen', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Ninhue', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Ñiquén', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Pemuco', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Pinto', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Portezuelo', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Quillón', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Quirihue', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Ranquil', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('San Carlos', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('San Fabián', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('San Ignacio', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('San Nicolás', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Trehuaco', '8', 'Región del Bío Bío');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Yungay', '8', 'Región del Bío Bío');

INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Temuco', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Carahue', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Cholchol', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Cunco', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Curarrehue', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Freire', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Galvarino', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Gorbea', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Lautaro', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Loncoche', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Melipeuco', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Nueva Imperial', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Padre las Casas', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Perquenco', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Pitrufquén', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Pucón', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Saavedra', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Teodoro Schmidt', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Toltén', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Vilcún', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Villarrica', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Angol', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Collipulli', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Curacautín', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Ercilla', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Lonquimay', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Los Sauces', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Lumaco', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Purén', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Renaico', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Traiguén', '9', 'Región de la Araucanía');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Victoria', '9', 'Región de la Araucanía');

INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Chiloé', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Ancud', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Castro', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Chonchi', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Curaco de Vélez', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Dalcahue', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Puqueldón', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Queilén', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Quellón', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Quemchi', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Quinchao', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Calbuco', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Cochamó', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Fresia', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Frutillar', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Los Muermos', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Llanquihue', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Maullín', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Puerto Montt', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Puerto Varas', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Osorno', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Puerto Octay', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Purranque', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Puyehue', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Río Negro', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('San Juan de la Costa', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('San Pablo', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Chaitén', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Futaleufú', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Hualaihué', '10', 'Región de los Lagos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Palena', '10', 'Región de los Lagos');

INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Aisén', '11', 'Región de Aisén del General Carlos Ibáñez del Campo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Cisnes', '11', 'Región de Aisén del General Carlos Ibáñez del Campo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Guaitecas', '11', 'Región de Aisén del General Carlos Ibáñez del Campo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Cochrane', '11', 'Región de Aisén del General Carlos Ibáñez del Campo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('OHiggins', '11', 'Región de Aisén del General Carlos Ibáñez del Campo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Tortel', '11', 'Región de Aisén del General Carlos Ibáñez del Campo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Coihaique', '11', 'Región de Aisén del General Carlos Ibáñez del Campo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Lago Verde', '11', 'Región de Aisén del General Carlos Ibáñez del Campo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Río Ibáñez', '11', 'Región de Aisén del General Carlos Ibáñez del Campo');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Chile Chico', '11', 'Región de Aisén del General Carlos Ibáñez del Campo');

INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Cabo de Hornos', '12', 'Región de Magallanes y Antártica Chilena');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Antártica', '12', 'Región de Magallanes y Antártica Chilena');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Punta Arenas', '12', 'Región de Magallanes y Antártica Chilena');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Río Verde', '12', 'Región de Magallanes y Antártica Chilena');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Laguna Blanca', '12', 'Región de Magallanes y Antártica Chilena');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('San Gregorio', '12', 'Región de Magallanes y Antártica Chilena');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Porvenir', '12', 'Región de Magallanes y Antártica Chilena');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Primavera', '12', 'Región de Magallanes y Antártica Chilena');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Timaukel', '12', 'Región de Magallanes y Antártica Chilena');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Natales', '12', 'Región de Magallanes y Antártica Chilena');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Torres del Paine', '12', 'Región de Magallanes y Antártica Chilena');

INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Colina', '14', 'Región Metropolitana');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Lampa', '14', 'Región Metropolitana');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Til Til', '14', 'Región Metropolitana');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Puente Alto', '14', 'Región Metropolitana');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Pirque', '14', 'Región Metropolitana');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('San José de Maipo', '14', 'Región Metropolitana');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Buin', '14', 'Región Metropolitana');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Calera de Tango', '14', 'Región Metropolitana');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Paine', '14', 'Región Metropolitana');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('San Bernardo', '14', 'Región Metropolitana');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Melipilla', '14', 'Región Metropolitana');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('María Pinto', '14', 'Región Metropolitana');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Curacaví', '14', 'Región Metropolitana');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Alhué', '14', 'Región Metropolitana');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('San Pedro', '14', 'Región Metropolitana');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Santiago', '14', 'Región Metropolitana');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Talagante', '14', 'Región Metropolitana');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('El Monte', '14', 'Región Metropolitana');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Isla de Maipo', '14', 'Región Metropolitana');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Padre Hurtado', '14', 'Región Metropolitana');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Peñaflor', '14', 'Región Metropolitana');

INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('La Unión', '14', 'Región de los Ríos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Futrono', '14', 'Región de los Ríos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Lago Ranco', '14', 'Región de los Ríos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Río Bueno', '14', 'Región de los Ríos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Valdivia', '14', 'Región de los Ríos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Corral', '14', 'Región de los Ríos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Lanco', '14', 'Región de los Ríos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Los Lagos', '14', 'Región de los Ríos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Mafil', '14', 'Región de los Ríos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Mariquina', '14', 'Región de los Ríos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Paillaco', '14', 'Región de los Ríos');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Panguipulli', '14', 'Región de los Ríos');

INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Arica', '15', 'Región de los Arica y Parinacota');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Camarones', '15', 'Región de los Arica y Parinacota');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('Putre', '15', 'Región de los Arica y Parinacota');
INSERT INTO comuna(
            nombre, numregion, nombreregion)
    VALUES ('General Lagos', '15', 'Región de los Arica y Parinacota');