# API-ServiceRabbit-java
Study of producers and consumers using queues in RabbitMQ
Study of insert orders in mongodb local

## Docker
Try the community Docker image with port 15672:
> docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management

## RabbitMQ 
Open RabbitMQ
> <link>localhost:15672</link>

Running the Spring Boot application
<p align="center">
  <img src="https://imgur.com/4xeVTJb.gif" width="800" title="Screenshot">
</p>

Producing a message in the queue:
>POST
> <link>localhost:8080/servico-rabbitmq/v1/pedidos</link>

Note: The queue consumed is the same as for the <a href="https://github.com/gianeric/API-ServiceRabbit-nodejs">API-ServiceRabbit-nodejs</a>, we named this queue with the name "pedidos_node"
<p align="center">
  <img src="https://imgur.com/pxDI2Tq.gif" width="800" title="Screenshot">
</p>

Consuming messages from the queue:
>GET
> <link>localhost:8080/servico-rabbitmq/v1/pedidos</link>

Note: The queue consumed is the same as for the <a href="https://github.com/gianeric/API-ServiceRabbit-nodejs">API-ServiceRabbit-nodejs</a>, we named this queue with the name "pedidos_node"
<p align="center">
  <img src="https://imgur.com/kOmv851.gif" width="800" title="Screenshot">
</p>

## MongoDB (Orders)
Inserting an order in the NoSQL MongoDB database
>POST
> <link>localhost:8080/servico-mongo/v1/pedidos</link>
<p align="center">
  <img src="https://imgur.com/opf58AN.png" width="800" title="Screenshot">
</p>

Searching for orders in the NoSQL MongoDB database
>GET
> <link>localhost:8080/servico-mongo/v1/pedidos</link>
<p align="center">
  <img src="https://imgur.com/0JsGJ3R.png" width="800" title="Screenshot">
</p>


