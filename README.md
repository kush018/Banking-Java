# Banking-Java
A simple Banking Application written in java

To run program:
1. Compile all files by: javac *.java
2. Run main class by: java Run

This is a simple banking application written in java that runs based on a command line interface.
Use command "help" to get a list of commands and descriptions.
All accounts are saved to a file accounts.acc

Help:
* new : creates new account
* getaccountid [full name] : gives account id based on full name
* delete [account id] : deletes account
* accounts : gives list of all accounts
* showdetails [account id] : shows details of account
* deposit [account id] : deposits money to account
* withdraw [account id] : withdraws money from account
* get[attribute] [account id] : get attribute of account
* attributes : age, gender, firstname, lastname, balance, dob, joindate
* showhistory [account id] : shows transaction history of an account
* help : get this list
* entering x exits program
* NOTE: entering --cancel-- while creating new account cancels account creation
* NOTE: extra attributes will be ignored
