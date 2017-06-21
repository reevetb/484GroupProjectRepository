/* 
 *DDL FOR THE BOOKIT DATABASE
 */
/**
 * Author:  Trenton
 * Created: Jun 20, 2017
 */

CREATE TABLE EMPLOYEES
(   
    EMP_ID              INTEGER,
    FNAME               VARCHAR(50),
    LNAME               VARCHAR(50),
    STREET              VARCHAR(50),
    CITY                VARCHAR(50),
    STATE               CHAR(2),
    ZIPCODE             INTEGER,
    PERMISSION_LEVEL    INTEGER,
    PRIMARY KEY         (EMP_ID)
);
