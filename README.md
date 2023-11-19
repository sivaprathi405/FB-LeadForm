Facebook Lead Collector - Java Application

This Java application serves as a model for collecting leads from Facebook and storing them in a MySQL database. The application provides functionalities to input lead details through the terminal or fetch existing lead details stored in the MySQL database.

Features
Fill Details: Allows users to input lead details such as name, email, and phone number through the terminal and stores them in the connected MySQL database.
Fetch Details: Retrieves and displays existing lead details from the MySQL database.
Prerequisites
To run this application, ensure you have the following installed:

Java Development Kit (JDK)
MySQL Server
MySQL Connector/J (JDBC driver)
Setup and Usage
Database Configuration:

Create a MySQL database named your_database and a table named leads with columns for name, email, and phone.
MySQL Connection:

Modify the dbURL, username, and password variables in the Java code (TerminalLeadProcessor.java) to match your MySQL database credentials.
Compile and Run:

Compile the Java code using any Java compiler.
Run the compiled application using java TerminalLeadProcessor in the terminal.
Terminal Interface:

The terminal interface presents two options:
Fill Details: Enter 1 to input lead details interactively through the terminal.
Fetch Details: Enter 2 to retrieve existing lead details stored in the MySQL database.
Follow Terminal Prompts:

Based on your choice, follow the prompts to either fill new lead details or fetch existing lead details.
Example Use Cases
Filling Lead Details:

Choose option 1 in the terminal.
Enter the requested lead details when prompted (name, email, phone).
Fetching Lead Details:

Choose option 2 in the terminal.
Existing lead details stored in the MySQL database will be displayed.
Important Notes
Ensure your MySQL server is running before executing the application.
Modify the code as necessary for more complex data structures or authentication mechanisms for Facebook API interaction (if required).
