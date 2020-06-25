  
# Hospitales
This is a coding test for [*Digital Harbor*](https://www.digitalharbor.com/)

**Tecnologías del Backend**
El backend fué desarrollado con JPA y Spring Boot para lo cual se necesitan los siguientes requisitos:

 - **Java SDK v14**.- Kit de desarrollo de Java.
 - **Visual Studio Code**.- Editor de código que permitirá correr la aplicación de backend.

**Database**
Se utilizó el motor de base de datos MySQL.

 **Tecnologías del Frontend**
 El frontend fué desarrollado con el framework Javascript Angular 8, y se agregaron algunas herramientas para una mejor User experience:
 
  - **Visual Studio Code**.- Editor de código que permitirá correr la aplicación de backend.
 - **SweetAlert**.- Sirve para lanzar alertas de confirmación, errores, mensajes y modales de inputs.
 - **Bootstrap**.- Ayuda al dar un mejor aspecto y colores agradables a la interfaz con algunos componentes, botones, menús , etc.
 -  **Nodejs**.- Permite la instalación de componentes a través del gestor npm y que es necesario para la instalación.

**Instrucciones**

 - Después de clonar o descargar el código fuente, de debe crear la base de datos hospital en MySQL y correr el script hospital.sql de la carpeta scriptBase.
 - El backend puede ejecutarse en VS Code, para eso debe abrir el archivo de configuración application.properties de la carpeta \backend\src\main\resources y configurar el usuario y password de la base de datos hopital, posteriormente abrir el archivo: Application.java de la carpeta \backend\src\main\java\com\hopital\hospital_rest y correr la aplicación con la tecla F5 en VS Code, esto puede tardar unos minutos. 
 - Para la app Web situarse en la carpeta frontend a través de la consola de comandos de Windows o mejor con la terminal incorporada en VS Code, y correr el comando: "npm install" el cual creará la carpeta node_modules, con todos los componentes necesarios que serán descargados de la nube. Posteriormente lanzar el comando "npm start" para que se levante el servidor de depuración.
 - Una vez seguidos todos los pasos a detalle ingresar al navegador de preferencia y escribir la dirección http://localhost:4200.