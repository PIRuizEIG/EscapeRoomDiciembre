# 🗝️ Escape Room SQL – Diciembre (EIG Málaga)

**EscapeRoomDiciembre** es un proyecto creado como ejercicio práctico de bases de datos para la Escuela Internacional de Gerencia (EIG) de Málaga.  
El objetivo es resolver una serie de retos SQL dentro de un escape room narrativo, donde cada consulta correcta desbloquea una parte del camino hacia la salida… y cada error tiene consecuencias.

Este proyecto combina:

- 🧩 *Consultas SQL complejas (mínimo 5)*
- 🎭 *Narrativa interactiva y ambientación tipo escape room*
- 💻 *Lectura de datos mediante JSON*
- ⚙️ *Lógica en Java con formato de consola estilizado*

---

## 🎮 Sinopsis del Juego

Te despiertas encerrado en un almacén oscuro.  
Cuatro armarios, cada uno con una terminal, guardan fragmentos de una clave oculta.  
Una voz te observa. Te juzga. Te pone a prueba.  

Para escapar deberás:

1. Acceder a cada terminal.
2. Realizar correctamente la consulta SQL asignada.
3. Obtener cada fragmento del código final.
4. Desbloquear la terminal principal.
5. Resolver el desafío definitivo…

Pero cuidado: cada error cuesta un dedo.  
Y sin dedos… no podrás activar más terminales.

---

## 🧠 Objetivo Didáctico

Este proyecto evalúa:

- Diseño y análisis de consultas SQL complejas  
- Uso de joins, agrupaciones y funciones agregadas  
- Filtrado y análisis de datos reales  
- Integración de SQL con Java  
- Lectura y parseo de archivos JSON  
- Control de flujo y narrativa interactiva  

---

## 📦 Requisitos Técnicos

### **Tecnologías utilizadas**

- **Java**
- **Gson 2.13.1** (para lectura de JSON)
- **Base de datos SQL de W3Schools con copia en Browser for SQLite** (Base de datos: [W3Schools](https://www.w3schools.com/Sql))
- **Consola con soporte ANSI** (colores y formato)
- Archivo JSON para los mensajes del juego

---

## ▶️ Cómo ejecutar el juego

1. Tener instalado **Java 17 o superior**.  
2. Clonar el repositorio de git
3. Compilar y Ejecutar la clase principal

---

## 📘 Archivo JSON (game_data.json)

El juego carga toda su narrativa desde un archivo JSON.
Cada elemento incluye:

```JSON
{
  "description": "Texto mostrado al jugador",
  "formatoTexto": "Negrita | Cursiva | Normal | ...",
  "colorTexto": "TextoRojo | TextoBlanco | ...",
  "fondoTexto": "FondoNegro | ...",
  "needsAnswer": true,
  "answer": "RespuestaCorrecta",
  "success": "Mensaje al acertar"
}
```

Este sistema permite modificar y ampliar la historia sin tocar el código Java.

---

## ✨ Características destacadas

- 🎨 Texto con colores, efectos y formatos personalizados en consola
- 📄 Sistema de diálogos cargado desde JSON
- 🧩 Retos progresivos con narrativa inmersiva
- 💀 Mecánica de penalización por errores (dedos perdidos)
- 🔐 Puzzle final uniendo todas las respuestas
- 🛠️ Código modular y fácilmente ampliable

---

## 👥 Autores

Proyecto desarrollado por:

- Pablo Illescas
- Kenji Ricaldi
- Alejandro Sánchez

Asignatura: Bases de Datos
