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

## capitulo 4 : Logística de envíos
La empresa de transporte "United Package" tiene un registro de entradas oculto. ¿Cuántos pedidos han gestionado exactamente?
### Lo que se pide: Cuenta cuántos pedidos (Orders) han sido enviados por el transportista llamado 'United Package'.

## capitulo 5 : La bebida más exclusiva
 En la bodega, la puerta solo se abre si pronuncias el nombre de la bebida más cara del inventario.
### Lo que se pide: Encuentra el ProductName más caro que pertenezca a la categoría 'Beverages'.

## capitulo 6 :  Clientes metropolitanos 
 Dos ciudades clave en el mapa son Londres y Madrid. El sistema pide el número total de clientes en estas dos capitales.
 Lo que se pide: Cuenta cuántos clientes viven en 'London' o 'Madrid'.

 ## capitulo 7 :  El valor del botín
 Has encontrado el pedido 10248 de nuevo, pero ahora el sistema exige saber el valor monetario total de la mercancía, no solo la cantidad de cajas.
### Lo que se pide: Calcula la suma total del precio (Price * Quantity) para el pedido 10248.

## capitulo 8 : El cliente misterioso (El Jefe Final)
 Tienes el número de pedido 10248, pero el sistema exige el nombre de la empresa que lo compró. Cruzar datos es tu única salida.
 ### Lo que se pide: Muestra el nombre del cliente (CustomerName) que realizó el pedido 10248.


respuestas: El contacto británico
1- SELECT COUNT(*) FROM Products WHERE ProductName LIKE '%Chef%' AND Price > 20; .

2- SELECT ContactName FROM Suppliers WHERE City = 'Manchester' AND Country = 'UK';

3- SELECT LastName FROM Employees ORDER BY BirthDate DESC LIMIT 1;

4- SELECT COUNT(*) FROM Orders JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID WHERE ShipperName = 'United Package';

5- SELECT ProductName FROM Products JOIN Categories ON Products.CategoryID = Categories.CategoryID WHERE CategoryName = 'Beverages' ORDER BY Price DESC LIMIT 1;

6- SELECT COUNT(*) FROM Customers WHERE City IN ('London', 'Madrid');

7- SELECT SUM(OrderDetails.Quantity * Products.Price) FROM OrderDetails JOIN Products ON OrderDetails.ProductID = Products.ProductID WHERE OrderID = 10248;

8- SELECT CustomerName FROM Customers JOIN Orders ON Customers.CustomerID = Orders.CustomerID WHERE OrderID = 10248;

