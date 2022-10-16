# Aplicación ToDoList con base de datos PostgreSQL

Para poder ejecutar la aplicación:

```bash
docker run -d -p 5432:5432 --name postgres-develop -e POSTGRES_USER=mads -e POSTGRES_PASSWORD=mads -e POSTGRES_DB=mads 
postgres:13
```
Una vez que el contenedor funciona correctamente, ejecutamos la aplicación de Spring con:

```bash 
./mvnw spring-boot:run -D profiles=postgres
```

## Github Actions

En esta aplicación, en primer lugar teníamos que configurar Github Actions, para comprobar que los tests pasen correctamente cada vez que se realiza Pull Request.

Primero he probado con un test incorrecto:

![test-fail1](https://user-images.githubusercontent.com/98825807/192607327-e1df181c-4068-412d-9734-06bde9df31db.png)

Si pulsamos en Detalles, podemos ver que nos indica cuál es el test incorrecto:

![test-fail2](https://user-images.githubusercontent.com/98825807/192607434-4bd89375-ea38-4101-ac1a-95568c932179.png)


Posteriormente, he corregido el test, probando que la Integración Continua funciona correctamente:

![test-correcto1](https://user-images.githubusercontent.com/98825807/192607549-e1e11b3e-3af5-4281-ba27-19c0a37fd769.png)
