# micro_service_demo
This is a micro service application demo by Spring Rest
It implements simply account function such as:
1. Create a new account 
2. Find account by ID
3. Find all accounts
4. Edit account's information
5. Delete a account
6. Transfer money from a account to another account

To successfully run this applications, you are recommended to launch the services by this ordering:

1. Netflix Eureka Naming Server
2. Create Account Service
3. Find Account Service
4. Find Accounts Service
5. Update Account Service
6. Delete Account Service
7. Transfer Account Service
8. Netfliex Zuul API Gateway Server

You MUST launch the Netflix Eureka Naming Server first and Netfliex Zuul API Gateway Server must be the last. Other services can be launched in arbitrary order between sequence 2 - 7.

This application use Spring Rest's JPA function to connect DB and CRUD function to request other service from a service.

Eureka naming server registers all instances of service so the instances can be distingushed by names of services.

Zuul api gateway server is setup between communications of different services.

Transfer service calls find account service and update account service to retrieve information of accounts and edit the balance of accounts.

#####practice branch 28 Aug 2020 18:05
practice branch 28 Aug 2020 22:53
practice branch 28 Aug 2020 23:07
practice branch 28 Aug 2020 23:17
practice branch 28 Aug 2020 23:26
practice branch 28 Aug 2020 23:56
practice branch 29 Aug 2020 00:12
practice branch 29 Aug 2020 00:17
