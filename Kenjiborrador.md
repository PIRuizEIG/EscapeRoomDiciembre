## capitulo 1 : El ingrediente secreto
El chef de la mansión ha escondido la llave en un producto de su colección personal.
Busca productos que contengan la palabra "Chef" en su nombre, pero solo aquellos que cuesten más de 20.
### Lo que se pide: Cuenta cuántos productos cumplen ambas condiciones.

## capitulo 2 : El contacto británico 
Un telegrama interceptado menciona un contacto en "Manchester, UK".
Necesitas el nombre de la persona de contacto de ese proveedor para descifrar el mensaje.
### Lo que se pide: Muestra el ContactName del proveedor que está en la ciudad de 'Manchester' y el país 'UK'.

## capitulo 3 : El recluta más joven
El sistema biométrico solo responde al empleado más joven de la plantilla. Debes identificar su apellido.
### Lo que se pide: Muestra el apellido (LastName) del empleado con la fecha de nacimiento (BirthDate) más reciente.

## capitulo 4 : 







respuestas: El contacto británico
1- SELECT COUNT(*) FROM Products WHERE ProductName LIKE '%Chef%' AND Price > 20; .
2- SELECT ContactName FROM Suppliers WHERE City = 'Manchester' AND Country = 'UK';
3- SELECT LastName FROM Employees ORDER BY BirthDate DESC LIMIT 1;
4- 
