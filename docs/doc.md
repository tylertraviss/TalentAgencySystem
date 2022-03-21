# <HTML><center>  :star:Talent Agency System </center></html>

In compliance with the standards of SWE4403 at The University of New Brunswick. The intent of the Talent Agency System is for the intended use of a private company responsible for managing, working, and editing information of their clientele, their management, and automating many metrics of the company's success. 

# Program Summary
The Talent Agency System allows the user to create new employees, edit, and remove them. When creating a new employee, the user must specify the start and end date of their contract. The user may also add a superior, that has already been added to the system, to the employee. The user may also add, edit, and remove clients. When creating a new client, the user must specify which client type they are (Athlete, Musician, or Actor). In case a client has a sponsor, there is functionality to edit, add, and remove sponsors. Next the user can print company statistics of the most recent state of the company with the Template pattern to either the console or a text file. Finally with the Memento pattern the user can undo any recent change they have made to the program, resetting the company to a previous state.

# Contributors
* [**Tyler Travis**](https://github.com/tylertraviss) | Developer 

* [**Kisenge Mbaga**](https://github.com/kisenge)  | Developer

* [**Ben Irvine**](https://github.com/Ben-F-Irvine)  | Developer

* [**Elliot Chin**](https://github.com/Elliot-Chin)  | Developer

* [**Edward Chang**](https://github.com/edwardchang7)  | Developer

# Commands to COMPILE the project
* To run the project, open the terminal and switch your directory to `TalentAgencySystem` and to `src` using the command below:
```
cd src
```
* When you are in the right directory (~/TalentAgencySystem/src)  to compile the project, use the command below:
```
javac -cp . ./UI/MainFrame.java
```

# Commands to RUN the project
* After compiling the project, use the following command to run it:
```
java UI/MainFrame
```
