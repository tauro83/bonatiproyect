/*Consulta SQL pago*/

UPDATE pago  SET fecha=?, hora=?, estado=?, total=?
 WHERE fecha=? AND hora=?;
