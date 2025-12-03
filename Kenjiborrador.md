
# IDEAS DE CONSULTAS.
-te dejo las ideas de consultas que busques y abajo lo que tendria que colocar para allarlo


### Lo que se pide: Cuenta cuántos productos cumplen ambas condiciones.
1- SELECT COUNT(*) FROM Products WHERE ProductName LIKE '%Chef%' AND Price > 20; .
respuesta : 2

### Lo que se pide: Muestra el ContactName del proveedor que está en la ciudad de 'Manchester' y el país 'UK'.
2- SELECT ContactName FROM Suppliers WHERE City = 'Manchester' AND Country = 'UK';
respuesta: Peter Wilson

### Lo que se pide: Muestra el apellido (LastName) del empleado con la fecha de nacimiento (BirthDate) más reciente.
3- SELECT LastName FROM Employees ORDER BY BirthDate DESC LIMIT 1;
respuesta: Dodsworth

### Lo que se pide: Cuenta cuántos pedidos (Orders) han sido enviados por el transportista llamado 'United Package'.
4- SELECT COUNT(*) FROM Orders JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID WHERE ShipperName = 'United Package';
respuesta: 74

### Lo que se pide: Encuentra el ProductName más caro que pertenezca a la categoría 'Beverages'.
5- SELECT ProductName FROM Products JOIN Categories ON Products.CategoryID = Categories.CategoryID WHERE CategoryName = 'Beverages' ORDER BY Price DESC LIMIT 1;
respuesta: Côte de Blaye

### Lo que se pide: Calcula la suma total del precio (Price * Quantity) para el pedido 10248.
7- SELECT SUM(OrderDetails.Quantity * Products.Price) FROM OrderDetails JOIN Products ON OrderDetails.ProductID = Products.ProductID WHERE OrderID = 10248;
respuesta: 566.0 

 ### Lo que se pide: Muestra el nombre del cliente (CustomerName) que realizó el pedido 10248.
8- SELECT CustomerName FROM Customers JOIN Orders ON Customers.CustomerID = Orders.CustomerID WHERE OrderID = 10248;
respuesta: Wilman Kala

### "Tenías clientes favoritos. Aquellos que compraban mucho y preguntaban poco. El cliente con ID 4 (Around the Horn)... necesito saber cuánto dinero gastó en total en nuestra empresa. Tendrás que buscar en sus pedidos y ver qué productos compró."
9-SELECT SUM(OrderDetails.Quantity * Products.Price) 
FROM Orders
JOIN OrderDetails ON Orders.OrderID = OrderDetails.OrderID
JOIN Products ON OrderDetails.ProductID = Products.ProductID
WHERE Orders.CustomerID = 4;
respuesta: 1723.75

###  ¿Cuál es la suma total de dinero generado por todos los productos de la categoría 'Dairy Products' (Lácteos)?"
10- SELECT SUM(OrderDetails.Quantity * Products.Price)
FROM OrderDetails
JOIN Products ON OrderDetails.ProductID = Products.ProductID
JOIN Categories ON Products.CategoryID = Categories.CategoryID
WHERE Categories.CategoryName = 'Dairy Products';

respuesta: 69921.0

### En Julio de 1996 (1996-07), hubo un empleado que gestionó más órdenes que nadie. Necesito el ID de ese empleado."
11- SELECT EmployeeID
FROM Orders
WHERE OrderDate LIKE '1996-07%'
GROUP BY EmployeeID
ORDER BY COUNT(*) DESC
LIMIT 1;

respuesta: 4

### ¿Cuánto dinero EXACTO se generó de clientes de USA? Si fallas en este cálculo, el aire se acabará antes de que puedas gastarlo."
12- SELECT SUM(OrderDetails.Quantity * Products.Price)
FROM Customers
JOIN Orders ON Customers.CustomerID = Orders.CustomerID
JOIN OrderDetails ON Orders.OrderID = OrderDetails.OrderID
JOIN Products ON OrderDetails.ProductID = Products.ProductID
WHERE Customers.Country = 'USA';

respuesta:

### Encuentra el nombre del producto que NUNCA ha aparecido en una orden de pedido.
13- SELECT ProductName 
FROM Products 
WHERE ProductID NOT IN (SELECT ProductID FROM OrderDetails);

respuesta:

### Si sumas el ID del Proveedor (SupplierID) con más productos en catálogo, multiplicado por el número total de pedidos del empleado 'Davolio'... obtendrás el código de escape.
14- SELECT 
  (SELECT SupplierID FROM Products GROUP BY SupplierID ORDER BY COUNT(*) DESC LIMIT 1) 
  * (SELECT COUNT(*) FROM Orders JOIN Employees ON Orders.EmployeeID = Employees.EmployeeID WHERE LastName = 'Davolio');

respuesta: 
