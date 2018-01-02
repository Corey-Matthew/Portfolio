DROP TABLE USERS;
DROP TABLE ROLE;
DROP TABLE USER_ROLE;
DROP TABLE DEPARTMENT;
DROP TABLE ISSUE;
DROP TABLE ISSUE_UPDATES;

CREATE TABLE USERS (
    User_id number(4),
    Dept_id number(4),
    Email varchar2(30),
    Username varchar2(30),
    Password varchar2(30)
);

CREATE TABLE ROLE (
    Role_id number(4),
    Role_Name varchar2(30)
);

CREATE TABLE USER_ROLE (
  User_id number(4),
  Role_id  number(4)
);

CREATE TABLE DEPARTMENT (
    Dept_id number(4),
    Dept_Name varchar2(30)
);

CREATE TABLE ISSUE (
    Issue_id number(4),
    Title varchar2(30),
    User_Description varchar2(300),
    Admin_Comment varchar2(300),
    Assigned_to number(4),
    Submitted_by number(4),
    Status varchar2(30),
    Priority number(2),
    Date_Submitted date,
    Date_Resolved date 
);

CREATE TABLE ISSUE_UPDATES (
    Issue_id number(4),
    Submitted_by number(4),
    Update_Date date,
    Update_Comment varchar2(300)
);