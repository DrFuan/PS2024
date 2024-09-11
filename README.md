# PS2024
Repositorio Prueba Técnica GeoSAT 

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

-Para este caso, cree la bd llamada project, con el usuario "postgres" y le asigne la contraseña de "123" y al usar sbt para manerjar el back, modifico el archivo application.conf con los siguientes datos: 
db.default.driver = org.postgresql.Driver
db.default.url = "jdbc:postgresql://localhost/project"
db.default.username = "postgres"        
db.default.password = "123"    
![image](https://github.com/user-attachments/assets/6326cb21-bbfd-4083-a30c-98791727710f)

Y el archivo build.sbt con esta linea:
libraryDependencies += "org.postgresql" % "postgresql" % "42.2.20"
![image](https://github.com/user-attachments/assets/af89f40f-66a3-481b-9f55-ac258b685faf)

Para crear la bd, abro pgAdmin, me conecto al servidor con el usuario "postgres" y la contraseña "123"
En Database, creo la base de datos llamada "project" con el owner "postgres"
![image](https://github.com/user-attachments/assets/b5bf205d-bc32-4b73-b598-839aef547d3b)
![image](https://github.com/user-attachments/assets/0363544d-253e-4439-95d4-d94af07f76cf)
Una vez, creada, me dirijo a la base de datos y presiono Query Tool 
![image](https://github.com/user-attachments/assets/bd58c6ec-f150-4ef1-b22a-388a17e25b28)
Una vez allí, ingreso el script de las tablas de la base de datos:

CREATE TABLE segmento (
    id SERIAL PRIMARY KEY,         -- Identificador único del segmento
    longitud NUMERIC NOT NULL,     -- Longitud del segmento
    nomenclatura VARCHAR(255)      -- Nomenclatura o dirección del segmento
);

CREATE TABLE calzada (
    id SERIAL PRIMARY KEY,         -- Identificador único de la calzada
    longitud NUMERIC NOT NULL,     -- Longitud de la calzada
    segmento_id INT NOT NULL,      -- Relación con el segmento
    FOREIGN KEY (segmento_id) REFERENCES segmento(id)
);

CREATE TABLE bordillo (
    id SERIAL PRIMARY KEY,         -- Identificador único del bordillo
    longitud NUMERIC NOT NULL,     -- Longitud del bordillo
    segmento_id INT NOT NULL,      -- Relación con el segmento
    FOREIGN KEY (segmento_id) REFERENCES segmento(id)
);


