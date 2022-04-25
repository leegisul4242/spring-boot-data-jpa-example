
# Docker-compose
<pre>
<code>
version: '3'

services:
        mysql-docker-container-dc:
                image: mysql:5.7
                environment:
                 - MYSQL_ROOT_PASSWORD=root123
                 - MYSQL_DATABASE=spring_app_db
                 - MYSQL_USER=app_user
                 - MYSQL_PASSWORD=test123
                volumes:
                  - /data/mysql
        spring-boot-jpa-app-dc:
                image: spring-jpa-app-dc
                build:
                        context: ./
                        dockerfile: Dockerfile
                depends_on:
                        - mysql-docker-container-dc
                ports:
                        - 8087:8080
                volumes:
                        - /data/spring-boot-jpa-app
                restart: always

</code>
</pre>
# Dockerfile

<code>
<pre>
FROM java:8
LABEL maintainer="ur_email@gmail.com"
VOLUME /tmp
EXPOSE 8080
ADD target/spring-boot-data-jpa-example-0.0.1-SNAPSHOT.jar spring-boot-data-jpa-example-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","spring-boot-data-jpa-example-0.0.1-SNAPSHOT.jar"]
</code>
</pre>
