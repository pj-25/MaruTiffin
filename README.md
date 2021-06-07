# Marutiffin

## Project Structure (Current)
```javascript
MaruTiffin
├── components
│   ├── constData
│   │   └── src
│   │       ├── main
│   │       │   ├── java
│   │       │   └── resources
│   │       └── test
│   │           └── java
│   ├── DatabaseHandler
│   │   └── src
│   │       ├── main
│   │       │   ├── java
│   │       │   └── resources
│   │       └── test
│   │           └── java
│   ├── EntityHandler
│   │   └── src
│   │       ├── main
│   │       │   ├── java
│   │       │   └── resources
│   │       └── test
│   │           └── java
│   ├── EventHandler
│   │   └── src
│   │       ├── main
│   │       │   ├── java
│   │       │   └── resources
│   │       └── test
│   │           └── java
│   ├── MessageHandler
│   │   └── src
│   │       ├── main
│   │       │   ├── java
│   │       │   └── resources
│   │       └── test
│   │           └── java
│   ├── NetworkConnection
│   │   ├── src
│   │   │   ├── main
│   │   │   │   ├── java
│   │   │   │   │   └── networkConnection
│   │   │   │   │       ├── messageHandler
│   │   │   │   │       │   └── MessageConsumer.java
│   │   │   │   │       └── SocketConnection.java
│   │   │   │   └── resources
│   │   │   └── test
│   │   │       └── java
│   │   └── target
│   │       ├── classes
│   │       │   └── networkConnection
│   │       │       └── messageHandler
│   │       └── generated-sources
│   │           └── annotations
│   ├── out
│   │   └── artifacts
│   │       └── Server_jar
│   └── Server
│       ├── src
│       │   ├── main
│       │   │   ├── java
│       │   │   │   └── server
│       │   │   │       ├── ClientConnectionsHandler.java
│       │   │   │       ├── RequestHandler.java
│       │   │   │       ├── ServeClient.java
│       │   │   │       └── Server.java
│       │   │   └── resources
│       │   └── test
│       │       └── java
│       └── target
│           ├── classes
│           │   └── server
│           └── generated-sources
│               └── annotations
├── databaseAssets
└── MaruTiffinApp
    ├── ClientApp
    │   ├── app
    │   │   ├── libs
    │   │   └── src
    │   │       ├── androidTest
    │   │       │   └── java
    │   │       │       └── com
    │   │       │           └── example
    │   │       │               └── clientapp
    │   │       │                   └── ExampleInstrumentedTest.java
    │   │       ├── main
    │   │       │   ├── java
    │   │       │   │   └── com
    │   │       │   │       └── example
    │   │       │   │           └── clientapp
    │   │       │   │               └── MainActivity.java
    │   │       │   └── res
    │   │       │       ├── drawable
    │   │       │       ├── drawable-v24
    │   │       │       ├── layout
    │   │       │       ├── mipmap-anydpi-v26
    │   │       │       ├── mipmap-hdpi
    │   │       │       ├── mipmap-mdpi
    │   │       │       ├── mipmap-xhdpi
    │   │       │       ├── mipmap-xxhdpi
    │   │       │       ├── mipmap-xxxhdpi
    │   │       │       ├── values
    │   │       │       └── values-night
    │   │       └── test
    │   │           └── java
    │   │               └── com
    │   │                   └── example
    │   │                       └── clientapp
    │   │                           └── ExampleUnitTest.java
    │   └── gradle
    │       └── wrapper
    ├── libs
    ├── ServerApp
    │   └── src
    │       ├── main
    │       │   ├── java
    │       │   │   ├── server
    │       │   │   │   ├── RunServer.java
    │       │   │   │   └── userConnection.java
    │       │   │   └── services
    │       │   │       ├── ServeRequest.java
    │       │   │       └── ServiceHandler.java
    │       │   └── resources
    │       └── test
    │           └── java
    └── src
        ├── main
        │   ├── java
        │   └── resources
        └── test
            └── java

118 directories, 13 files
```
