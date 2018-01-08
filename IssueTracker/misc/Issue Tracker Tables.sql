-- DROP ALL TABLES FIRST (preferrably twice)
-- THEN create tables afterwards.
DROP TABLE USERS;
DROP TABLE ROLE;
DROP TABLE USER_ROLE;
DROP TABLE DEPARTMENT;
DROP TABLE ISSUE;
DROP TABLE ISSUE_UPDATES;


CREATE TABLE DEPARTMENT (
    Dept_id number(4),
    Dept_Name varchar2(30),
    constraint dept_pk PRIMARY KEY (Dept_id)
    --constraint dept_uk UNIQUE (Dept_Name)
);

CREATE TABLE USERS (
    User_id number(4),
    Dept_id number(4),
    Email varchar2(30),
    Username varchar2(30),
    Password varchar2(30),
    constraint user_pk PRIMARY KEY (User_id),
    constraint username_uk UNIQUE (Username)
    --CONSTRAINT fk_department
    --FOREIGN KEY (Dept_id)
    --REFERENCES DEPARTMENT(Dept_id)
);

CREATE TABLE ROLE (
    Role_id number(4),
    Role_Name varchar2(30),
    constraint role_pk PRIMARY KEY (Role_id),
    constraint role_uk UNIQUE (Role_Name)
);

CREATE TABLE USER_ROLE (
  User_id number(4) ,
  Role_id  number(4)
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
    Date_Resolved date,
    constraint issue_pk PRIMARY KEY (Issue_id)
);

CREATE TABLE ISSUE_UPDATES (
	Issue_Update_Id number(4),
    Issue_id number(4),
    Submitted_by number(4),
    Update_Date date,
    Update_Comment varchar2(300),
    constraint issue_update_pk PRIMARY KEY (Issue_Update_Id)
);