#De la imagen que partimos
FROM openjdk:11-jre-slim
#Zona horaria
#RUN apk add --no-cache tzdata
ENV TZ='America/Lima'
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

#Directorio de trabajo
WORKDIR /app
#Copiamos el uber-jar en el directorio de trabajo
COPY /target/ms-ne-gestionIntencion-1.0.0.jar /app
#Exponemos el puerto 8080
EXPOSE 8080

#Comando que se ejecutará una vez ejecutemos el contendor
CMD ["java","-jar","ms-ne-gestionIntencion-1.0.0.jar"]
