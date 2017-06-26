-- /* 
--  *DDL FOR THE BOOKIT DATABASE
--  */
-- /**
--  * Author:  Trenton
--  * Created: Jun 20, 2017
--  *
--  */

-- CREATE USER BOOKITDB IDENTIFIED BY OVALTINE;
-- 
-- GRANT  grant CREATE SESSION, ALTER SESSION, CREATE DATABASE LINK,
-- CREATE MATERIALIZED VIEW, CREATE PROCEDURE, CREATE PUBLIC SYNONYM,
-- CREATE ROLE, CREATE SEQUENCE, CREATE SYNONYM, CREATE TABLE,
-- CREATE TRIGGER, CREATE TYPE, CREATE VIEW, UNLIMITED TABLESPACE
-- to BOOKITDB;

CREATE TABLE EMPLOYEES
(   
    EMP_ID              INTEGER,
    FNAME               VARCHAR(50),
    LNAME               VARCHAR(50),
    STREET              VARCHAR(50),
    CITY                VARCHAR(50),
    STATE               CHAR(2),
    ZIPCODE             INTEGER,
    CELL                VARCHAR(13),
    USERNAME            VARCHAR(50) NOT NULL,
    PASSWORD            VARCHAR(50) NOT NULL,
    WAGE                REAL,
    OT_WAGE             REAL,
    EMP_TYPE            VARCHAR(25),
    MANAGER_ID          INTEGER,
    PRIMARY KEY         (EMP_ID)
    FOREIGN KEY         (MANAGER_ID) REFERENCES EMPLOYEES
);

CREATE TABLE STORES
(
    STORE_ID            INTEGER,
    STREET              VARCHAR(50),
    CITY                VARCHAR(50),
    ZIPCODE             INTEGER,
    PRIMARY KEY         (STORE_ID)
);

CREATE TABLE EXPENSES
(
    INVOICE_NUMBER      INTEGER,
    EXPENSE_TYPE        VARCHAR(25),
    EXPENSE_DATE        DATE,
    EXPENSE_COST        REAL,
    EXPENSE_DESC        VARCHAR(250),
    STORE_ID            INTEGER,
    PRIMARY KEY         (INVOICE_NUMBER),
    FOREIGN KEY         (STORE_ID) REFERENCES STORES
);


CREATE TABLE PAYROLL
(
    PAYROLL_NUM         INTEGER,
    WORK_DATE           DATE,
    HOURS               INTEGER NOT NULL,
    OT_HOURS            INTEGER,
    TOTAL_HOURS         INTEGER,
    TOTAL_PAY           REAL,
    EMP_ID              INTEGER,
    STORE_ID            INTEGER,
    PRIMARY KEY         (PAYROLL_NUM, EMP_ID, STORE_ID),
    FOREIGN KEY         (EMP_ID) REFERENCES EMPLOYEES,
    FOREIGN KEY         (STORE_ID) REFERENCES STORES
);



CREATE TABLE MEMBERS
(
    MEMBER_ID           INTEGER,
    FNAME               VARCHAR(50),
    LNAME               VARCHAR(50),
    STREET              VARCHAR(50),
    CITY                VARCHAR(50),
    STATE               CHAR(2),
    ZIP                 INTEGER,
    CELL                VARCHAR(13),
    EMAIL               VARCHAR(50),
    USERNAME            VARCHAR(50) NOT NULL,
    PASSWORD            VARCHAR(50) NOT NULL,
    PRIMARY KEY         (MEMBER_ID)
);

CREATE TABLE MEMBERSHIP
(
    MEMBERSHIP          INTEGER,
    STORE_ID            INTEGER,
    POINTS              INTEGER,
    STATUS              VARCHAR(25),
    PRIMARY KEY         (MEMBER_ID, STORE_ID),
    FOREIGN KEY         (MEMBER_ID) REFERENCES MEMBERS,
    FOREIGN KEY         (STORE_ID) REFERENCES STORES
);

CREATE TABLE INVENTORY
(
    INV_ID              INTEGER,
    ITEM_NAME           VARCHAR(100),
    ITEM_DESC           VARCHAR(100),
    ITEM_QUANTITY       INTEGER,
    PRICE               REAL,
    ISBN                VARCHAR(17),
    GENRE               VARCHAR(50),
    AUTHOR              VARCHAR(50),
    PUBLISHER           VARCHAR(50),
    BOOK_YEAR           INTEGER,
    PRIMARY KEY         (INV_ID)
);

CREATE TABLE SALES
(
    INV_ID              INTEGER,
    STORE_ID            INTEGER,
    QIS                 INTEGER,
    PRICE               REAL,
    PRIMARY KEY         (INV_ID, STORE_ID),
    FOREIGN KEY         (INV_ID) REFERENCES INVENTORY,
    FOREIGN KEY         (STORE_ID) REFERENCES STORES
);

CREATE TABLE SUPPLIERS
(
    SUPPLIER_ID         INTEGER,
    NAME                VARCHAR(50),
    STREET              VARCHAR(50),
    CITY                VARCHAR(50),
    STATE               CHAR(2),
    ZIP                 VARCHAR(50),
    CELL                VARCHAR(50),
    PRIMARY KEY         (SUPPLIER_ID)
);

CREATE TABLE PURCHASE_ORDERS
(
    SUPPLIER_ID         INTEGER,
    INV_ID              INTEGER,
    QUANTITY            INTEGER,
    PRIMARY KEY         (SUPPLIER_ID, INV_ID),
    FOREIGN KEY         (SUPPLIER_ID) REFERENCES SUPPLIERS,
    FOREIGN KEY         (INV_ID)    REFERENCES INVENTORY
);



