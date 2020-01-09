# micro_service_demo
Micro service demo by Spring Rest
This is a micro service application demo by Spring Rest
It implements simply account function such as:
1. Create a new account 
2. Find account by ID
3. Find all accounts
4. Edit account's information
5. Delete a account
6. Transfer money from a account to another account

This application use Spring Rest's JPA function to connect DB and CRUD function to request other service from a service.

Neuka naming server registers all instances of service so the instances can be distingushed by names of services.

Zuul gateway is setup between communications of different services.

Transfer service calls find account service and update account service to retrieve information of accounts and edit the balance of accounts
