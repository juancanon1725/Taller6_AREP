# AREP - Taller 7

Juan Pablo Poveda Cañon

## Description

Desarrolle una aplicación Web segura con los siguientes requerimientos:

Debe permitir un acceso seguro desde el browser a la aplicación. Es decir debe garantizar autenticación, autorización e integridad de usuarios.
Debe tener al menos dos computadores comunicacndose entre ellos y el acceso de servicios remotos debe garantizar: autenticación, autorización e integridad entre los servicios. Nadie puede invocar los servicios si no está autorizado.
Explique como escalaría su arquitectura de seguridad para incorporar nuevos servicios.

## Instalación

1. Clonar el repositorio.
   
`git clone https://github.com/juancanon1725/Taller7_AREP.git`

## Ejecución

1. Desde la carpeta Taller7_AREP ejecutar el comando:
`mvn clean install`

2. Se realiza la compilación y la ejecución del programa.

![Captura de pantalla 2024-03-20 144746](https://github.com/juancanon1725/Taller7_AREP/assets/98672541/97566b57-9393-452f-b431-4479eea8d468)

![Captura de pantalla 2024-03-20 151523](https://github.com/juancanon1725/Taller7_AREP/assets/98672541/e23922a1-c90c-4297-8348-fc1a2ab1643d)


## AWS

[Video Explicativo de despliegue en AWS](https://youtu.be/l8F83mi89pA)


## Arquitectura

La arquitectura representada en la imagen adopta un enfoque de dos capas, divididas en la capa de presentación y la capa de datos. La capa de presentación consta de un navegador web y un servicio de inicio de sesión, mientras que la capa de datos incluye dos servidores: uno para el servicio de inicio de sesión y otro para otros servicios.

En el flujo de interacción, el navegador web sirve como punto de entrada para los usuarios. Cuando un usuario realiza una solicitud HTTP, esta se dirige al servicio de inicio de sesión. Este servicio se encarga de autenticar las credenciales del usuario y, si son válidas, emite una respuesta HTTP que incluye un token de autorización. Luego, el navegador web utiliza este token para realizar una nueva solicitud HTTP al otro servidor, que proporciona los datos requeridos.

Esta arquitectura está meticulosamente diseñada para asegurar la integridad, la autorización y la autenticación tanto a nivel de usuario como de servidor.

Integridad: La integridad de los datos se protege mediante el uso de cifrado SSL/TLS. Todas las comunicaciones entre el navegador web y los servidores se cifran, evitando que terceros puedan interceptar o alterar la información.


