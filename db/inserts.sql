/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Author:  melvi
 * Created: 08/05/2021
 */

INSERT INTO IOTUSER.ROLE
    (ID, ROLE_NAME) VALUES
    (1, 'System Admin'),
    (2, 'Staff'),
    (3, 'Customer');

INSERT INTO IOTUSER."USER" 
    ("NAME", EMAIL, PASSWORD, ROLE_ID) VALUES
    ('admin', 'admin@iotbay.com', 'admin', 1);

