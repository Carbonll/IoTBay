/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  melvi
 * Created: 21/04/2021
 */

CREATE TABLE "USER" (
    ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY(START WITH 100000, INCREMENT BY 1),
    "NAME" VARCHAR(255) NOT NULL,
    EMAIL VARCHAR(255) NOT NULL,
    PHONE VARCHAR(10),
    PASSWORD VARCHAR(255) NOT NULL,
    PRIMARY KEY(ID)
);

