# System UML Diagrams
### Memento
Memento is used by MementoCreator and MementoRestorer. It stores the instance from Company and has the function to return that state in a memento.
### MementoCreator
MementoCreator can get a company state and create a memento of that state. 
### MementoRestorer
MementoRestorer is used to store the state of a company and be able to return that state back.
### SponsorshipMediatorBase
SponsorshipMediatorBase interfaces with all the sponsor classes.
### SponsoredClient
Sponsor holds the information about the sponsored Client and mediates with the other sponsor classes through SponsorshipMediator
### Sponsorship
Sponsor holds the information about the sponsorship and mediates with the other sponsor classes through SponsorshipMediator
### SponsorshipMediator
SponsorshipMediator implements SponsorchipMediatorBase and mediates between Sponsorship, SponsoredClient, and Sponsor class.
### Sponsor
Sponsor holds the information about the sponsor and mediates with the other sponsor classes through SponsorshipMediator
### Person
Person is the class which Employee and Client inherit from.
### Employee
Employee inherits from Person and is used to clone Employees with the Prototype design pattern. 
### Client
Client is a template for Actor, Musician, and Athlete that inherits from Person and can add instances of Experience and/or Awards to the client. 
### Experience
Experience is used as a variable type for Client storing previous experiences.
### Award
Award is used as a variable type for Client storing awards.
### Actor 
Actor is a type of Client that is created by Company.
### Musician
Musician is a type of Client that is created by Company.
### Athlete
Athlete is a type of Client that is created by  Company. 
### Instrument
Instrument is a variable type for Musician storing the name of an instrument.
### Company
Company implements the singleton pattern to create a single instance of the class. Company also has the functions to create new employees and clients as well as remove them.
### AuditStrategyInterface
AuditStrategyInterface interfaces between ConsoleAudit and TextFileAudit to print company information.
### ConsoleAudit
ConsoleAudit print company information to the console.
### TextFileAudit
ConsoleAudit print company information to a text file..


