## Entorno

Te encuentras en un almacén oscuro con cuatro armarios al fondo y una puerta corredera entre ellos.  
Frente a ti se encuentra un pequeño portátil con una terminal esperando a que introduzcas una clave.  
Una voz resuena por la megafonía sobre ti:

---

## Presentación (Diálogos)

> **"Bienvenido. Hace algún tiempo jugaste con las esperanzas de los demás usando tu talento…  
> y ahora, usando ese mismo talento, tendrás que jugar a mi juego."**

> **"Ante ti hay cuatro armarios, cada uno con una terminal. Dentro encontrarás fragmentos de la  
> verdad que intentaste ocultar. Solo realizando las consultas SQL correctas obtendrás las  
> cuatro partes de la clave.  
> Cuando las unas, podrás desbloquear la terminal principal y ejecutar la consulta final que  
> determinará si mereces salir de este almacén… o quedarte atrapado con tus pecados."**

> **"Tras escuchar este mensaje, el primer armario se abre y el juego comienza. Pero recuerda:  
> en el pasado no fallaste, no te apresuraste y no cometiste errores. Si aquí fuera igual,  
> ¿dónde se encontraría la diversión…? Por cada consulta que realices incorrectamente  
> recibirás un castigo, así que ándate con ojo…"**

---

## Contexto del jugador

El jugador era un trabajador en una gran empresa dedicada a la compra-venta de mercancías.  
Cada cierto periodo del año, la empresa enviaba parte del dinero de las ventas como donaciones a un hospital infantil.

Durante años, el jugador desvió parte del dinero destinado a esas donaciones hacia su propia cuenta personal,  
sin ser descubierto jamás. Las consecuencias de ese acto afectaron indirectamente a los niños que dependían de esa ayuda.

En este juego, deberá realizar consultas SQL relacionadas con el dinero en una base de datos diseñada para  
simular la de su antigua empresa. Solo reconstruyendo la verdad y completando correctamente las consultas podrá  
acercarse a la salida… o enfrentarse finalmente a sus propios actos.

---

## Consultas y Castigos

Cada consulta tiene **un primer intento sin castigo**.  
El jugador, basándose en una pista escrita en la pared del armario, deberá realizar la consulta para obtener el dato deseado.  
Puede hacer todas las pruebas que quiera, pero al confirmar una respuesta, si esta es incorrecta y ya ha usado su primer intento, aparecerá el siguiente diálogo:

> **"Veo que has cometido suficientes errores como para recibir tu primer castigo… pero no temas, aún te queda mucho por delante.  
> En este mismo instante se ha abierto un conducto que está desplazando lentamente el oxígeno del lugar donde te encuentras, lo que provocará que acabes muriendo por asfixia.  
> A partir de ahora vas contrarreloj, y cuantas más veces falles… más conductos comenzarán a succionar el oxígeno."**

De esta manera, el jugador tiene un primer intento en el que se permite fallar sin consecuencias.  
Pero si falla en un segundo intento, se activará un temporizador; y a medida que continúe fallando, el tiempo disponible se irá reduciendo.

También en caso de que el jugador pase de la primera consulta sin fallar, en el segundo terminal se mostrará:

>"Lo has hecho bien... Demasiado bien... Para que esto esté mas interesante, ¿Qué tal si aplicamos un poco de presión?
>Se acaba de abrir un respiradero que está trasladando lentamente el oxigeno del lugar donde te encuentras, lo que provocará que acabes muriendo de asfixia, así que a partir de ahora vas contra reloj y ahora ten cuidado con fallar... Puede que eso recorte tu tiempo..."

---

## Consultas:

1. En Julio de 1996 (1996-07), hubo un empleado que gestionó más órdenes que nadie. Necesito el ID de ese empleado.

SELECT EmployeeID
FROM Orders
WHERE OrderDate LIKE '1996-07%'
GROUP BY EmployeeID
ORDER BY COUNT(*) DESC
LIMIT 1;

respuesta: 4

2. ¿Cuál es la suma total de dinero generado por todos los productos de la categoría 'Dairy Products' (Lácteos)?

SELECT SUM(OrderDetails.Quantity * Products.Price)
FROM OrderDetails
JOIN Products ON OrderDetails.ProductID = Products.ProductID
JOIN Categories ON Products.CategoryID = Categories.CategoryID
WHERE Categories.CategoryName = 'Dairy Products';

respuesta: 69921.0

3. Calcula la suma total del precio (Price * Quantity) para el pedido 10248.

SELECT SUM(OrderDetails.Quantity * Products.Price) 
FROM OrderDetails 
JOIN Products 
ON OrderDetails.ProductID = Products.ProductID 
WHERE OrderID = 10248;

respuesta: 566.0 

4. Cuenta cuántos pedidos (Orders) han sido enviados por el transportista llamado 'United Package'.

SELECT COUNT(*) 
FROM Orders 
JOIN Shippers 
ON Orders.ShipperID = Shippers.ShipperID 
WHERE ShipperName = 'United Package';

respuesta: 74

## Uniendo todos los digitos de cada resultado de estas consultas se consigue el código de la terminal principal (46992156674).

5. Sumar el ID del Proveedor (SupplierID) con más productos en catálogo, multiplicado por el número total de pedidos del empleado 'Davolio'

SELECT (
    SELECT SupplierID 
    FROM Products 
    GROUP BY SupplierID 
    ORDER BY COUNT(*) 
    DESC LIMIT 1) * (
        SELECT COUNT(*) 
        FROM Orders 
        JOIN Employees 
        ON Orders.EmployeeID = Employees.EmployeeID 
        WHERE LastName = 'Davolio');

respuesta: 348

---

## Dialogos respecto a acciones:

Se acaba el tiempo (El jugador muere asfixiado):
>"Parece que no das la talla para salvar ninguna vida... Ya has sido juzgado en vida, ahora tus pecados serán juzgados en la siguiente..."

Se intenta introducir un código incorrecto en la terminal final:
>"Veo que no lo estas entendiendo, pero no te preocupes... Introduce todos los que quieras, los castigos se aplican en los retos de verdad..."

Se abre la puerta final y el jugador es libre:
>"Veo que lo has superado, una pena... Estaré observando tus acciones, nos vemos en el siguiente juego..."

---