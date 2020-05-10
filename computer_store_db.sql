CREATE DATABASE computer_store_db;

USE computer_store_db;

CREATE TABLE suppliers (
supplier_id INT AUTO_INCREMENT PRIMARY KEY,
supplier_name VARCHAR(100) NOT NULL,
supplier_representative VARCHAR (100) NOT NULL,
supplier_address VARCHAR (100) NOT NULL,
phone_number VARCHAR(25) NOT NULL);

CREATE TABLE deliveries (
delivery_id BIGINT AUTO_INCREMENT PRIMARY KEY,
supplier_id INT NOT NULL,
delivery_date DATE NOT NULL,
FOREIGN KEY (supplier_id) REFERENCES suppliers (supplier_id) ON DELETE RESTRICT ON UPDATE RESTRICT);

CREATE TABLE products (
product_id BIGINT AUTO_INCREMENT PRIMARY KEY,
delivery_id BIGINT NOT NULL,
product_type ENUM ('PC', 'LAPTOP') NOT NULL,
product_name VARCHAR(100) NOT NULL,
product_description TEXT NOT NULL,
product_quantity INT NOT NULL,
purchase_price DECIMAL(10, 2) UNSIGNED NOT NULL,
selling_price DECIMAL(10, 2) UNSIGNED NOT NULL,
FOREIGN KEY (delivery_id) REFERENCES deliveries (delivery_id) ON DELETE RESTRICT ON UPDATE RESTRICT);

CREATE TABLE employees (
employee_id INT AUTO_INCREMENT PRIMARY KEY,
employee_password VARCHAR(255),
employee_name VARCHAR(100) NOT NULL,
employee_birth DATE NOT NULL, 
employee_position ENUM ('ADMINISTRATOR', 'DIRECTOR', 'ACCOUNTANT', 'MANAGER', 'SELLER') NOT NULL,
employee_address VARCHAR (100) NOT NULL,
phone_number VARCHAR(25) NOT NULL,
employee_salary DECIMAL(10, 2) UNSIGNED NOT NULL);

CREATE TABLE orders (
order_id BIGINT AUTO_INCREMENT PRIMARY KEY,
product_id BIGINT NOT NULL,
employee_id INT NOT NULL,
product_quantity INT NOT NULL DEFAULT 1,
total_amount DECIMAL(10, 2) UNSIGNED NOT NULL,
order_date TIMESTAMP NOT NULL,
FOREIGN KEY (product_id) REFERENCES products (product_id) ON DELETE RESTRICT ON UPDATE RESTRICT,
FOREIGN KEY (employee_id) REFERENCES employees (employee_id) ON DELETE RESTRICT ON UPDATE RESTRICT);

ALTER TABLE products AUTO_INCREMENT = 1001;

ALTER TABLE employees AUTO_INCREMENT = 101;


INSERT INTO suppliers (supplier_name, supplier_representative, supplier_address, phone_number) VALUES
('ООО "МАСТ ИМПОРТ"', 'Андрианова Мария Александровна', 'г. Москва, 3-я улица Ямского Поля, д. 2, корп. 12', '+7 (499) 641-06-11');

INSERT INTO suppliers (supplier_name, supplier_representative, supplier_address, phone_number) VALUES
('ООО "К-Компьютерс"', 'Картечкин Максим Эдуардович', 'г. Москва, ул. Полярная, д. 33, стр. 3', '+7 (499) 506-86-90');

INSERT INTO suppliers (supplier_name, supplier_representative, supplier_address, phone_number) VALUES
('ООО "Технология"', 'Перковский Роман Анатольевич', 'г. Москва, Тетеринский пер., д. 16', '+7 (495) 783-26-18');


INSERT INTO deliveries (supplier_id, delivery_date) VALUES (1, '2020-01-10');

INSERT INTO deliveries (supplier_id, delivery_date) VALUES (3, '2020-01-31');

INSERT INTO deliveries (supplier_id, delivery_date) VALUES (2, '2020-02-07');

INSERT INTO deliveries (supplier_id, delivery_date) VALUES (3, '2020-02-28');

INSERT INTO deliveries (supplier_id, delivery_date) VALUES (1, '2020-03-15');

INSERT INTO deliveries (supplier_id, delivery_date) VALUES (2, '2020-04-01');


INSERT INTO employees (employee_password, employee_name, employee_birth, employee_position, employee_address, phone_number, employee_salary) VALUES
('123qwe', 'Бакайкин Алексей Петрович', '1998-12-11', 'ADMINISTRATOR', 'г. Москва, ул. Инженерная, д. 77, кв. 20', '+7 (978) 348-41-14', '75000');

INSERT INTO employees (employee_password, employee_name, employee_birth, employee_position, employee_address, phone_number, employee_salary) VALUES
('123qwe', 'Семёнов Кирилл Вячеславович', '1979-08-08', 'DIRECTOR', 'г. Москва, ул. Красного Маяка, д. 70, кв. 5', '+7 (974) 543-56-75', '100000');

INSERT INTO employees (employee_password, employee_name, employee_birth, employee_position, employee_address, phone_number, employee_salary) VALUES
('123qwe', 'Девятова Анастасия Александровна', '1987-03-15', 'ACCOUNTANT', 'г. Москва, ул. Свободы, д. 127, кв. 10', '+7 (998) 312-64-84', '60000');

INSERT INTO employees (employee_password, employee_name, employee_birth, employee_position, employee_address, phone_number, employee_salary) VALUES
('123qwe', 'Беленко Кристина Николаевна', '1985-11-03', 'MANAGER', 'г. Москва, ул. Академика Королёва, д. 32, кв. 2', '+7 (916) 476-12-66', '75000');

INSERT INTO employees (employee_password, employee_name, employee_birth, employee_position, employee_address, phone_number, employee_salary) VALUES
('123qwe', 'Попова Анна Владимировна', '1990-12-12', 'SELLER', 'г. Москва, ул. Красногвардейская, д. 3, кв. 17', '+7 (954) 636-03-46', '50000');

INSERT INTO employees (employee_password, employee_name, employee_birth, employee_position, employee_address, phone_number, employee_salary) VALUES
('123qwe', 'Исаев Иван Алексеевич', '1993-03-25', 'SELLER', 'г. Москва, ул. Рождественская, д. 123, кв. 54', '+7 (967) 348-74-85', '50000');

INSERT INTO employees (employee_password, employee_name, employee_birth, employee_position, employee_address, phone_number, employee_salary) VALUES
('123qwe', 'Котов Николай Валерьевич', '1988-10-01', 'SELLER', 'г. Москва, ул. Осенняя, д. 3, кв. 5', '+7 (933) 323-09-56', '50000');


INSERT INTO products (delivery_id, product_type, product_name, product_description, product_quantity, purchase_price, selling_price)
VALUES (1, 'PC', 'LENOVO V330-15IGM',
        'Процессор: Intel Celeron J4005; Видеокарта: Intel UHD Graphics 600; RAM: 4 Гб; SSD: 128 Гб; БП: 65 Вт; Цвет: Чёрный; OS: Windows',
        '25', '10000', '12990');

INSERT INTO products (delivery_id, product_type, product_name, product_description, product_quantity, purchase_price, selling_price)
VALUES (2, 'PC', 'ACER Aspire XC-830',
        'Процессор: Intel Celeron J4005; Видеокарта: Intel UHD Graphics 600; RAM: 4 Гб; SSD: 128 Гб; БП: 65 Вт; Цвет: Чёрный; OS: Windows',
        '30', '9500', '12990');

INSERT INTO products (delivery_id, product_type, product_name, product_description, product_quantity, purchase_price, selling_price)
VALUES (4, 'LAPTOP', 'LENOVO IdeaPad S145-15AST',
        'Процессор: AMD A9 9425; Видеокарта: AMD Radeon R5; RAM: 8 Гб; SSD: 128 Гб; Разрешение экрана: 1920×1080; Цвет: Чёрный; Вес: 1,85 кг; OS: Free DOS',
        '25', '22000', '24990');

INSERT INTO products (delivery_id, product_type, product_name, product_description, product_quantity, purchase_price, selling_price)
VALUES (6, 'PC', 'DELL Optiplex 5070',
        'Процессор: Intel Core i7 9700; Видеокарта: Intel UHD Graphics 630; RAM: 8 Гб; SSD: 256 Гб; БП: 200 Вт; Цвет: Чёрный; OS: Windows',
        '10', '67000', '71990');

INSERT INTO products (delivery_id, product_type, product_name, product_description, product_quantity, purchase_price, selling_price)
VALUES (3, 'LAPTOP', 'ASUS Zenbook UX431FA-AN070T',
        'Процессор: Intel Core i3 8145U; Видеокарта: Intel UHD Graphics; RAM: 4 Гб; SSD: 256 Гб; Разрешение экрана: 1920×1080; Цвет: Голубой; Вес: 1,48 кг; OS: Windows',
        '20', '40000', '50990');

INSERT INTO products (delivery_id, product_type, product_name, product_description, product_quantity, purchase_price, selling_price)
VALUES (5, 'LAPTOP', 'ASUS FX570UD-DM187',
        'Процессор: Intel Core i5 8250U; Видеокарта: nVidia GeForce GTX 1050; RAM: 6 Гб; SSD: 256 Гб; Разрешение экрана: 1920×1080; Цвет: Чёрный; Вес: 1,96 кг; OS: Windows',
        '30', '45000', '49990');

INSERT INTO products (delivery_id, product_type, product_name, product_description, product_quantity, purchase_price, selling_price)
VALUES (4, 'PC', 'MSI Codex 9SA-087RU',
        'Процессор: Intel Core i5 9400F; Видеокарта: nVidia GeForce GTX 1650; RAM: 8 Гб; SSD: 256 Гб, HDD: 1 Тб; БП: 300 Вт; Цвет: Чёрный; OS: Windows',
        '5', '50000', '56990');


INSERT INTO orders (product_id, employee_id, product_quantity, total_amount, order_date)
VALUES (1002, 102, 2, '25980', '2020-04-12 15:25:00');

INSERT INTO orders (product_id, employee_id, product_quantity, total_amount, order_date)
VALUES (1006, 105, 1, '49990', '2020-04-13 14:40:00');

INSERT INTO orders (product_id, employee_id, product_quantity, total_amount, order_date)
VALUES (1004, 106, 1, '71990', '2020-04-14 16:35:00');

INSERT INTO orders (product_id, employee_id, product_quantity, total_amount, order_date)
VALUES (1007, 104, 1, '56990', '2020-04-15 11:20:00');

INSERT INTO orders (product_id, employee_id, product_quantity, total_amount, order_date)
VALUES (1001, 107, 1, '12990', '2020-04-16 14:35:00');

