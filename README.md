# Online Shopping Microservice Development

# PRODUCT ARCHITECTURE

<img width="1245" alt="Screenshot 2023-03-10 at 8 16 44 AM" src="https://user-images.githubusercontent.com/11393142/224379141-924ed995-c6cd-4024-af4b-3e1d7556835f.png">

## Product Service
All the product details will be captured & maintained in the Mongo Details.
## Order Service
All the order details will be captured & maintained in the Postgres.
## Inventory Service
All the inventory details will be captured & maintained in the Postgres.
## Notificaton Service
All the notification details will be captured & maintained in the Postgres.
## Discovery Service
Client-side service discovery allows services to find and communicate with each other without hard-coding the hostname and port. 
## API Gateway Service
All the request that passthrough from here are authenticated & redirected as per the routes configured. 
Secure API using Keycloak
