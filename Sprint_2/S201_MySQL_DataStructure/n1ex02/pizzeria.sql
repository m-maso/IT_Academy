-- CREATING DATABASE --

DROP DATABASE IF EXISTS pizzeria;
CREATE DATABASE pizzeria CHARACTER SET utf8mb4;
USE pizzeria;

CREATE TABLE province(
    province_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    PRIMARY KEY(province_id)
);

CREATE TABLE town_city(
    town_city_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(30) NOT NULL,
    fk_province_id INT NOT NULL,
    PRIMARY KEY(town_city_id),
    FOREIGN KEY(fk_province_id) REFERENCES province(province_id)
);

CREATE TABLE customer(
    cust_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(25) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    address VARCHAR(100) NOT NULL,
    postcode VARCHAR(10) NOT NULL,
    phone VARCHAR(25) NOT NULL,
    fk_town_city_id INT NOT NULL,
    fk_province_id INT NOT NULL,
    PRIMARY KEY(cust_id),
    FOREIGN KEY(fk_town_city_id) REFERENCES town_city(town_city_id),
    FOREIGN KEY(fk_province_id) REFERENCES province(province_id)
);

CREATE TABLE pizzeria(
    pizzeria_id INT NOT NULL AUTO_INCREMENT,
    address VARCHAR(100) NOT NULL,
    postcode VARCHAR(10) NOT NULL,
    fk_town_city_id INT NOT NULL,
    fk_province_id INT NOT NULL,
    PRIMARY KEY(pizzeria_id),
    FOREIGN KEY(fk_town_city_id) REFERENCES town_city(town_city_id),
    FOREIGN KEY(fk_province_id) REFERENCES province(province_id)
);

CREATE TABLE employee(
    employee_id INT NOT NULL AUTO_INCREMENT,
    first_name VARCHAR(25) NOT NULL,
    last_name VARCHAR(30) NOT NULL,
    NIF VARCHAR(9) NOT NULL UNIQUE,
    phone VARCHAR(25) NOT NULL,
    job_title ENUM('delivery_driver','cook'),
    fk_pizzeria_id INT NOT NULL,
    PRIMARY KEY(employee_id),
    FOREIGN KEY(fk_pizzeria_id) REFERENCES pizzeria(pizzeria_id)
);

CREATE TABLE home_delivery(
    home_delivery_id INT NOT NULL AUTO_INCREMENT,
    delivery_date_time DATETIME NOT NULL,
    fk_employee_id INT NOT NULL,
    PRIMARY KEY(home_delivery_id),
    FOREIGN KEY(fk_employee_id) REFERENCES employee(employee_id)
);

CREATE TABLE invoice(
    invoice_id INT NOT NULL AUTO_INCREMENT,
    date_hour DATETIME NOT NULL,
    delivery_type ENUM('home_delivery','click&collect') NOT NULL,
    total_price DECIMAL(10,2) NOT NULL,
    fk_cust_id INT NOT NULL,
    fk_pizzeria_id INT NOT NULL,
    fk_home_delivery INT, 
    PRIMARY KEY(invoice_id),
    FOREIGN KEY(fk_cust_id) REFERENCES customer(cust_id),
    FOREIGN KEY(fk_pizzeria_id) REFERENCES pizzeria(pizzeria_id),
    FOREIGN KEY(fk_home_delivery) REFERENCES home_delivery(home_delivery_id)
);

CREATE TABLE pizza_categories(
    pizza_categories_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45),
    PRIMARY KEY(pizza_categories_id)
);

CREATE TABLE product(
    product_id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(45) NOT NULL,
    description TEXT(300),
    image LONGBLOB,
    price DECIMAL(10,2) NOT NULL,
    product_category ENUM('pizza','hamburger','drink') NOT NULL,
    fk_pizza_categories_id INT,
    PRIMARY KEY(product_id),
    FOREIGN KEY(fk_pizza_categories_id) REFERENCES pizza_categories(pizza_categories_id)
);

CREATE TABLE invoice_has_product(
    invoice_invoice_id INT NOT NULL AUTO_INCREMENT,
    product_product_id INT NOT NULL,
    quantity INT NOT NULL,
    FOREIGN KEY(invoice_invoice_id) REFERENCES invoice(invoice_id),
    FOREIGN KEY(product_product_id) REFERENCES product(product_id)
);
ALTER TABLE invoice_has_product ADD PRIMARY KEY(invoice_invoice_id, product_product_id);

-- INSERTING DATA --

-- PROVINCE
INSERT INTO province VALUES(1, 'Greater London');
INSERT INTO province VALUES(2, 'Bedfordshire');
INSERT INTO province VALUES(3, 'North Yorkshire');
INSERT INTO province VALUES(4, 'Oxfordshire');
INSERT INTO province VALUES(5, 'West Yorkshire');

-- TOWN-CITY
INSERT INTO town_city VALUES(1, 'London', 1);
INSERT INTO town_city VALUES(2, 'Bedford', 2);
INSERT INTO town_city VALUES(3, 'York', 3);
INSERT INTO town_city VALUES(4, 'Oxford', 4);
INSERT INTO town_city VALUES(5, 'Leeds', 5);

-- CUSTOMER
INSERT INTO customer VALUES(1, 'John', 'White', '165, Fleet Road. 3 2A','E1 8RU', '677985432', 1, 1);
INSERT INTO customer VALUES(2, 'Audrey', 'Smith', '5, Fake Road', 'N1 8RU', '667235698', 2, 2);
INSERT INTO customer VALUES(3, 'James','Black', '64, Barbican Road', 'S1 8RU', '677985430', 3, 3);
INSERT INTO customer VALUES(4, 'Maria','Town','123, Oxford Road', 'W1 8RU', '667098543', 4, 4);

-- PIZZERIA
INSERT INTO pizzeria VALUES(1, '5, Oxford Street', 'E5 23BR', 1, 1 );
INSERT INTO pizzeria VALUES(2, '34, Cambridge Road', 'N5 89BR', 5, 5);
INSERT INTO pizzeria VALUES(3, '87, Fleet Street', 'W5 28BR', 4, 4);

-- EMPLOYEE
INSERT INTO employee VALUES(1, 'Alex', 'Wood', '24135768S', '678394201','cook', 1);
INSERT INTO employee VALUES(2, 'Sophia', 'Adams', '03579068C', '6779426301', 'delivery_driver', 2);
INSERT INTO employee VALUES(3, 'Johnny', 'Waters', '10345768L', '677472621', 'cook', 3);
INSERT INTO employee VALUES(4, 'Caterine', 'Tree', '98641034D', '667364286','delivery_driver', 1);

-- HOME_DELIVERY
INSERT INTO home_delivery VALUES(1, '2023-10-29 14:45:35', 2);
INSERT INTO home_delivery VALUES(2, '2023-10-30 13:45:35', 4);

-- INVOICE
INSERT INTO invoice VALUES(1, '2023-10-30 09:53:12', 'home_delivery', 56.67, 1, 2, 1);
INSERT INTO invoice VALUES(2, '2023-10-30 12:05:23', 'click&collect', 23.75, 2, 1, NULL);
INSERT INTO invoice VALUES(3, '2023-10-30 10:49:51', 'home_delivery', 14.0, 3, 1, 2);
INSERT INTO invoice VALUES(4, '2023-10-30 17:36:27', 'click&collect', 28.89, 4, 3, NULL);

-- PIZZA_CATEGORIES
INSERT INTO pizza_categories VALUES(1, 'margherita');
INSERT INTO pizza_categories VALUES(2, 'diavola');
INSERT INTO pizza_categories VALUES(3, 'four seasons');

-- PRODUCT
INSERT INTO product VALUES(1, 'pizza', NULL, NULL, 18.89, 'pizza', 1);
INSERT INTO product VALUES(2, 'hamburger', NULL, NULL, 4.75, 'hamburger', NULL);
INSERT INTO product VALUES(3, 'orange juice', NULL, NULL, 3.50, 'drink', NULL);
INSERT INTO product VALUES(4, 'pizza familiar', NULL, NULL, 28.89, 'pizza', 2);

-- INVOICE_HAS_PRODUCT
INSERT INTO invoice_has_product VALUES(1, 1, 3);
INSERT INTO invoice_has_product VALUES(2, 2, 5);
INSERT INTO invoice_has_product VALUES(3, 3, 4);
INSERT INTO invoice_has_product VALUES(4, 4, 1);