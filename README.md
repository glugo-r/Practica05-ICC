# Practica05-ICC

## Objetivo
Correcta implementación y uso de los siguientes conceptos fundamentales de la programación orientada a objetos:
- Escritura de archivos
- Lectura de archivos
- Polimorfismo
- Genéricos

## Descripción:
Esta práctica está diseñada como una extensión directa de la Práctica 04. 

Este proyecto busca con la utilización de Genéricos:
- Modificar ArreglosInterface (hacerla genérica ArreglosInterface<T>=
- ManejadorLista: Implementa ArreglosInterface <T>

Con funcionalidades:
-leerArchivoComoArreglo (String nombreArchivo)
-buscarLinea (String cadenaBuscada,String nombreArchivo)
-escribirLineaAlFinal(String linea,String nombreArchivo)
-escribirArregloAArchivo(String[] lineas, String nombreArchivo)

Con salida:
-Lista de 11 Administradores
-Lista de 11 Empleados
-Los primeros 10 son la lista original en orden reverso
-El último es el nuevo empleado añadido

## Tecnologías utilizadas
Java

## Instrucciones de Ejecución
Compilar desde Proyecto: "javac -d out src/*.java src/modulos/*.java src/interfaces/*.java"

Ejecutar Main: "java -cp out Main ’’Juan’’ ’’María’’ ’’Carlos’’ ’’Ana’’ ’’Luis’’ ’’Laura’’ ’’Pedro’’
’’Sofia’’ ’’Miguel’’ ’’Elena’’"
