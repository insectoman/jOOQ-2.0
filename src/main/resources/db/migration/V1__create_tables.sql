CREATE TABLE customer
(
    id IDENTITY PRIMARY KEY,
    name VARCHAR(100),
    surname VARCHAR(100),
    phone_number VARCHAR(100) NOT NULL,
    email VARCHAR(200)
);

CREATE TABLE car
(
    id IDENTITY PRIMARY KEY ,
    brand VARCHAR(100) NOT NULL,
    model_year INTEGER NOT NULL,
    customer_id BIGINT,

    FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE "order"
(
    id IDENTITY PRIMARY KEY,
    price FLOAT,
    finished BOOLEAN NOT NULL DEFAULT false,
    finish_date DATE, --yyyy-MM-dd--
    description VARCHAR(2000) NOT NULL,
    car_id BIGINT,

    FOREIGN KEY (car_id) REFERENCES car(id)
);

CREATE TABLE mechanic
(
    id IDENTITY PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    surname VARCHAR(100) NOT NULL
);

CREATE TABLE mechanic_order
(
    id IDENTITY PRIMARY KEY,
    mechanic_id BIGINT,
    order_id BIGINT,

    FOREIGN KEY (mechanic_id) REFERENCES mechanic(id),
    FOREIGN KEY (order_id) REFERENCES "order"(id)
);

--------------------------------------------
--------------------------------------------
--------------------------------------------

INSERT INTO customer
(id, name, surname, phone_number, email)
VALUES (1, 'Piotr', 'Hendzel', '666604804', 'phendzel.dev@gmail.com'),
       (2, 'Adam', 'Adamski', '123602304', 'adamski@gmail.com'),
       (3, 'Stanislaw', 'Jodla', '435604544', 'stasz@gmail.com');

INSERT INTO car
(id, brand, model_year, customer_id)
values (1, 'VW', 2010, 1),
       (2, 'Audi', 2001, 2),
       (3, 'Skoda', 2012, 3),
       (4, 'BMW', 2015, 1);

INSERT INTO mechanic
(id, name, surname)
VALUES (1, 'Janusz', 'Jodlowski'),
       (2, 'Tomasz', 'Stachura'),
       (3, 'Andrzej', 'Kapec'),
       (4, 'Piotr', 'Jedrzejewski'),
       (5, 'Adam', 'Tworzydlo'),
       (6, 'Euzebiusz', 'Ibisz'),
       (7, 'Paweł', 'Alibaszka');

INSERT INTO "order"
(id, price, finished, finish_date, description, car_id)
VALUES (1, NULL, FALSE, NULL, 'Cos stuka w lewym kole.', 1),
       (2, 1250.00, TRUE, '2017-02-12', 'Wymiana rozrzadu.', 2),
       (3, 2250.00, TRUE, '2016-03-12', 'Wymiana rozrzadu po raz drugi.', 2),
       (4, 100.00, TRUE, '2015-10-01', 'Sprawdzenie stanu olejow.', 1);

INSERT INTO mechanic_order
(id, order_id, mechanic_id)
values (1, 1, 1),
       (2, 2, 1),
       (3, 3, 1),
       (4, 4, 1);
