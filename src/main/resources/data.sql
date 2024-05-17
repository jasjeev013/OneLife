
CREATE TABLE `customer` (
                            `customer_id` int NOT NULL AUTO_INCREMENT,
                            `name` varchar(100) NOT NULL,
                            `email` varchar(100) NOT NULL,
                            `mobile_number` varchar(20) NOT NULL,
                            `pwd` varchar(500) NOT NULL,
                            `role` varchar(100) NOT NULL,
                            `create_dt` date DEFAULT NULL,
                            PRIMARY KEY (`customer_id`)
);

INSERT INTO `customer` (`name`,`email`,`mobile_number`, `pwd`, `role`,`create_dt`)
VALUES ('Happy','happy@example.com','9876548337', '$2y$12$oRRbkNfwuR8ug4MlzH5FOeui.//1mkd.RsOAJMbykTSupVy.x/vb2', 'ADMIN',CURDATE());

CREATE TABLE hospital (
                  hospital_id INT PRIMARY KEY,
                  hospital_name VARCHAR(255),
                  hospital_address VARCHAR(255),
                  hospital_phone_number VARCHAR(15),
                  hospital_state VARCHAR(50),
                  zip_code VARCHAR(10)
);
CREATE TABLE department (
                department_id INT,
                hospital_id INT,
                hospital_hospital_id INT,
                department_name VARCHAR(255),
                PRIMARY KEY (department_id, hospital_id),
                FOREIGN KEY (hospital_hospital_id) REFERENCES hospital(hospital_id)
);
CREATE TABLE doctor (
                doctor_id INT,
                hospital_id INT,
                department_department_id INT,
                department_hospital_id INT,
                doctor_f_name VARCHAR(50),
                doctor_l_name VARCHAR(50),
                doctor_phone_number VARCHAR(255),
                PRIMARY KEY (doctor_id, hospital_id),
                FOREIGN KEY (department_department_id,department_hospital_id) REFERENCES department(department_id,hospital_id)
);
CREATE TABLE staff (
               staff_id INT,
               hospital_id INT,
               department_department_id INT,
               department_hospital_id INT,
               staff_f_name VARCHAR(50),
               staff_l_name VARCHAR(50),
               staff_address VARCHAR(255),
               staff_phone_number VARCHAR(15),
               PRIMARY KEY (staff_id, hospital_id),
               FOREIGN KEY (department_department_id,department_hospital_id) REFERENCES department(department_id,hospital_id)
);
CREATE TABLE pharmacy (
              pharmacy_id INT,
              hospital_id INT,
              pharmacy_name VARCHAR(255),
              pharmacy_address VARCHAR(255),
              pharmacy_phone_number VARCHAR(15),
              PRIMARY KEY (pharmacy_id, hospital_id)
);
CREATE TABLE patient (
                 patient_id INT,
                 hospital_id INT,
                 pharmacy_pharmacy_id INT,
                 pharmacy_hospital_id INT,
                 patient_f_name VARCHAR(50),
                 patient_l_name VARCHAR(50),
                 patient_address VARCHAR(255),
                 patient_phone_number VARCHAR(15),
                 PRIMARY KEY (patient_id, hospital_id),
                 FOREIGN KEY (pharmacy_pharmacy_id,pharmacy_hospital_id) REFERENCES pharmacy(pharmacy_id,hospital_id)
);
CREATE TABLE invoice (
                 invoice_id INT,
                 hospital_id INT,
                 patient_patient_id INT,
                 patient_hospital_id INT,
                 service_description VARCHAR(255),
                 cost INT,
                 total INT,
                 PRIMARY KEY (invoice_id, hospital_id),
                 FOREIGN KEY (patient_patient_id,patient_hospital_id) REFERENCES patient(patient_id,hospital_id)
);
CREATE TABLE prescription (
                  prescription_id INT,
                  hospital_id INT,
                  patient_patient_id INT,
                  patient_hospital_id INT,
                  prescription_number VARCHAR(50),
                  medication_name VARCHAR(255),
                  prescription_date VARCHAR(255),
                  prescription_cost INT,
                  PRIMARY KEY (prescription_id, hospital_id),
                  FOREIGN KEY (patient_patient_id,patient_hospital_id) REFERENCES patient(patient_id,hospital_id)
);
CREATE TABLE appointment (
                 doctor_id INT,
                 patient_id INT,
                 hospital_id INT,
                 patient_patient_id INT,
                 patient_hospital_id INT,
                 doctor_doctor_id INT,
                 doctor_hospital_id INT,
                 time VARCHAR(255),
                 date VARCHAR(255),
                 PRIMARY KEY (hospital_id, patient_id,doctor_id),
                 FOREIGN KEY (patient_patient_id,patient_hospital_id) REFERENCES patient(patient_id,hospital_id),
                 FOREIGN KEY (doctor_doctor_id,doctor_hospital_id) REFERENCES doctor(doctor_id,hospital_id)
);


INSERT INTO hospital (hospital_id, hospital_name, hospital_address, hospital_phone_number, hospital_state, zip_code) VALUES
(1, 'City General Hospital', '123 Main St', '555-1234', 'State', '12345'),
(2, 'Metropolitan Hospital', '456 Elm St', '555-5678', 'State', '23456'),
(3, 'Unity Hospital', '789 Oak St', '555-7890', 'State', '34567'),
(4, 'Community Hospital', '101 Pine St', '555-8901', 'State', '45678');
INSERT INTO department (department_id, hospital_id, hospital_hospital_id, department_name) VALUES
(1, 1, 1, 'Cardiology'),
(2, 1, 1, 'Neurology'),
(3, 2, 2, 'Pediatrics'),
(4, 3, 3, 'Orthopedics');
INSERT INTO doctor (doctor_id, hospital_id, department_department_id, department_hospital_id, doctor_f_name, doctor_l_name,doctor_phone_number) VALUES
(1, 1, 1, 1, 'John', 'Doe','667-234'),
(2, 1, 2, 1, 'Jane', 'Smith','342-123'),
(3, 2, 3, 2, 'Michael', 'Johnson','521-553'),
(4, 3, 4, 3, 'Emily', 'Brown','342-123');
INSERT INTO staff (staff_id, hospital_id, department_department_id, department_hospital_id, staff_f_name, staff_l_name, staff_address, staff_phone_number) VALUES
(1, 1, 1, 1, 'Alice', 'Williams', '789 Oak St', '555-6789'),
(2, 1, 2, 1, 'David', 'Miller', '101 Pine St', '555-7890'),
(3, 2, 3, 2, 'Emily', 'Davis', '202 Cedar St', '555-8901'),
(4, 3, 4, 3, 'Michael', 'Clark', '303 Elm St', '555-9012');
INSERT INTO pharmacy (pharmacy_id, hospital_id, pharmacy_name, pharmacy_address, pharmacy_phone_number) VALUES
(1, 1, 'Hospital Pharmacy 1', '101 Maple Ave', '555-2345'),
(2, 2, 'Hospital Pharmacy 2', '303 Oak St', '555-3456'),
(3, 3, 'Hospital Pharmacy 3', '404 Pine St', '555-4567'),
(4, 4, 'Hospital Pharmacy 4', '505 Elm St', '555-5678');
INSERT INTO patient (patient_id, hospital_id, pharmacy_pharmacy_id, pharmacy_hospital_id, patient_f_name, patient_l_name, patient_address, patient_phone_number) VALUES
(1, 1, 1, 1, 'Michael', 'Smith', '102 Pine St', '555-6789'),
(2, 1, 1, 1, 'Emily', 'Davis', '103 Cedar St', '555-7890'),
(3, 2, 2, 2, 'James', 'Wilson', '104 Oak St', '555-8901'),
(4, 3, 3, 3, 'Sarah', 'Taylor', '105 Elm St', '555-9012');
INSERT INTO invoice (invoice_id, hospital_id, patient_patient_id, patient_hospital_id, service_description, cost, total) VALUES
(1, 1, 1, 1, 'Consultation', 100, 100),
(2, 1, 2, 1, 'Medication', 50, 50),
(3, 2, 3, 2, 'Lab Test', 75, 75),
(4, 3, 4, 3, 'X-ray', 90, 90);
INSERT INTO prescription (prescription_id, hospital_id, patient_patient_id, patient_hospital_id, prescription_number, medication_name, prescription_date, prescription_cost) VALUES
(1, 1, 1, 1, 'RX123', 'Aspirin', '2024-05-08', 20),
(2, 1, 2, 1, 'RX456', 'Tylenol', '2024-05-09', 30),
(3, 2, 3, 2, 'RX789', 'Amoxicillin', '2024-05-10', 40),
(4, 3, 4, 3, 'RX101', 'Ibuprofen', '2024-05-11', 25);
INSERT INTO appointment (doctor_id, patient_id, hospital_id, patient_patient_id, patient_hospital_id, doctor_doctor_id, doctor_hospital_id, time, date) VALUES
(1, 1, 1, 1, 1, 1, 1, '09:00 AM', '2024-05-10'),
(2, 2, 1, 2, 1, 2, 1, '10:30 AM', '2024-05-11'),
(3, 3, 2, 3, 2, 3, 2, '11:00 AM', '2024-05-12'),
(4, 4, 3, 4, 3, 4, 3, '02:00 PM', '2024-05-13');

CREATE TABLE `authorities` (
                               `id` int NOT NULL AUTO_INCREMENT,
                               `customer_id` int NOT NULL,
                               `name` varchar(50) NOT NULL,
                               PRIMARY KEY (`id`),
                               KEY `customer_id` (`customer_id`),
                               CONSTRAINT `authorities_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer`(`customer_id`)
);



INSERT INTO `authorities` (`customer_id`, `name`)
VALUES (1, 'ROLE_USER');

INSERT INTO `authorities` (`customer_id`, `name`)
VALUES (1, 'ROLE_ADMIN');
