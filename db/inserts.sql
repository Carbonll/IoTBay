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

INSERT INTO IOTUSER.PRODUCT(PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_PRICE, PRODUCT_STOCK) VALUES 
('PIR Motion Sensor', 'Motion Sensor', 2.00, 100),
('Si4703 Radio Receiver', 'Wireless Sensor', 10.00, 100),
('Relais', 'Power Supply', 4.00, 100);
