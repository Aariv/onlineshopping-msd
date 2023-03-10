# Online Shopping Microservice Development

# PRODUCT ARCHITECTURE
![alt ArchDiagram-1](https://github.com/Aariv/onlineshopping-msd/doc/arch-1.png?raw=true)

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
