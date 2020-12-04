### Requerimientos para replicación de proyecto Programas
```
• Insomnia
• SpringToolsSuit for Eclipse
• Docker
```
### Set mysql docker DB
#### Correr estos comandos en la terminal(Mac OS) puede variar windows
```
• docker pull mysql
• docker run -d -p 13306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=secret mysql --
character-set-server=utf8mb4 --collation-server=utf8mb4_unicode_ci Acceder a shell mysql
• docker exec -it mysql mysql -uroot -p
• Contraseña = secret
• CREATE DATABASE users;
• create user 'mysqluser' identified by 'secret';
• GRANT ALL PRIVILEGES ON *.* TO 'mysqluser'@'%';
```
### Configurar insomnia
```
• Click en importar y selección archivo Insomnia*.json
•
• De este modo ya queda listo para uso Insomnia con el API de prueba
```
 
### Ejecución de Spring Boot Application
```
• Correr con Maven install primero
• Ejecutar el archivo UserAppApplication como Java Application
```

### cargar de informacion de usuarios a la BD
```
al iniciarse el proyecto si la base de datos esta vacia se cargara automaticamente con 50 datos poblados mediante Faker
por lo cual no es necesario agregar un archivo de backup de los datos
```
