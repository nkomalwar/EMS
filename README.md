To run this microservice please follow the steps mentioned below:


1. Download MySQL from https://dev.mysql.com/downloads/installer/
2. Install MySQL and then do the following steps for configuration post installation
	a. High Availability :
		Choose Standalone 'MySQL server/Classic MySQL replication' option.
	b. Type and Networking
		Choose 'Development Computer' in config Type.
		for connectivity keep the default per-populated values for the settings.
	c. Authentication Method
		Choose 'Use Legacy Authentication Method'
	d. Accounts and Roles
		Configure MySQL root password.
		Click on 'Add User' to add a new user.
		Specify the user name and password and keep the Role as 'DB Admin'
	e. Windows Service
		Ensure that the checkbox for 'Configure MySQL as a Windows Service' is checked.
	f. Apply these configurations.
	
	
3. Use following queries for creating the database and tables.
	
	
	a. create database employeedb;
	b. use employeedb;
	c. create table employee(id int primary key auto_increment, name varchar(30), email varchar(30));
	d. create table address(id int primary key auto_increment, doornumber varchar(10), street varchar(40), state varchar(20), pincode varchar(10), country varchar(20), emp_id int not null, foreign key (emp_id) references employee(id));
