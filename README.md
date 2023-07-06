# Backend para app de banco con Spring Boot
## Introducción
Se ha implementado un backend con Spring Boot y MySQL (en este caso con MariaDB si se utiliza XAMPP).
Se han incluído las operaciones básicas para tener una API CRUD (create read update delete) con las 4 entidades trabajadas.

## Instalación
### Clonar el repositorio
```git clone https://github.com/edufsc/banco-backend-spring-2023.git```
### Configurar la conexión con la base de datos
Es necesario que la base de datos esté creada y funcionando y disponer de un usuario con todos los privilegios. Editar el archivo src/main/resources/application.properties con las credenciales de tu BDD.
### Añadir a Eclipse
File > Import > Existing Maven project > Seleccionar la carpeta del proyecto y si ha detectado el pom.xml hacer click en "Finish". Recomendable instalar el complemento Spring Tools 4 desde el marketplace de Eclipse.
## Ejecutar
Dado que hemos incluído las dependencias de Web la aplicación dispone de un servidor Tomcat ya configurdo. Solo hay que ejecutarlo con el complemento de Eclipse o desde la terminal con ```java -jar backend.jar``` estando en el directorio target dspués de haber ejecutado ```mvn clean``` o desplegado previeamente la aplicación.
## Importante
Hay que volver a desplegar la aplicación después de hacer cambios. Asegurarse de que la base de datos está funcionando y con las credenciales correctas. Tener una versión de java igual o superior a la 17. Los paquetes de nuestras clases deben estar bajo el paquete principal para que Spring pueda escanear el código correctamente. En el fichero pom.xml encontramos las dependencias de nuestro proyecto. En este caso MySQL Driver para conectar con base de datos, Spring Data JPA para implementar JPA con hibernate (también para base de datos) y Spring Web para incluir el servidor Tomcat.
