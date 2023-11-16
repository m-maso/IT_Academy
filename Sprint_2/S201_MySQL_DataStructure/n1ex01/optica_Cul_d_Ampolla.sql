-- CREATING DATABASE --

DROP DATABASE IF EXISTS cul_d_ampolla;
CREATE DATABASE cul_d_ampolla CHARACTER SET utf8mb4;
USE cul_d_ampolla;

CREATE TABLE address(
    address_id INT NOT NULL AUTO_INCREMENT,
    road VARCHAR(60) NOT NULL,
    num INT NOT NULL,
    floor INT NOT NULL, 
    door VARCHAR(4) NOT NULL,  
    city VARCHAR(30) NOT NULL,
    postcode VARCHAR(10) NOT NULL,
    country VARCHAR(30) NOT NULL,
    PRIMARY KEY(address_id)
);

CREATE TABLE supplier (
    supplier_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(25) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    NIF VARCHAR(9) NOT NULL UNIQUE,
    phone VARCHAR(25) NOT NULL,
    fax VARCHAR(25),
    fk_address_id INT NOT NULL,
    PRIMARY KEY(supplier_id),
    FOREIGN KEY(fk_address_id) REFERENCES address(address_id)
);

CREATE TABLE brand(
    brand_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    fk_supplier_id INT NOT NULL,
    PRIMARY KEY(brand_id),
    FOREIGN KEY(fk_supplier_id) REFERENCES supplier(supplier_id)
);

CREATE TABLE lenses(
    lenses_id INT NOT NULL AUTO_INCREMENT,
    price DECIMAL(10,2) NOT NULL,
    left_lens_prescription FLOAT NOT NULL,
    right_lens_prescription FLOAT NOT NULL,
    frame_type ENUM('rimless','plastic','metal') NOT NULL,
    frame_colour VARCHAR(25) NOT NULL,
    left_lens_colour VARCHAR(25) NOT NULL,
    right_lens_colour VARCHAR(25) NOT NULL,
    fk_supplier_id INT NOT NULL,
    fk_brand_id INT NOT NULL,
    PRIMARY KEY(lenses_id),
    FOREIGN KEY(fk_supplier_id) REFERENCES supplier(supplier_id),
    FOREIGN KEY(fk_brand_id) REFERENCES brand(brand_id)
);

CREATE TABLE customer(
    cust_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(25) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    phone VARCHAR(25) NOT NULL,
    email VARCHAR(60) NOT NULL,
    register_date DATETIME NOT NULL,
    fk_address_id INT NOT NULL,
    fk_recommended_cust_id INT,
    PRIMARY KEY(cust_id),
    FOREIGN KEY(fk_address_id) REFERENCES address(address_id),
    FOREIGN KEY(fk_recommended_cust_id) REFERENCES customer(cust_id)
);

CREATE TABLE employee(
    employee_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(25) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    PRIMARY KEY(employee_id)
);

CREATE TABLE invoice(
    invoice_id INT NOT NULL AUTO_INCREMENT,
    date DATETIME NOT NULL,
    fk_lenses_id INT NOT NULL,
    fk_cust_id INT NOT NULL,
    fk_employee_id INT NOT NULL,
    PRIMARY KEY(invoice_id),
    FOREIGN KEY(fk_lenses_id) REFERENCES lenses(lenses_id),
    FOREIGN KEY(fk_cust_id) REFERENCES customer(cust_id),
    FOREIGN KEY(fk_employee_id) REFERENCES employee(employee_id)
);


-- INSERTING DATA --

-- ADDRESS
INSERT INTO address VALUES(1, 'Fleet Road', 165, 3, '2A', 'Blackpool', 'S2 45B', 'United Kingdom');
INSERT INTO address VALUES(2, 'Fleet Road', 5, 1, '1B', 'London', 'N1 31P', 'United Kingdom');
INSERT INTO address VALUES(3, 'Oxford Road', 64, 7,'3C', 'Leeds', 'W2 29Q', 'United Kingdom');
INSERT INTO address VALUES(4, 'Fleet Road', 165, 3, '2A', 'Manchester', 'E2 45A', 'United Kingdom');
INSERT INTO address VALUES(5, 'Fleet Road', 165, 3, '2A', 'York', 'S2 45B', 'United Kingdom');
INSERT INTO address VALUES(6, 'Fleet Road', 5, 1, '1B', 'Durban', 'N1 31P', 'United Kingdom');
INSERT INTO address VALUES(7, 'Oxford Road', 64, 7, '3C', 'Bradford', 'W2 29Q', 'United Kingdom');
INSERT INTO address VALUES(8, 'Fleet Road', 165, 3, '2A', 'Edinburgh', 'E2 45A', 'United Kingdom');

-- SUPPLIER
INSERT INTO supplier VALUES(1, 'John', 'White', '12345678A', '677985432', NULL, 5);
INSERT INTO supplier VALUES(2, 'Audrey','Smith','98765432Z', '667235698', '937773322', 6);
INSERT INTO supplier VALUES(3, 'James','Black','54312398G', '677985430', NULL, 7);
INSERT INTO supplier VALUES(4, 'Maria','Town','78965432H', '667098543', '932221133', 8);

-- BRAND (only supplier 1 sell brand_id 2 for best prices)
INSERT INTO brand VALUES(1, 'Police', 3);
INSERT INTO brand VALUES(2, 'Oakley', 1); 
INSERT INTO brand VALUES(3, 'Ray Ban', 2);
INSERT INTO brand VALUES(4, 'Police', 1);
INSERT INTO brand VALUES(5, 'Ray Ban', 4);

-- LENSES
INSERT INTO lenses VALUES(1, 375.98, 0.5, 2.75, 'metal', 'blue', 'ligthblue', 'ligthblue', 1, 2);
INSERT INTO lenses VALUES(2, 375.98, 0.5, 2.75, 'plastic', 'red', 'ligthblue', 'ligthblue', 3, 1);
INSERT INTO lenses VALUES(3, 375.98, 0.5, 2.75, 'plastic', 'red', 'ligthblue', 'ligthblue', 1, 1);
INSERT INTO lenses VALUES(4, 375.98, 0.5, 2.75, 'rimless', 'black', 'transparent', 'transparent', 1, 2);
INSERT INTO lenses VALUES(5, 375.98, 0.5, 2.75, 'metal', 'green', 'ligthgreen', 'ligthgreen', 2, 3);
INSERT INTO lenses VALUES(6, 375.98, 0.5, 2.75, 'plastic', 'green', 'ligthgreen', 'ligthgreen', 4, 3);

-- CUSTOMER
INSERT INTO customer VALUES(1, 'John', 'White', '677985432', 'john.white@gmx.com', '2023-10-25', 1, NULL);
INSERT INTO customer VALUES(2, 'Audrey', 'Smith', '667235698', 'audrey02@gmail.com', '2023-10-30', 2, 1);
INSERT INTO customer VALUES(3, 'James', 'Black', '677985430', 'jamesblack@yahoo.com', '2023-11-23', 3, 2);
INSERT INTO customer VALUES(4, 'Maria', 'Town', '667098543', 'maria.town@proton.com', '2023-10-27', 4, NULL);

-- EMPLOYEE
INSERT INTO employee VALUES(1, 'Alex', 'Wood');
INSERT INTO employee VALUES(2, 'Sophia', 'Adams');
INSERT INTO employee VALUES(3, 'Johnny', 'Waters');
INSERT INTO employee VALUES(4, 'Caterine', 'Tree');

-- INVOICE
INSERT INTO invoice VALUES(1, '2023-10-25 10:15:35', 2, 1, 4);
INSERT INTO invoice VALUES(2, '2023-10-30 09:00:30', 1, 2, 3);
INSERT INTO invoice VALUES(3, '2023-11-23 10:15:35', 4, 3, 2);
INSERT INTO invoice VALUES(4, '2023-10-27 09:00:30', 3, 4, 1);
INSERT INTO invoice VALUES(5, '2023-11-25 10:15:35', 2, 1, 4);
INSERT INTO invoice VALUES(6, '2023-12-30 09:00:30', 1, 1, 3);
INSERT INTO invoice VALUES(7, '2023-12-23 10:15:35', 4, 3, 2);
INSERT INTO invoice VALUES(8, '2024-01-27 09:00:30', 3, 4, 1);