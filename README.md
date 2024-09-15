# PS2024
Repositorio Prueba Técnica GeoSAT 

Nota: Al usar play y ant, el back se corres desde el puerto 9000 con el comando "sbt run" y el front en el 300 con "npm run dev"

Herramientas Utilizadas:
-Java 17
-Scala 1.10.1 como base del sistema de construcción y gestión del proyecto a través de sbt (Se descago el .msi para que modifique las vaiables de entorno del sistema automaticamente. Se descargó de aquí https://www.scala-sbt.org/download)

Este:
![image](https://github.com/user-attachments/assets/7e1064e8-695d-43ca-a784-e1df4238b549)

En caso de querer saber donde se instala o algo relacionado a la ubicación, se puede revisar y elegir previo a la instalación:
![image](https://github.com/user-attachments/assets/c957bdfa-34b2-4c53-a734-146e6acb715d)

Para revisar que haya quedado instalado, se usa el siguiente comando:
sbt -version

Para ejecutarlo, escribes el comando: 
sbt run

-PostgreSQL 16.4 (Se descargo de aquí https://www.enterprisedb.com/downloads/postgres-postgresql-downloads y fue el segundo)
![image](https://github.com/user-attachments/assets/4ce6f28b-b82d-4596-8340-4f51be1ce531)

-Para este caso, cree la bd llamada malla_vial, con el usuario "postgres" y le asigne la contraseña de "123" y al usar sbt para manerjar el back, modifico el archivo application.conf con los siguientes datos: 
db.default.driver = org.postgresql.Driver
db.default.url = "jdbc:postgresql://localhost:5432/malla_vial"
db.default.username = "postgres"        
db.default.password = "123"    
![image](https://github.com/user-attachments/assets/6326cb21-bbfd-4083-a30c-98791727710f)

Y el archivo build.sbt con esta linea:
libraryDependencies += "org.postgresql" % "postgresql" % "42.2.20"
![image](https://github.com/user-attachments/assets/af89f40f-66a3-481b-9f55-ac258b685faf)

Para crear la bd, desde la consola, accedo al usuario de postgres con la contraseña 123 y ejecuto lo siguiente:
psql -U postgres
Contraseña para usuario postgres: 123
psql (16.4)
ADVERTENCIA: El código de página de la consola (850) difiere del código
            de página de Windows (1252).
            Los caracteres de 8 bits pueden funcionar incorrectamente.
            Vea la página de referencia de psql «Notes for Windows users»
            para obtener más detalles.
Digite «help» para obtener ayuda.

postgres=# CREATE DATABASE malla_vial;
postgres=# CREATE TABLE segmentos (  id SERIAL PRIMARY KEY,  numero_segmento VARCHAR(50) UNIQUE NOT NULL,  direccion VARCHAR(255) NOT NULL,  longitud DECIMAL NOT NULL);CREATE TABLE calzadas (  id SERIAL PRIMARY KEY,  segmento_id INTEGER REFERENCES segmentos(id) ON DELETE CASCADE,  ancho DECIMAL NOT NULL);CREATE TABLE bordillos (  id SERIAL PRIMARY KEY,  segmento_id INTEGER REFERENCES segmentos(id) ON DELETE CASCADE,  altura DECIMAL NOT NULL);

Nota: no se ha logrado la conexion a la bd, por lo que se esta guardando temporalmente en un array







