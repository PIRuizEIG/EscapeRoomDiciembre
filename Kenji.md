# Mi lado
##  borador de como van a ir las consultas y lo que tendra que meter
### Nivel 1:
capitulo uno : Búsqueda Directa
Narrativa: La puerta del primer armario se abre con un chirrido metálico. Dentro no hay nada más que una foto de una antigua compañera de trabajo clavada en la pared. Debajo, una nota:


"Ella sospechaba, ¿verdad? Janet... Siempre revisando los registros. Tuviste que aprenderte su ID de memoria para borrar tus huellas antes de que ella entrara al sistema. Demuéstrame que aún recuerdas a quién vigilabas."


**Lo que se pide: El sistema solicita el apellido del empleado con el número de identificación 3 (Janet).**


capitulo dos: El Segundo Armario - "La Codicia"


Narrativa: Al introducir el apellido correcto, el segundo armario se desbloquea. Dentro hay una botella de vino vacía y una etiqueta de precio arrancada.


"No robabas por necesidad. Robabas por gusto. Te encantaba la buena vida, los productos exclusivos... Había un artículo en particular, el más caro de todo el catálogo, que siempre quisiste probar con el dinero de los niños. ¿Recuerdas su nombre?"


**Lo que se pide: Encuentra el nombre del producto (ProductName) con el precio más alto (Price) de toda la base de datos.**


capitulo tres: El Tercer Armario - "El Lavado de Dinero"


Narrativa: El tercer armario se abre de golpe. Un mapa de México cae al suelo. Está marcado con rotulador rojo.


"Para sacar el dinero sin levantar sospechas, usaste cuentas falsas en el extranjero. México fue tu paraíso fiscal preferido durante aquella operación. ¿Cuántas cuentas 'fantasma' (clientes) creaste en ese país para desviar los fondos?"


**Lo que se pide: Cuenta el número total de clientes (Customers) cuyo país (Country) sea 'Mexico'.**


capitulo cuatro: El Cuarto Armario - "El Transporte Fantasma"


Narrativa: El último armario se abre lentamente. Dentro hay un uniforme de repartidor lleno de polvo de la empresa 'United Package'.


"No podías mover el dinero físico tú solo. Usaste a la empresa de transportes 'United Package' para mover la mercancía que luego revenderías. Ellos no sabían que eran tus cómplices. ¿Cuántos envíos (pedidos) ensuciaste con sus manos?"


**Lo que se pide: Calcula cuántos pedidos (Orders) fueron gestionados por el transportista (ShipperName) llamado 'United Package'. (Pista: Necesitas unir las tablas Orders y Shippers).**


capitulo final :La Terminal Principal - "La Sentencia"


Narrativa: Con los cuatro fragmentos obtenidos, la pantalla del portátil central se ilumina en rojo. La voz suena más grave ahora.


"Tienes las piezas. Leverling te vigilaba, tu codicia por el Côte de Blaye te impulsó, usaste 5 cuentas en México y corrompiste 74 envíos de United Package...


Pero hay un pecado final. El Pedido 10248. Ese fue el envío destinado a la donación anual del hospital. Lo desviaste entero a tu cuenta. Si de verdad quieres salir de aquí, dime... ¿Exactamente cuánto dinero (Precio × Cantidad) le robaste a esos niños en ese único pedido? Calcúlalo. Y reza para que la cifra sea exacta."


**Lo que se pide: Calcula la suma total del dinero de todos los productos dentro del Pedido (OrderID) 10248. (Debe multiplicar Precio por Cantidad de cada línea y sumarlo todo).**




## respuesta
1 -SELECT LastName FROM Employees WHERE EmployeeID = 3;
2-SELECT ProductName FROM Products ORDER BY Price DESC LIMIT 1;
3-SELECT COUNT(*) FROM Customers WHERE Country = 'Mexico';
4-SELECT COUNT(*) FROM Orders
JOIN Shippers ON Orders.ShipperID = Shippers.ShipperID
WHERE ShipperName = 'United Package';
5-SELECT SUM(OrderDetails.Quantity * Products.Price)
FROM OrderDetails
JOIN Products ON OrderDetails.ProductID = Products.ProductID
WHERE OrderID = 10248;
