# custom-di-framework

Design and implement a dependency injection framework like spring for singlton and prototype scopes.

How to Use:

1. cd CustomDIFramework/
2. mvn clean install -e

Code Architecture

1. CustomDiApplicationContext interface is context similar to spring appliation context.
2. CustomDiApplicationContextImpl implementation will hold the beans in hashmap and responsible to manage
   creation - singleton and prototype scope of beans.
3. CustomDiInject annotation is used to perform the Dependecy Injection.

Limitations:

1. CustomDiInject can not be made parameterised to configure singleton and prototype scope
2. DI is implemented on simple case scenario. The code can be further enhanced to get Object Graph and complete DI.
