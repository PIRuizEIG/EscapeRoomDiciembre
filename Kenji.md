# Mi lado 
##  borador de como van a ir las consultas y lo que tendra que meter
### Nivel 1: Búsqueda Directa (Calentamiento)
1. Clientes en el extranjero Contexto: Un mapa de México cuelga en la pared. ¿Cuántos de nuestros clientes operan desde ese país?

Lo que se pide: Cuenta cuántos clientes son de 'Mexico'.

Lo que tiene que introducir: SELECT COUNT(*) FROM Customers WHERE Country = 'Mexico';

Resultado: 5

2. Identificación del proveedor Contexto: Encuentras una factura del Proveedor número 1. Necesitas el nombre de la persona de contacto para verificar su identidad.

Lo que se pide: Muestra el ContactName del proveedor con SupplierID = 1.

Lo que tiene que introducir: SELECT ContactName FROM Suppliers WHERE SupplierID = 1;

Resultado: Charlotte Cooper

3. El personal de confianza Contexto: El sistema de seguridad pide el apellido del empleado número 3.

Lo que se pide: Muestra el LastName del empleado con EmployeeID = 3.

Lo que tiene que introducir: SELECT LastName FROM Employees WHERE EmployeeID = 3;

Resultado: Leverling

🟡 Nivel 2: Filtros y Lógica (El Puente)
4. Rango de precios Contexto: La siguiente puerta requiere saber cuántos productos tienen un precio "medio". Ni muy baratos ni muy caros (más de 20 y menos de 50).

Lo que se pide: Cuenta los productos cuyo precio sea mayor a 20 Y menor a 50.

Lo que tiene que introducir: SELECT COUNT(*) FROM Products WHERE Price > 20 AND Price < 50;

Resultado: 30

5. El artículo de lujo Contexto: Para desbloquear la caja fuerte, debes introducir el nombre del producto más caro de todo el catálogo.

Lo que se pide: Encuentra el ProductName del producto con el precio más alto.

Lo que tiene que introducir: SELECT ProductName FROM Products ORDER BY Price DESC LIMIT 1;

Resultado: Côte de Blaye

6. Socios internacionales Contexto: El sistema busca proveedores en dos potencias tecnológicas: USA y Japón. ¿Cuántos tenemos en total sumando ambos países?

Lo que se pide: Cuenta los proveedores que sean de 'USA' o 'Japan'.

Lo que tiene que introducir: SELECT COUNT(*) FROM Suppliers WHERE Country IN ('USA', 'Japan');

Resultado: 6

🔴 Nivel 3: Experto (Cruces y Cálculos)
7. El origen del té Contexto: Encuentras una caja de té etiquetada como "Chais". El sistema te pregunta a qué categoría pertenece este producto exacto.

Lo que se pide: Muestra el CategoryName del producto llamado 'Chais'.

Lo que tiene que introducir: SELECT CategoryName FROM Categories JOIN Products ON Categories.CategoryID = Products.CategoryID WHERE ProductName = 'Chais';

Resultado: Beverages (Nota: Aquí el jugador aprende que para saber el nombre de la categoría, tiene que unir las dos tablas).

8. La flota de transporte Contexto: La empresa de envíos "United Package" es clave para la huida. ¿Cuántos pedidos han movido en total?

Lo que se pide: Cuenta los pedidos transportados por 'United Package'.

Lo que tiene que introducir: SELECT COUNT(*) FROM Orders JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID WHERE ShipperName = 'United Package';

Resultado: 74

9. El valor del botín (Jefe Final) Contexto: Tienes el pedido 10248. Calcula cuánto dinero generó esa venta (cantidad * precio de cada ítem).

Lo que se pide: Suma total del valor del pedido 10248.

Lo que tiene que introducir: SELECT SUM(OrderDetails.Quantity * Products.Price) FROM OrderDetails JOIN Products ON OrderDetails.ProductID = Products.ProductID WHERE OrderID = 10248;

Resultado: 566.0
