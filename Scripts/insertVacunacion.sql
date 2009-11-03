INSERT INTO Vacuna(nombre,precio,caducidad,descripcion)
VALUES('Triple','5000','4','');

INSERT INTO Vacuna(nombre,precio,caducidad,descripcion)
VALUES('Refuerzo de Triple','5000','4','');

INSERT INTO Vacuna(nombre,precio,caducidad,descripcion)
VALUES('Parvovirus','5000','4','');

INSERT INTO Vacunacion(vacuna, clienterut, mascotanombre, hora, responsable, fecha, costo, fechacaducidad, descripcion)
VALUES 	('Coronavirus', '16298923', 'Aguja','14:50:23','cbonati','10/28/2009', '2200', '12/28/2009', 'La mascota presenta la edad suficiente para administrar esta vacuna.');

INSERT INTO Vacunacion(vacuna, clienterut, mascotanombre, hora, responsable, fecha, costo, fechacaducidad, descripcion)
VALUES 	('Parvovirus', '16298923', 'Aguja','14:50:23','cbonati','10/28/2009', '5000', '12/28/2009', 'La mascota presenta la edad suficiente para administrar esta vacuna.');

INSERT INTO Vacunacion(vacuna, clienterut, mascotanombre, hora, responsable, fecha, costo, fechacaducidad, descripcion)
VALUES 	('Octuple', '16298923', 'Boby','10:35:12','cbonati','10/22/2009','9000','01/01/2010','Vacunado correctamente.');

INSERT INTO Vacunacion(vacuna, clienterut, mascotanombre, hora, responsable, fecha, costo, fechacaducidad, descripcion)
VALUES 	('Triple', '16298923', 'Boby','10:35:12','cbonati','10/22/2009','5000','01/01/2010','Vacunado correctamente.');

INSERT INTO Vacunacion(vacuna, clienterut, mascotanombre, hora, responsable, fecha, costo, fechacaducidad, descripcion)
VALUES 	('Refuerzo de Triple', '16298925', 'Larry2','19:22:01','cbonati','07/09/2009','5000','12/07/2009','En 3 mese debe volver a vacunar.');