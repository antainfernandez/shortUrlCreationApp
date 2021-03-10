# Spring Boot Rest API short url creations

a demo of a simple  API for create short url and store in h2 database
It has a simple web app that consume the API for test it also
(if not use the web app,  use for example

 curl -X POST localhost:8081/api/v1/createShortUrl -H 'Content-type:application/json' -d '{"originalUrl": "https://www.youtube.com"}'
 
 curl -v localhost:8081/api/v1/shortToOriginalUrl/D
)

expose port 8081 in case port 8080 already take it

  - Open localhost:8081/swagger-ui.html to see endpoints. 
  - Open localhost:8081/h2-console. 
  
  # How to use 
  + With Docker 

  ```sh
  $ git clone https://github.com/antainfernandez/shortUrlCreationApp.git
  $ cd shortUrlCreationApp 
  $ docker build  -t antainfernandez/short:1.0 . --rm  
  $ docker run -t -p 8081:8081 --name shortApp  antainfernande/short:1.0
  ```
  
     
  
  - Without Docker: 
  ```sh
  $ git clone https://github.com/antainfernandez/shortUrlCreationApp.git
  $ ./gradlew bootRun
  ```