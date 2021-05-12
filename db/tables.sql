/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  melvi
 * Created: 21/04/2021
 */
/*
"jdbc:derby://localhost:1527/";//replace this string with your jdbc:derby local host url   
"iotdb";//name of the database   
"iotuser";//db root user   
"admin"; //db root password   
"org.apache.derby.jdbc.ClientDriver"; //jdbc client driver - built in with NetBeans   
*/

CREATE TABLE "USER" (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100000, INCREMENT BY 1),
    "NAME" VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    PHONE VARCHAR(10),
    PASSWORD VARCHAR(255) NOT NULL,
    PRIMARY KEY(ID)
);

-- note: execute inserts.sql to insert roles
CREATE TABLE "ROLE" (
    ID INTEGER NOT NULL,
    ROLE_NAME VARCHAR(255) NOT NULL,
    PRIMARY KEY(ID) -- ID be the primary key or a foreign key ported from table "user" ?
);

CREATE TABLE AUDITS (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100000, INCREMENT BY 1),
    USER_ID INTEGER,
    AUDIT_EVENT VARCHAR(255) NOT NULL,
    AUDIT_DATE VARCHAR(255) NOT NULL,
    PRIMARY KEY(ID),
    FOREIGN KEY(USER_ID) REFERENCES "USER"(ID)
);

CREATE TABLE PAYMENT (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100000, INCREMENT BY 1),
    PAYMENT_METHOD VARCHAR(255) NOT NULL,
    PAYMENT_AMOUNT DECIMAL(10,2) NOT NULL,
    PAYMENT_DATE VARCHAR(255) NOT NULL,
    CARD_NAME VARCHAR(255) NOT NULL,
    CARD_NO VARCHAR(16) NOT NULL,
    CARD_EXP VARCHAR(5) NOT NULL,
    CARD_CVV VARCHAR(3) NOT NULL,
    PRIMARY KEY(ID)
);

CREATE TABLE "SHIPMENT" (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100000, INCREMENT BY 1),
    SHIPMENT_DATE VARCHAR(255) NOT NULL,
    SHIPMENT_ADDRESS1 VARCHAR(255) NOT NULL,
    SHIPMENT_ADDRESS2 VARCHAR(255),
    SHIPMENT_POSTCODE VARCHAR(4),
    SHIPMENT_CITY VARCHAR(255),
    SHIPMENT_STATE VARCHAR(3),
    PRIMARY KEY(ID)
);

-- FOREIGN KEY DELCARATIONS BELOW
-- note: execute one semicolon line at a time

ALTER TABLE "USER" --?not sure what this is used for
    ADD ROLE_ID INTEGER;
    
    ADD FOREIGN KEY (ROLE_ID) REFERENCES ROLE(ID);
    
    ADD PAYMENT_ID INTEGER;
    
    ADD FOREIGN KEY(PAYMENT_ID) REFERENCES PAYMENT(ID);

    ADD SHIPMENT_ID INTEGER;
    
    ADD FOREIGN KEY(SHIPMENT_ID) REFERENCES SHIPMENT(ID);

