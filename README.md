# Student-Database-CRUD-using-Java-RMI

It's a simple RMI Application which performs CRUD(create, read, update and delete) operations.

## What is RMI ?

RMI stands for Remote Method Invocation. It is a mechanism that allows to access on object running on a certain JVM from another different JVM. Using RMI we can build distributed applications.

## RMI Application Architechture

![RMI Architechture](https://miro.medium.com/max/1400/1*GSl3W-WzYYVqORQ9XMgFGA.png)

## Features
- Create a Student Record in Database
- Read a Student Record from the Databse
- Upade a Student Record in Database
- Delete a Student Record from the Database

## Technologies Uesd
- Java 1.8
- RMI (Remote Method Invocation)
- JDBC
- SQL

## How to Execute the Application ?
1. Compile All Java files

    ```
    Javac *.java
    ```
1. Start RMI registry
  
   ```
    start rmiregistry
    ```
 1. Run Server
  
    ```
    java AdderServer
    ```
 1. Run Client
   
    ```
    java AdderClient
    ```
  
