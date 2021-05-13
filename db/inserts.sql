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

INSERT INTO IOTUSER.PRODUCT(PRODUCT_NAME, PRODUCT_CATEGORY, PRODUCT_PRICE, PRODUCT_STOCK) VALUES 
('Servo Motor', 'Motors', 2.00, 100),
('L293D', 'Motors', 2.00, 100),
('A4988', 'Motors', 6.00, 100),
('HD44780 Displays', 'Displays', 5.00, 100),
('7 Segment Display', 'Displays', 3.00, 100),
('Bluetooth Adapter', 'Wireless', 7.00, 100),
('GSM Surfstick', 'Wireless', 25.00, 100),
('Infrared Diodes', 'Wireless', 3.00, 100),
('Laser Module', 'Wireless', 2.00, 100),
('GP2Y0A02YK', 'Motion Sensor', 8.00, 100),
('USB GPS Receiver', 'Navigation', 10.00, 100),
('MPU-6050 Gyroscope', 'Navigation', 3.00, 100),
('DS1307 RTC', 'Navigation', 2.00, 100),
('Arduino', 'Other', 5.00, 100),
('Keypad', 'Other', 2.00, 100),
('Magnet Valve', 'Other', 2.00, 100),
('ULN2003', 'Motors', 4.00, 100);
